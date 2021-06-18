package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.server.handler.SendKeys;

import commons.AbstractPage;
import pageUis.UserRegisterPageUI;

public class UserRegisterPO extends AbstractPage {
	WebDriver driver;
	
	
	public UserRegisterPO(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToGenderMaleRadio() {
	 waitToElementClickable(driver, UserRegisterPageUI.GENDER_MALE_RADIO);
	 clickToElement(driver, UserRegisterPageUI.GENDER_MALE_RADIO);
		
	}

	public void inputToFirstnameTextbox(String firstName) {
		waitToElementClickable(driver, UserRegisterPageUI.FIRSTNAME_TEXTBOX);
		waitToElementVisiable(driver,UserRegisterPageUI.FIRSTNAME_TEXTBOX);
		senkeyToElement(driver, UserRegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
	}

	public void inputToLastnameTextbox(String lastName) {
		waitToElementVisiable(driver,UserRegisterPageUI.LASTTNAME_TEXTBOX);
		senkeyToElement(driver, UserRegisterPageUI.LASTTNAME_TEXTBOX, lastName);
		
	}

	public void selectDayDropdown(String day) {
		waitToElementClickable(driver, UserRegisterPageUI.DAY_DROPDOWN);
		selectItemInDropdown(driver, UserRegisterPageUI.DAY_DROPDOWN, day);
		
		
	}

	public void selectMonthDropDown(String month) {
		waitToElementClickable(driver, UserRegisterPageUI.MONTH_DROPDOWN);
	    selectItemInDropdown(driver, UserRegisterPageUI.MONTH_DROPDOWN, month);
	}

	public void selectYearDropdown(String year) {
		waitToElementClickable(driver, UserRegisterPageUI.YEAR_DROPDOWN);
		selectItemInDropdown(driver, UserRegisterPageUI.YEAR_DROPDOWN, year);
		
	}

	public void inputToEmailTextbox(String mail) {
		waitToElementVisiable(driver, UserRegisterPageUI.MAIL_TEXTBOX);
	    senkeyToElement(driver, UserRegisterPageUI.MAIL_TEXTBOX, mail);
		
	}

	public void inputToCompanyTextbox(String company) {
		waitToElementVisiable(driver, UserRegisterPageUI.COMPANY_TEXTBOX);
		senkeyToElement(driver, UserRegisterPageUI.COMPANY_TEXTBOX, company);
		
	}

	public void inputToPasswordTextbox(String password) {
		waitToElementVisiable(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, password);
		
	}

	public void inputToConfirmPasswordTextbox(String password) {
		waitToElementVisiable(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		senkeyToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, password);
		
	}

	public void clickToRegisterButton() {
		waitToElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
	}

	public String getRegisterSuccessMessage() {
	   waitToElementVisiable(driver, UserRegisterPageUI.REGISTER_SUCCES_MESSAGE);
	   return getElementText(driver, UserRegisterPageUI.REGISTER_SUCCES_MESSAGE);
		
	}

	public UserHomePO clickToLogoutLink() {
		waitToElementClickable(driver, UserRegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, UserRegisterPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getUserHomePage(driver);
	}

}
