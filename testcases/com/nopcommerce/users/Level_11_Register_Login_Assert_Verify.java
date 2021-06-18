package com.nopcommerce.users;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractPage;
import commons.AbstractTest;
import pageObjects.UserAddressPO;
import pageObjects.UserCustomerInfoPO;
import pageObjects.UserHomePO;
import pageObjects.UserLoginPO;
import pageObjects.UserMyProductReviewPO;
import pageObjects.UserOrdersPO;
import pageObjects.PageGeneratorManager;
import pageObjects.UserRegisterPO;

/**
 * @author HienHT2
 *
 */
public class Level_11_Register_Login_Assert_Verify extends AbstractTest {
	WebDriver driver;
	Select select;
	String firstName, lastName, Day, Month, Year, Mail, Company, Password;
	boolean status;
	AbstractPage abstractPage;

	@Parameters("browser")

	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		firstName = "Hoang";
		lastName = "Hien";
		Day = "30";
		Month = "August";
		Year = "1994";
		Mail = "hoanghien" + getRandomEmail() + "@gmail.com";
		Company = "Cong ty Chưng khoan SSI";
		Password = "123456";

	}

	@Test
	public void LevelTC01_Register() {
		// homePage = new HomePageObject(driver);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		//verify Register link displayed
		Assert.assertTrue( homePage.isRegisterLinkDisplayed());
		//Verify Login Link Displayed 
		Assert.assertTrue( homePage.isLoginLinkDisplayed());
		registerPage = homePage.clickToRegisterLink();
		// registerPage = new RegisterPageObject(driver);
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
		// Sự kết nối giữa 2 page
		homePage = registerPage.clickToLogoutLink();
		// homePage = new HomePageObject(driver);
	}

	@Test
	public void LevelTC02_Login() {
		loginPage = homePage.clickToLoginLink();
		// loginPage = new LoginPageObject(driver);
		loginPage.inputToEmailTextbox(Mail);
		loginPage.inputToPasswordTextbox(Password);
		homePage = loginPage.clickToLoginButton();
		// homePage = new HomePageObject(driver);
		//Verify My account Link Dispalyes 
		/*/
		 * fASLE
		 */
		
		status=homePage.isMyAccountLinkDisplayed();
		System.out.println("My Account"+ status);
		Assert.assertTrue(status);
		//Verify logout Link Dispalyes
		status=homePage.isLogoutLinkDisplayed(); 
		System.out.println("Logout Link" + status);
		Assert.assertTrue(status);
		//
		status=homePage.isShoppingCartNoItemToolTipUnDisplayed();
		System.out.println("SHOPPING CART ITEM"+ status);
		Assert.assertTrue(status);

		//Verify login Link Undisplayed
		status= homePage.isRegisterLinkUnDisplayed();
		System.out.println("REGISTER STATUS"+ status);
		Assert.assertTrue( status);
		//Verify Register Link Undisplayed
		status= homePage.isLoginLinkUnDisplayed();
		System.out.println("LOGIN STATUS"+ status);
		Assert.assertTrue( status);
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
	UserAddressPO addressPage;
	UserMyProductReviewPO myProductReviewPage;
	UserOrdersPO ordersPage;

}