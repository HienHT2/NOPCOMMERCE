package com.nopcommerce.admin;

import static org.testng.Assert.assertTrue;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.AdminDasbroadPO;
import pageObjects.AdminLoginPO;
import pageObjects.AdminProductPO;
import pageObjects.PageGeneratorManager;

/**
 * @author HienHT2
 *
 */
public class Level_10_Upload_File extends AbstractTest {
	WebDriver driver;
	String fileName="image1.jpg";
	String pictureALT="Description";
	String pictureTitle="Title";
	String pictureOrder="1";
	String productName="Adobe Photoshop CS4";
	@Parameters({ "browser", "url" })

	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);
		// Khoi tao trang admin
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
//		adminLoginPage.inputToEmailTextbox("");
//		adminLoginPage.inputToPasswordTextbox("");
//		adminLoginPage.clickToLoginButton();

		adminDasbroadPage = adminLoginPage.loginToSystem("admin@yourstore.com", "admin");
		productPage = adminDasbroadPage.openProducPage();
		//td[@data-columnname='PictureUrl']/a[contains(@href,'adobe-photoshop-cs4')]/parent::td/following-sibling::
		//td[@data-columnname='DisplayOrder' and text()='1']/following-sibling::td[@data-columnname='OverrideAltAttribute' and text()='alt picture']/following-sibling::td[@data-columnname='OverrideTitleAttribute' and text()='Title picture']
	}

	@Test
	public void TC01_Upload_File() {
		// Search Adobe Photoshop4
		productPage.inputProductNameTextbox(productName);
		productPage.clickToSearchButton();
		// Go to Edit
		productPage.clickToEditIconProductDetailByName(productName);
		// Scroll Upload function
		productPage.scrollToPicturePanel();
		
		//Click To Plus ICON
		/*
		 * productPage.clickToPlusIconByPaneID(driver,"product-pictures");
		 *  lúc không hiển thị icon plus thì testcase bị fail
		 */
		
		// upload 1 file
		productPage.uploadFileByPanelID(driver, "product-pictures", fileName);
		//Verify file name uploaded success
		Assert.assertTrue(productPage.isNewPictrueUploadSuccess(fileName));
			
		
		productPage.inputToAltTextBox(pictureALT);
		productPage.inputToTitleTextBox(pictureTitle);
		productPage.clickToIconAtToOderTextBox("Increase");
		// Add to Product picture

		productPage.clickToAddProductPictureButton();
		// Add to product pcitrue
		Assert.assertTrue(productPage.areImageDetailDisplayed(productName,pictureOrder, pictureALT, pictureTitle));

		// Save-> Go to Product Pagr
		productPage.clickToSaveButton();
		

		// Serach Adobe
		productPage.inputToProductNameTextbox(productName);
		productPage.clickToSearchButton();
		// Verify(Name/Image name)-Found
		// Check Displayed
		Assert.assertTrue(productPage.areProductDisplayed(productName,productName,"AD_CS4_PH", "75","10000","true"));
		//td/img[contains(@src,'adobe-photoshop-cs4')]/parent::td/following-sibling::td[text()='Adobe Photoshop CS4']/following-sibling::td[text()='AD_CS4_PH']/following-sibling::td[text()='75']/following-sibling::td[text()='10000']
		productPage.clickToEditIconProductDetailByName(productName);
		// Scroll Upload funtion
		productPage.scrollToPicturePanel();

		// Delete image
		productPage.clickToDeleteButtonByPictureName(productName);
		// Save->Go to
		productPage.clickToSaveButton();
		// Search Adobe
		productPage.inputToProductNameTextbox("");
		productPage.clickToSearchButton();
		// Verify Name-> Not Found
		Assert.assertTrue(productPage.areProductDisplayed("default-image", productName, "AD_CS4_PH", "75", "10000","true"));

	}

	@Test
	public void TC_02_Select_Deselect_All() {

		//
	}

	/**
	 * @return
	 */
	public int getRandomEmail() {
		Random rand = new Random();
		return rand.nextInt(9999);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	AdminLoginPO adminLoginPage;
	AdminDasbroadPO adminDasbroadPage;
	AdminProductPO productPage;

}