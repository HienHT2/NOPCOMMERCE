package commons;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AbstractTest {
	private WebDriver driver;
	private String projectFolder = System.getProperty("user.dir");
	protected WebDriver getBrowserDriver(String browserName ) {
		if(browserName.equals("firefox_ui")) {
			System.setProperty("webdriver.gecko.driver", projectFolder + "\\browserDriver\\geckodriver.exe");
			driver =new FirefoxDriver();
		}else if(browserName.equals("chrome_UI")) {
			System.setProperty("webdriver.chrome.driver", projectFolder + "\\browserDriver\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("useAutomationExtension", false);
			options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			driver =new ChromeDriver(options);
		}else {
			throw new RuntimeException("please input valid brower name!");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com");
		return driver;
	}
	
	
	
}
