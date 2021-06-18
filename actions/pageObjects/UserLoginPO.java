package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUis.UserLoginPageUI;

public class UserLoginPO extends AbstractPage{
	WebDriver driver;
	
	public UserLoginPO(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToEmailTextbox(String mail) {
		waitToElementVisiable(driver, UserLoginPageUI.EMAIL_TEXTBOX);
		senkeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, mail);
		
	}

	public void inputToPasswordTextbox(String password) {
		waitToElementVisiable(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, password);
		
	}

	public UserHomePO clickToLoginButton() {
		waitToElementClickable(driver, UserLoginPageUI.BUTTON_LOGIN);
		clickToElement(driver, UserLoginPageUI.BUTTON_LOGIN);
		return PageGeneratorManager.getUserHomePage(driver);
	}
	
}