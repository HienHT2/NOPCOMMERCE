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

/**
 * @author HienHT2
 *
 */
public class Level_01_Register_Login{
	WebDriver driver;
	Select select;
	String projectFolder = System.getProperty("user.dir");
	String firstName,lastName,Day,Month,Year,Mail,Company,Password;
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectFolder + "\\browserDriver\\geckodriver.exe");
		driver =new FirefoxDriver();
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
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		driver.findElement(By.xpath("//input[@id='gender-male']")).click();
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys(lastName);
		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
		select.selectByVisibleText(Day);
		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
		select.selectByVisibleText(Month);
		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
		select.selectByVisibleText(Year);
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(Mail);
		driver.findElement(By.xpath("//input[@id='Company']")).sendKeys(Company);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(Password);
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys(Password);
		driver.findElement(By.xpath("//button[@id='register-button']")).click();
	    Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Your registration completed']")).isDisplayed());
	    driver.findElement(By.xpath("//a[text()='Log out']")).click();
	}
	@Test
	public void LevelTC02_Login() {
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(Mail);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(Password);
		driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='My account']")).isDisplayed());
	
	}
	@Test
	public void  LevelTC03_View_MyAccount() {
		driver.findElement(By.xpath("//a[text()='My account']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='gender-male']")).isSelected());
		//input[@id='FirstName' and @value='Trần']
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='FirstName']")).getAttribute("value"), firstName);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='LastName']")).getAttribute("value"), lastName);
		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), Day);
		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), Month);
		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), Year);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='Email']")).getAttribute("value"), Mail);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='Company']")).getAttribute("value"), Company);
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='Newsletter']")).isSelected());
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