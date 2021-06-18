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
public class Level_09_Web_Data_Table extends AbstractTest {
	WebDriver driver;
	
	@Parameters({"browser", "url"})

	@BeforeClass
	public void beforeClass(String browserName,String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);
		//Khoi tao trang admin
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
//		adminLoginPage.inputToEmailTextbox("");
//		adminLoginPage.inputToPasswordTextbox("");
//		adminLoginPage.clickToLoginButton();
		
		adminDasbroadPage=adminLoginPage.loginToSystem("admin@yourstore.com","admin");
		productPage=adminDasbroadPage.openProducPage();
		
	}

	@Test
	public void TC01_Paging() {
	
		//Paging
		productPage.goToPageAtTableByIndex("2");
		Assert.assertTrue(productPage.isPageActiveAtTableByIndex("2"));
		
		productPage.goToPageAtTableByIndex("3");
		Assert.assertTrue(productPage.isPageActiveAtTableByIndex("3"));
		
		productPage.goToPageAtTableByIndex("1");
		Assert.assertTrue(productPage.isPageActiveAtTableByIndex("1"));
	
		
	}
	
	
	@Test
	public void TC_02_Select_Deselect_All() {
		productPage.waitForProductNumberToBe();
		
		//Select All
		productPage.checkToSelectAllCheckbox();
		productPage.allProductCheckboxChecked();
		
		//Deselect All
		productPage.uncheckToSelectAllCheckbox();
		productPage.allProductCheckboxUnChecked();
		
		//Special Check
		productPage.checkToProductCheckboxByName("Build your own computer");
		productPage.SleepInSeconds(3);
		productPage.checkToProductCheckboxByName("Build your own computer");
		productPage.SleepInSeconds(3);
		productPage.checkToProductCheckboxByName("Lenovo IdeaCentre 600 All-in-One PC");
		productPage.SleepInSeconds(3);
		productPage.checkToProductCheckboxByName("HP Spectre XT Pro UltraBook");
		productPage.SleepInSeconds(3);
		//
	}
	@Test
	public void TC_03_Displayed_All() {
		
		//Check Dispayed
		Assert.assertTrue(productPage.areProductDetailDisplyed("Adobe Photoshop CS4","AD_CS4_PH","75","10000","true"));
		Assert.assertTrue(productPage.areProductDetailDisplyed("Windows 8 Pro","MS_WIN_8P","65","10000","true"));
		
		productPage.selectShowItemDropdown("20");
		Assert.assertTrue(productPage.areProductDetailDisplyed("Nokia Lumia 1020","N_1020_LU","349","10000","false"));

	}
	@Test
	public void TC04_Edit() {
		//Edit
		productPage.clickToEditIconProductDetailByName("Lenovo IdeaCentre 600 All-in-One PC");
		productPage.backToPage(driver);
		productPage.SleepInSeconds(3);
		productPage.clickToEditIconProductDetailByName("Build your own computer");
		productPage.backToPage(driver);
		
	}
	@Test
	public void TC_05_Positon() {
		Assert.assertTrue(productPage.isInfomationtDisplayedAtColumnNameAndRowNumber("Product name","13","Nikon D5500 DSLR"));
		Assert.assertTrue(productPage.isInfomationtDisplayedAtColumnNameAndRowNumber("SKU","13","N5500DS_0"));
		Assert.assertTrue(productPage.isInfomationtDisplayedAtColumnNameAndRowNumber("Price","13",""));
		Assert.assertTrue(productPage.isInfomationtDisplayedAtColumnNameAndRowNumber("Stock quantity","13",""));
		Assert.assertTrue(productPage.isPublicStatusAtColumnNameAndRowNumber("Published","13","true"));
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