package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.server.handler.SendKeys;

import commons.AbstractPage;
import pageUis.RegisterPageUI;

public class RegisterPageObject extends AbstractPage {
	WebDriver driver;
	
	
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToGenderMaleRadio() {
	 waitToElementClickable(driver, RegisterPageUI.GENDER_MALE_RADIO);
	 clickToElement(driver, RegisterPageUI.GENDER_MALE_RADIO);
		
	}

	public void inputToFirstnameTextbox(String firstName) {
		waitToElementClickable(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
		waitToElementVisiable(driver,RegisterPageUI.FIRSTNAME_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
	}

	public void inputToLastnameTextbox(String lastName) {
		waitToElementVisiable(driver,RegisterPageUI.LASTTNAME_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.LASTTNAME_TEXTBOX, lastName);
		
	}

	public void selectDayDropdown(String day) {
		waitToElementClickable(driver, RegisterPageUI.DAY_DROPDOWN);
		selectItemInDropdown(driver, RegisterPageUI.DAY_DROPDOWN, day);
		
		
	}

	public void selectMonthDropDown(String month) {
		waitToElementClickable(driver, RegisterPageUI.MONTH_DROPDOWN);
	    selectItemInDropdown(driver, RegisterPageUI.MONTH_DROPDOWN, month);
	}

	public void selectYearDropdown(String year) {
		waitToElementClickable(driver, RegisterPageUI.YEAR_DROPDOWN);
		selectItemInDropdown(driver, RegisterPageUI.YEAR_DROPDOWN, year);
		
	}

	public void inputToEmailTextbox(String mail) {
		waitToElementVisiable(driver, RegisterPageUI.MAIL_TEXTBOX);
	    senkeyToElement(driver, RegisterPageUI.MAIL_TEXTBOX, mail);
		
	}

	public void inputToCompanyTextbox(String company) {
		waitToElementVisiable(driver, RegisterPageUI.COMPANY_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.COMPANY_TEXTBOX, company);
		
	}

	public void inputToPasswordTextbox(String password) {
		waitToElementVisiable(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
		
	}

	public void inputToConfirmPasswordTextbox(String password) {
		waitToElementVisiable(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, password);
		
	}

	public void clickToRegisterButton() {
		waitToElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}

	public String getRegisterSuccessMessage() {
	   waitToElementVisiable(driver, RegisterPageUI.REGISTER_SUCCES_MESSAGE);
	   return getElementText(driver, RegisterPageUI.REGISTER_SUCCES_MESSAGE);
		
	}

	public void clickToLogoutLink() {
		waitToElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
	}

}
