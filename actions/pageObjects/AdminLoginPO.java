package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUis.AdminLoginPageUI;

public class AdminLoginPO extends AbstractPage {
	WebDriver driver;

	public AdminLoginPO(WebDriver driver) {

		this.driver = driver;
	}

	public void inputToEmailTextbox(String email) {
		waitToElementVisiable(driver, AdminLoginPageUI.EMAIL_TEXTBOX);
		senkeyToElement(driver, AdminLoginPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToPasswordTextbox(String password) {
		waitToElementVisiable(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, password);
		
	}

	public AdminDasbroadPO clickToLoginButton() {
		waitToElementClickable(driver, AdminLoginPageUI.BUTTON_LOGIN);
		clickToElement(driver, AdminLoginPageUI.BUTTON_LOGIN);
		//login xong return va page Dasbroad
		return PageGeneratorManager.getAdminDasbroadPage(driver);
		
	}

	public AdminDasbroadPO loginToSystem(String email, String string2) {
		//ham trong ham
		inputToEmailTextbox(email);
		inputToPasswordTextbox(string2);
		return clickToLoginButton();
		
	}

}
