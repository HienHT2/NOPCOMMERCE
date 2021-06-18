package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static UserLoginPO getUserLoginPage(WebDriver driver) {
		return new UserLoginPO(driver);
	}
	
	public static UserHomePO getUserHomePage(WebDriver driver) {
		return new UserHomePO(driver);
	}
	public static UserRegisterPO getUserRegisterPage(WebDriver driver) {
		return new UserRegisterPO(driver);
	}
	public static UserCustomerInfoPO getUserCustomerInfoPage(WebDriver driver) {
		return new UserCustomerInfoPO(driver);
	}
	public static UserAddressPO getUserAddressPageObject(WebDriver driver) {
		return new UserAddressPO(driver);
	}
	public static UserOrdersPO getUserOrdersPageObject(WebDriver driver) {
		return new UserOrdersPO(driver);
	}
	public static UserMyProductReviewPO getUserMyProductReviewPageObject(WebDriver driver) {
		return new UserMyProductReviewPO(driver);
	}
	public static AdminLoginPO getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPO(driver);
	}
	public static AdminDasbroadPO getAdminDasbroadPage(WebDriver driver) {
		return new AdminDasbroadPO(driver);
	}
	public static AdminProductPO getAdminProductPage(WebDriver driver) {
		return new AdminProductPO(driver);
	}
}
