package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUis.AdminDasboardPageUI;

public class AdminDasbroadPO extends AbstractPage{
	WebDriver driver;

	public AdminDasbroadPO(WebDriver driver) {

		this.driver = driver;
	}

	public AdminProductPO openProducPage() {
		waitToElementClickable(driver, AdminDasboardPageUI.CATOLOG_TEXT_AT_SIDEBAR);
		clickToElement(driver, AdminDasboardPageUI.CATOLOG_TEXT_AT_SIDEBAR);
		waitToElementClickable(driver, AdminDasboardPageUI.PRODUCT_LINK_AT_SIDEBAR);
		clickToElement(driver, AdminDasboardPageUI.PRODUCT_LINK_AT_SIDEBAR);
		//Chờ cho load hết tất cả rồi mới thực hiện
		//waitToJqueyAndJavascripLoadedSuccess(driver);
		waitAjaxLoadingInvisible(driver);
		return PageGeneratorManager.getAdminProductPage(driver);
		
	}
}
