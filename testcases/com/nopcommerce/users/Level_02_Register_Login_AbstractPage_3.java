package com.nopcommerce.users;

import static org.testng.Assert.assertEquals;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.AbstractPage;

/**
 * @author HienHT2
 *
 */
public class Level_02_Register_Login_AbstractPage_3 extends AbstractPage {
	WebDriver driver;
	Select select;
	String projectFolder = System.getProperty("user.dir");
	String firstName,lastName,Day,Month,Year,Mail,Company,Password;
	AbstractPage abstractPage;
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectFolder + "\\browserDriver\\geckodriver.exe");
		driver =new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com");
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
		clickToElement(driver, "//a[text()='Register']");
		clickToElement(driver, "//input[@id='gender-male']");
		senkeyToElement(driver, "//input[@id='FirstName']", firstName);
		senkeyToElement(driver, "//input[@id='LastName']", lastName);
		selectItemInDropdown(driver, "//select[@name='DateOfBirthDay']", Day);
		selectItemInDropdown(driver, "//select[@name='DateOfBirthMonth']", Month);
		selectItemInDropdown(driver, "//select[@name='DateOfBirthYear']", Year);
		senkeyToElement(driver, "//input[@id='Email']", Mail);
		senkeyToElement(driver, "//input[@id='Company']", Company);
	    senkeyToElement(driver, "//input[@id='Password']", Password);
		senkeyToElement(driver, "//input[@id='ConfirmPassword']", Password);
		clickToElement(driver, "//button[@id='register-button']");
	   // Assert.assertTrue(isElementDisplay(driver, "//div[text()='Your registration completed']"));
		Assert.assertEquals(getElementText(driver,"//div[@class='result']"), "Your registration completed");
		clickToElement(driver, "//a[text()='Log out']");
	   
		
	}
	@Test
	public void LevelTC02_Login() {
		clickToElement(driver, "//a[text()='Log in']");
		senkeyToElement(driver, "//input[@id='Email']", Mail);
		senkeyToElement(driver, "//input[@id='Password']", Password);
		clickToElement(driver, "//button[@class='button-1 login-button']");
		Assert.assertTrue(isElementDisplay(driver, "//a[text()='My account']"));
	
	}
	@Test
	public void  LevelTC03_View_MyAccount() {
		clickToElement(driver, "//a[text()='My account']");
		Assert.assertTrue(isElementSelected(driver, "//input[@id='gender-male']"));
		Assert.assertEquals(getElementAtribute(driver, "//input[@id='FirstName']", "value"), firstName);
		Assert.assertEquals(getElementAtribute(driver, "//input[@id='LastName']", "value"), lastName);
		Assert.assertEquals(getFirstSelectedTextInDropdown(driver, "//select[@name='DateOfBirthDay']"),Day);
		Assert.assertEquals(getFirstSelectedTextInDropdown(driver, "//select[@name='DateOfBirthMonth']"),Month);
		Assert.assertEquals(getFirstSelectedTextInDropdown(driver,"//select[@name='DateOfBirthYear']"),Year);
		Assert.assertEquals(getElementAtribute(driver, "//input[@id='Email']", "value"), Mail);
		Assert.assertEquals(getElementAtribute(driver, "//input[@id='Company']", "value"), Company);
		Assert.assertTrue(isElementSelected(driver, "//input[@id='Newsletter']"));
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
}