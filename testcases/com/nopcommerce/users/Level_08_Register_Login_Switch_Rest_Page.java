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
public class Level_08_Register_Login_Switch_Rest_Page extends AbstractTest {
	WebDriver driver;
	Select select;
	String firstName, lastName, Day, Month, Year, Mail, Company, Password;
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

		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		Assert.assertTrue(homePage.isLogoutLinkDisplayed());

	}

	@Test
	public void LevelTC03_View_MyAccount() {
		customerInfoPage = homePage.clickToMyAccounLink();
		// customerInfoPage = new CustomerInfoPageObject(driver);

		Assert.assertTrue(customerInfoPage.isGenderMaleRadioButtonSelected());

		Assert.assertEquals(customerInfoPage.getFirstnameTextboxvalue(), firstName);
		Assert.assertEquals(customerInfoPage.getLastnameTextboxvalue(), lastName);

		Assert.assertEquals(customerInfoPage.getSelectedTextInDayDropdown(), Day);
		Assert.assertEquals(customerInfoPage.getSelectedTextInMonthDropdown(), Month);
		Assert.assertEquals(customerInfoPage.getSelectedTextInYearDropdown(), Year);

		Assert.assertEquals(customerInfoPage.getEmailTextboxvalue(), Mail);
		Assert.assertEquals(customerInfoPage.getCompanyTextboxvalue(), Company);
		Assert.assertTrue(customerInfoPage.isNewletterCheckboxSelected());

	}

	@Test
	public void LevelTC04_Rest_Parameter() {
		// CustomerInfo -> Address
		addressPage = customerInfoPage.openAddressPage(driver);
		customerInfoPage = addressPage.openCustomerInfo(driver);
		myProductReviewPage = customerInfoPage.openMyProductReviewPage(driver);
		// Address -> My product Review
		// myProductReviewPage= customerInfoPage.openMyProductReviewPage(driver);
		customerInfoPage = myProductReviewPage.openCustomerInfo(driver);
		// My Product Review -> Order
		ordersPage = myProductReviewPage.openOrdersPage(driver);
		// Order -> Address
		addressPage = ordersPage.openAddressPage(driver);

		// Adress -> Customer Info
		customerInfoPage = addressPage.openCustomerInfo(driver);

	}
	@Test
	public void LevelTC05_Switch_Solution_02()
	{
		customerInfoPage.openLinkWithPageName(driver, "Addresses");
		addressPage=PageGeneratorManager.getUserAddressPageObject(driver);
		
		addressPage.openLinkWithPageName(driver, "Customer info");
		customerInfoPage=PageGeneratorManager.getUserCustomerInfoPage(driver);
		
		customerInfoPage.openLinkWithPageName(driver, "My product reviews");
		myProductReviewPage= PageGeneratorManager.getUserMyProductReviewPageObject(driver);
		
		myProductReviewPage.openLinkWithPageName(driver, "Customer info");
		customerInfoPage=PageGeneratorManager.getUserCustomerInfoPage(driver);
		
		customerInfoPage.openLinkWithPageName(driver, "Orders");
		ordersPage= PageGeneratorManager.getUserOrdersPageObject(driver);
		
		
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