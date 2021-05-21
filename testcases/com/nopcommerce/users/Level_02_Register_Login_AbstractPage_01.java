package com.nopcommerce.users;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.AbstractPage;

/**
 * @author HienHT2
 *
 */
public class Level_02_Register_Login_AbstractPage_01{
	WebDriver driver;
	Select select;
	String projectFolder = System.getProperty("user.dir");
	String firstName,lastName,Day,Month,Year,Mail,Company,Password;
	AbstractPage abstractPage;
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectFolder + "\\browserDriver\\geckodriver.exe");
		driver =new FirefoxDriver();
		abstractPage= new AbstractPage();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com");
		firstName="Hoang";
		lastName="Hien";
		Day="30";
		Month="August";
		Year="1994";
		Mail="hoanghien"+getRandomEmail()+"@gmail.com";
		Company="Cong ty Chưng khoan SSI";
		Password="123456";
	}
	@Test
	public void LevelTC01_Register() {
		abstractPage.clickToElement(driver, "//a[text()='Register']");
		abstractPage.clickToElement(driver, "//input[@id='gender-male']");
		abstractPage.senkeyToElement(driver, "//input[@id='FirstName']", firstName);
		abstractPage.senkeyToElement(driver, "//input[@id='LastName']", lastName);
		abstractPage.selectItemInDropdown(driver, "//select[@name='DateOfBirthDay']", Day);
		abstractPage.selectItemInDropdown(driver, "//select[@name='DateOfBirthMonth']", Month);
		abstractPage.selectItemInDropdown(driver, "//select[@name='DateOfBirthYear']", Year);
		abstractPage.senkeyToElement(driver, "//input[@id='Email']", Mail);
		abstractPage.senkeyToElement(driver, "//input[@id='Company']", Company);
	    abstractPage.senkeyToElement(driver, "//input[@id='Password']", Password);
		abstractPage.senkeyToElement(driver, "//input[@id='ConfirmPassword']", Password);
		abstractPage.clickToElement(driver, "//button[@id='register-button']");
	    Assert.assertTrue(abstractPage.isElementDisplay(driver, "//div[text()='Your registration completed']"));
		abstractPage.clickToElement(driver, "//a[text()='Log out']");
	   
	}
	@Test
	public void LevelTC02_Login() {
		abstractPage.clickToElement(driver, "//a[text()='Log in']");
		abstractPage.senkeyToElement(driver, "//input[@id='Email']", Mail);
		abstractPage.senkeyToElement(driver, "//input[@id='Password']", Password);
		abstractPage.clickToElement(driver, "//button[@class='button-1 login-button']");
		Assert.assertTrue(abstractPage.isElementDisplay(driver, "//a[text()='My account']"));
	
	}
	@Test
	public void  LevelTC03_View_MyAccount() {
		abstractPage.clickToElement(driver, "//a[text()='My account']");
		Assert.assertTrue(abstractPage.isElementSelected(driver, "//input[@id='gender-male']"));
		Assert.assertEquals(abstractPage.getElementAtribute(driver, "//input[@id='FirstName']", "value"), firstName);
		Assert.assertEquals(abstractPage.getElementAtribute(driver, "//input[@id='LastName']", "value"), lastName);
		Assert.assertEquals(abstractPage.getFirstSelectedTextInDropdown(driver, "//select[@name='DateOfBirthDay']"),Day);
		Assert.assertEquals(abstractPage.getFirstSelectedTextInDropdown(driver, "//select[@name='DateOfBirthMonth']"),Month);
		Assert.assertEquals(abstractPage.getFirstSelectedTextInDropdown(driver,"//select[@name='DateOfBirthYear']"),Year);
		Assert.assertEquals(abstractPage.getElementAtribute(driver, "//input[@id='Email']", "value"), Mail);
		Assert.assertEquals(abstractPage.getElementAtribute(driver, "//input[@id='Company']", "value"), Company);
		Assert.assertTrue(abstractPage.isElementSelected(driver, "//input[@id='Newsletter']"));
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
}