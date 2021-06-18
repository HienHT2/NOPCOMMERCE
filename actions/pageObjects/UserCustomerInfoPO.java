package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUis.UserCustomerInforPageUI;

public class UserCustomerInfoPO extends AbstractPage {
		WebDriver driver;
	public UserCustomerInfoPO(WebDriver driver) {
			this.driver = driver;
		}

	public boolean isGenderMaleRadioButtonSelected() {
		waitToElementVisiable(driver, UserCustomerInforPageUI.GENDER_MALE_RADIO);
		return isElementSelected(driver, UserCustomerInforPageUI.GENDER_MALE_RADIO);
	
	}

	public String getFirstnameTextboxvalue() {
		waitToElementVisiable(driver, UserCustomerInforPageUI.FIRSTNAME_TEXTBOX);
		return getElementAtribute(driver, UserCustomerInforPageUI.FIRSTNAME_TEXTBOX, "value");
		
	}

	public String getLastnameTextboxvalue() {
		waitToElementVisiable(driver, UserCustomerInforPageUI.LASTTNAME_TEXTBOX);
		return getElementAtribute(driver, UserCustomerInforPageUI.LASTTNAME_TEXTBOX, "value");
		
	}

	public String getSelectedTextInDayDropdown() {
		waitToElementVisiable(driver, UserCustomerInforPageUI.DAY_DROPDOWN);
		return getFirstSelectedTextInDropdown(driver, UserCustomerInforPageUI.DAY_DROPDOWN);
		
	}

	public String getSelectedTextInMonthDropdown() {
		waitToElementVisiable(driver, UserCustomerInforPageUI.MONTH_DROPDOWN);
		return getFirstSelectedTextInDropdown(driver, UserCustomerInforPageUI.MONTH_DROPDOWN);
		
	}

	public String getSelectedTextInYearDropdown() {
		waitToElementVisiable(driver, UserCustomerInforPageUI.YEAR_DROPDOWN);
		return getFirstSelectedTextInDropdown(driver, UserCustomerInforPageUI.YEAR_DROPDOWN);
	}

	public String getEmailTextboxvalue() {
		waitToElementVisiable(driver, UserCustomerInforPageUI.MAIL_TEXTBOX);
		return getElementAtribute(driver, UserCustomerInforPageUI.MAIL_TEXTBOX, "value");
		
	}

	public String getCompanyTextboxvalue() {
		waitToElementVisiable(driver, UserCustomerInforPageUI.COMPANY_TEXTBOX);
		return getElementAtribute(driver, UserCustomerInforPageUI.COMPANY_TEXTBOX, "value");
		
	}

	public boolean isNewletterCheckboxSelected() {
		waitToElementVisiable(driver, UserCustomerInforPageUI.NEW_LETTER_CHECKBOX);
		return isElementSelected(driver,  UserCustomerInforPageUI.NEW_LETTER_CHECKBOX);
		
		
	}

	

}
