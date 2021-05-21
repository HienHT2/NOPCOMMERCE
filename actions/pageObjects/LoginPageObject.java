package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUis.LoginPageUI;

public class LoginPageObject extends AbstractPage{
	WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToEmailTextbox(String mail) {
		waitToElementVisiable(driver, LoginPageUI.EMAIL_TEXTBOX);
		senkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, mail);
		
	}

	public void inputToPasswordTextbox(String password) {
		waitToElementVisiable(driver, LoginPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
		
	}

	public void clickToLoginButton() {
		waitToElementClickable(driver, LoginPageUI.BUTTON_LOGIN);
		clickToElement(driver, LoginPageUI.BUTTON_LOGIN);
		
	}
	
}