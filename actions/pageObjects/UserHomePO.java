package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUis.UserHomePageUI;
import pageUis.UserLoginPageUI;

public class UserHomePO extends AbstractPage{
	//bien toan cuc(global)
	WebDriver driver;
	
	//Ham khoi tao(Constructor method)
	//Khi new Class nay len thi no se chay dau dien, no map driver
	//Ham khoi tao khong co kieu tra ve
	//Cung ten voi ten class
	
	
	public UserHomePO(WebDriver driver) {
		//WebDriver driver: bien cuc bo cua ham nay(local)
		this.driver = driver;
	}


	public UserRegisterPO clickToRegisterLink() {
		waitToElementClickable(driver, UserHomePageUI.REGISTER_LINK);
		clickToElement(driver, UserHomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getUserRegisterPage(driver);
		
	}

	public UserLoginPO clickToLoginLink() {
		waitToElementClickable(driver,UserHomePageUI.LOGIN_LINK);
		clickToElement(driver, UserHomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitToElementVisiable(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplay(driver, UserHomePageUI.MY_ACCOUNT_LINK);
	   
	}

	public boolean isLogoutLinkDisplayed() {
		waitToElementVisiable(driver, UserHomePageUI.LOGOUT_LINK);
		return isElementDisplay(driver, UserHomePageUI.LOGOUT_LINK);
		
	}

	public UserCustomerInfoPO clickToMyAccounLink() {
		waitToElementVisiable(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getUserCustomerInfoPage(driver);
	}


	public boolean isRegisterLinkDisplayed() {
		//waitToElementVisiable(driver, UserHomePageUI.REGISTER_LINK);
		return isElementDisplay(driver, UserHomePageUI.REGISTER_LINK);
		
	}


	public boolean isLoginLinkDisplayed() {
		//waitToElementVisiable(driver, UserHomePageUI.LOGIN_LINK);
		return isElementDisplay(driver, UserHomePageUI.LOGIN_LINK);
	}


	public boolean isShoppingCartNoItemToolTipDisplayed() {
		return isElementDisplay(driver, UserHomePageUI.SHOPPING_CART_NO_ITEM_TOOTIP);
	}
	public boolean isRegisterLinkUnDisplayed() {
		waitToElementInvisiable(driver, UserHomePageUI.REGISTER_LINK);
		return isElementUndisplayed(driver, UserHomePageUI.REGISTER_LINK);
		
	}


	public boolean isLoginLinkUnDisplayed() {
		waitToElementInvisiable(driver, UserHomePageUI.LOGIN_LINK);
		return isElementUndisplayed(driver, UserHomePageUI.LOGIN_LINK);
	}


	public boolean isShoppingCartNoItemToolTipUnDisplayed() {
		waitToElementInvisiable(driver, UserHomePageUI.SHOPPING_CART_NO_ITEM_TOOTIP);
		return isElementUndisplayed(driver, UserHomePageUI.SHOPPING_CART_NO_ITEM_TOOTIP);
	}

}
