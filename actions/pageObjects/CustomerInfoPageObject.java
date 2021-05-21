package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUis.CustomerInforPageUI;

public class CustomerInfoPageObject extends AbstractPage {
		WebDriver driver;
	public CustomerInfoPageObject(WebDriver driver) {
			this.driver = driver;
		}

	public boolean isGenderMaleRadioButtonSelected() {
		waitToElementVisiable(driver, CustomerInforPageUI.GENDER_MALE_RADIO);
		return isElementSelected(driver, CustomerInforPageUI.GENDER_MALE_RADIO);
	
	}

	public String getFirstnameTextboxvalue() {
		waitToElementVisiable(driver, CustomerInforPageUI.FIRSTNAME_TEXTBOX);
		return getElementAtribute(driver, CustomerInforPageUI.FIRSTNAME_TEXTBOX, "value");
		
	}

	public String getLastnameTextboxvalue() {
		waitToElementVisiable(driver, CustomerInforPageUI.LASTTNAME_TEXTBOX);
		return getElementAtribute(driver, CustomerInforPageUI.LASTTNAME_TEXTBOX, "value");
		
	}

	public String getSelectedTextInDayDropdown() {
		waitToElementVisiable(driver, CustomerInforPageUI.DAY_DROPDOWN);
		return getFirstSelectedTextInDropdown(driver, CustomerInforPageUI.DAY_DROPDOWN);
		
	}

	public String getSelectedTextInMonthDropdown() {
		waitToElementVisiable(driver, CustomerInforPageUI.MONTH_DROPDOWN);
		return getFirstSelectedTextInDropdown(driver, CustomerInforPageUI.MONTH_DROPDOWN);
		
	}

	public String getSelectedTextInYearDropdown() {
		waitToElementVisiable(driver, CustomerInforPageUI.YEAR_DROPDOWN);
		return getFirstSelectedTextInDropdown(driver, CustomerInforPageUI.YEAR_DROPDOWN);
	}

	public String getEmailTextboxvalue() {
		waitToElementVisiable(driver, CustomerInforPageUI.MAIL_TEXTBOX);
		return getElementAtribute(driver, CustomerInforPageUI.MAIL_TEXTBOX, "value");
		
	}

	public String getCompanyTextboxvalue() {
		waitToElementVisiable(driver, CustomerInforPageUI.COMPANY_TEXTBOX);
		return getElementAtribute(driver, CustomerInforPageUI.COMPANY_TEXTBOX, "value");
		
	}

	public boolean isNewletterCheckboxSelected() {
		waitToElementVisiable(driver, CustomerInforPageUI.NEW_LETTER_CHECKBOX);
		return isElementSelected(driver,  CustomerInforPageUI.NEW_LETTER_CHECKBOX);
		
		
	}

}
