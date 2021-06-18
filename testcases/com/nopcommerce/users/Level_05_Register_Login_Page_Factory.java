package com.nopcommerce.users;

import java.util.Collections;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractPage;
import commons.AbstractTest;
import pageObjects.UserCustomerInfoPO;
import pageObjects.UserHomePO;
import pageObjects.UserLoginPO;
import pageObjects.UserRegisterPO;

/**
 * @author HienHT2
 *
 */
public class Level_05_Register_Login_Page_Factory extends AbstractTest{
	WebDriver driver;
	Select select;
	String firstName,lastName,Day,Month,Year,Mail,Company,Password;
	AbstractPage abstractPage;
	
	@Parameters("browser")
	
	@BeforeClass
	public void beforeClass( String browserName) {
		driver = getBrowserDriver(browserName);
		firstName="Hoang";
		lastName="Hien";
		Day="30";
		Month="August";
		Year="1994";
		Mail="hoanghien"+getRandomEmail()+"@gmail.com";
		Company="Cong ty Chưng khoan SSI";
		Password="123456";
		
	}
	@Test
	public void LevelTC01_Register() {
		homePage = new UserHomePO(driver);
		homePage.clickToRegisterLink();
		registerPage = new UserRegisterPO(driver);
		registerPage.clickToGenderMaleRadio();
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.selectDayDropdown(Day);
		registerPage.selectMonthDropDown(Month);
		registerPage.selectYearDropdown(Year);
		registerPage.inputToEmailTextbox(Mail);
		registerPage.inputToCompanyTextbox(Company);
		registerPage.inputToPasswordTextbox(Password);
		registerPage.inputToConfirmPasswordTextbox(Password);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		registerPage.clickToLogoutLink();
		homePage = new UserHomePO(driver);
	}
	@Test
	public void LevelTC02_Login() {   
		homePage.clickToLoginLink();
		loginPage = new UserLoginPO(driver);
		loginPage.inputToEmailTextbox(Mail);
		loginPage.inputToPasswordTextbox(Password);
		loginPage.clickToLoginButton();
		homePage = new UserHomePO(driver);
		
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		Assert.assertTrue(homePage.isLogoutLinkDisplayed());
	
	}
	@Test
	public void LevelTC03_View_MyAccount() {
		homePage.clickToMyAccounLink();
		customerInfoPage = new UserCustomerInfoPO(driver);
		
		Assert.assertTrue(customerInfoPage.isGenderMaleRadioButtonSelected());
		
		Assert.assertEquals(customerInfoPage.getFirstnameTextboxvalue(), firstName);
		Assert.assertEquals(customerInfoPage.getLastnameTextboxvalue(), lastName);
		
		Assert.assertEquals(customerInfoPage.getSelectedTextInDayDropdown(),Day);
		Assert.assertEquals(customerInfoPage.getSelectedTextInMonthDropdown(),Month);
		Assert.assertEquals(customerInfoPage.getSelectedTextInYearDropdown(),Year);
		
		Assert.assertEquals(customerInfoPage.getEmailTextboxvalue(), Mail);
		Assert.assertEquals(customerInfoPage.getCompanyTextboxvalue(), Company);
		Assert.assertTrue(customerInfoPage.isNewletterCheckboxSelected());
		
	}
	
	/**
	 * @return
	 */
	public int getRandomEmail() {
		 Random rand = new Random();
		 return rand.nextInt(9999);
		 
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	UserHomePO homePage;
    UserRegisterPO registerPage;
    UserCustomerInfoPO customerInfoPage;
    UserLoginPO loginPage;
}