package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUis.HomePageUI;
import pageUis.LoginPageUI;

public class HomePageObject extends AbstractPage{
	//bien toan cuc(global)
	WebDriver driver;
	
	//Ham khoi tao(Constructor method)
	//Khi new Class nay len thi no se chay dau dien, no map driver
	//Ham khoi tao khong co kieu tra ve
	//Cung ten voi ten class
	
	
	public HomePageObject(WebDriver driver) {
		//WebDriver driver: bien cuc bo cua ham nay(local)
		this.driver = driver;
	}


	public void clickToRegisterLink() {
		waitToElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		
	}

	public void clickToLoginLink() {
		waitToElementClickable(driver,HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		
	}

	public boolean isMyAccountLinkDisplayed() {
		waitToElementVisiable(driver, HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplay(driver, HomePageUI.MY_ACCOUNT_LINK);
	   
	}

	public boolean isLogoutLinkDisplayed() {
		waitToElementVisiable(driver, HomePageUI.LOGOUT_LINK);
		return isElementDisplay(driver, HomePageUI.LOGOUT_LINK);
		
	}

	public void clickToMyAccounLink() {
		waitToElementVisiable(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
	}

}
