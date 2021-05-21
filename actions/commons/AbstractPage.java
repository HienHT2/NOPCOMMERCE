package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {

	public void openPageUrl(WebDriver driver, String url) {
		driver.get(url);
	}

	public String getCurrentPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getCurrentPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getCurrentPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshToPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public String gettextAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	public void setTextAlert(WebDriver driver, String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	public void waitAlertPresent(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.alertIsPresent());

	}

	/** =====Window -===== **/
	/*--- Only 2 windows*/
	public void switchToWindowById(WebDriver driver, String parentID) {
		// Lấy ra tất cả các ID của window/tab đang có
		Set<String> allWindows = driver.getWindowHandles();
		// Dùng vòng lặp foreach để duyệt qua từng ID
		for (String runWindow : allWindows) {
			// Kiểm tra cái ID nào mà khác với parent (A)
			if (!runWindow.equals(parentID)) {
				// Switch vào ID (cửa sổ/ tab) đó
				driver.switchTo().window(runWindow);

				break;
			}
		}
	}

	/* ------ Switch to child Window(greater than 2 window and title of the pages are unique */

	public void switchToWindowByTitle(WebDriver driver, String pageTitle) {
		// Lấy ra tất cả các ID của window/Tab đang có
		Set<String> allWindows = driver.getWindowHandles();
		// Dùng vòng lặp duyệt qua các ID này
		for (String runWindows : allWindows) {
			// Swich vào từng cửa sổ/ tab trước
			driver.switchTo().window(runWindows);
			// Lấy ra title của TAB đó
			String currentPageTitle = driver.getTitle();
			// Kiểm tra xem title của page nào bằng với title mong muốn(truyền vào ban đầu)
			if (currentPageTitle.equals(pageTitle)) {
				break;
			}
		}
	}

	/*---- Close all windows without parent window*/
	public void closeAllWindowsWithoutParent(WebDriver driver, String parentId) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			// Nếu như ID khác với parent
			if (!runWindows.equals(parentId)) {
				// Switch vào
				driver.switchTo().window(runWindows);
				// Close ffi
				driver.close();
			}
		}
		driver.switchTo().window(parentId);

	}

	/** ========= Selenium Web Element =========== **/

	public WebElement getElement(WebDriver driver, String locator) {
		return driver.findElement(getByXpath(locator));
	}

	public List<WebElement> getElements(WebDriver driver, String locator) {
		return driver.findElements(getByXpath(locator));
	}

	public By getByXpath(String locator) {
		return By.xpath(locator);

	}

	public void clickToElement(WebDriver driver, String locator) {
//		if(driver.toString().toLowerCase().contains("edge")) {
//			SleepInMiliSeconds(500);
//		}
		element = getElement(driver, locator);
		element.click();
	}

	public void senkeyToElement(WebDriver driver, String locator, String value) {
		 element = getElement(driver, locator);
		 element.clear();
		 if(driver.toString().toLowerCase().contains("chrome") ||driver.toString().toLowerCase().contains("edg") ) {
			 SleepInMiliSeconds(500);
		 }
		element.sendKeys(value);
	}

	public void selectItemInDropdown(WebDriver driver, String locator, String itemValue) {
		element = getElement(driver, locator);
		select = new Select(element);
		select.selectByVisibleText(itemValue);
	}

	public String getFirstSelectedTextInDropdown(WebDriver driver, String locator) {
		 element = getElement(driver, locator);
		select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}

	public boolean isDropdownMultiple(WebDriver driver, String locator) {
		 element = getElement(driver, locator);
		select = new Select(element);
		return select.isMultiple();
	}

	public void selectItemInDropdown(WebDriver driver, String parentLocaotor, String childitemLocator, String expectedLocator) {
		getElement(driver, parentLocaotor).click();
		SleepInSeconds(2);
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childitemLocator)));

		 elements = getElements(driver, childitemLocator);

		for (WebElement item : elements) {
			String actualItem = item.getText();
			if (actualItem.equals(expectedLocator)) {
				JavascriptExecutor jsExcutor = (JavascriptExecutor) driver;
				jsExcutor.executeScript("arguments[0].scrollIntoView(true);", item);
				SleepInSeconds(2);
				item.click();
				SleepInSeconds(1);
				break;
			}
		}

	}

	public void SleepInSeconds(long timeout) {
		try {
			Thread.sleep(timeout * 1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
	public void SleepInMiliSeconds(long minisecond) {
		try {
			Thread.sleep(minisecond);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
	public String getElementAtribute(WebDriver driver, String locator, String attributeName) {
	element = getElement(driver, locator);
		return element.getAttribute(attributeName);
	}
	public String getElementText(WebDriver driver, String locator) {
		 element = getElement(driver, locator);
		return element.getText();
	}
	public int countElementSize(WebDriver driver, String locator) {
		return getElements(driver, locator).size();
	}
	public void checkToCheckbox(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		if(!element.isSelected()) {
			element.click();
		}
	}
	public void uncheckToCheckbox(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		if(element.isSelected()) {
			element.click();
		}
	}
	public boolean isElementDisplay(WebDriver driver, String locator) {
		return getElement(driver, locator).isDisplayed();
	}
	public boolean isElementEnable(WebDriver driver, String locator) {
		return getElement(driver, locator).isEnabled();
	}
	
	public boolean isElementSelected(WebDriver driver, String locator) {
		return getElement(driver, locator).isSelected();
	}
	
	public void switchToFrame(WebDriver driver, String locator) {
		driver.switchTo().frame(getElement(driver, locator));
	}
	
	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	/** ======= 18 User Actions =========**/
	public void doubleClickToElement(WebDriver driver, String locator) {
		 element = getElement(driver, locator);
		Actions action = (Actions)driver;
		action.doubleClick(element).perform();
		
	}
	
	public void hoverMouseToElement(WebDriver driver, String locator) {
		 element = getElement(driver, locator);
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		
	}
	public void rightClick(WebDriver driver, String locator) {
		 element = getElement(driver, locator);
		Actions action = new Actions(driver);
		action.contextClick(element);
		
	}
	public void dragAndDrop(WebDriver driver, String locatorSource, String locatorTarget) {
		WebElement source = getElement(driver, locatorSource);
		WebElement target = getElement(driver, locatorTarget);
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).perform();
	}
	public void clickAndHoldToElement(WebDriver driver, String locator) {
	element = getElement(driver, locator);
		Actions action = new Actions(driver);
		action.clickAndHold(element);
	}
	public void senKeyBroadToElement(WebDriver driver, String locator,Keys key) {
		 element = getElement(driver, locator);
		Actions action = new Actions(driver);
		action.sendKeys(element,key).perform();
	}
	
	/**======= 19 Upload ======**/
	
	/**===== Javascript Executor ========**/
	public Object executeForBrowser(WebDriver driver, String javaScript) {
		jsExecutor= (JavascriptExecutor)driver;
		return jsExecutor.executeScript(javaScript);
	}
	

	public String getInnerText(WebDriver driver) {
		jsExecutor= (JavascriptExecutor)driver;
		return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
	}
//Dùng trong trường hợp không thể get text= selenium
	public boolean areExpectedTextInInnerText( WebDriver driver,String textExpected) {
		jsExecutor= (JavascriptExecutor)driver;
		String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		jsExecutor= (JavascriptExecutor)driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		jsExecutor= (JavascriptExecutor)driver;
		jsExecutor.executeScript("window.location = '" + url + "'");
	}

	public void highlightElement( WebDriver driver,String locator) {
		jsExecutor= (JavascriptExecutor)driver;
		 element = getElement(driver, locator);
		element = driver.findElement(By.xpath(locator));
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		SleepInSeconds(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		jsExecutor= (JavascriptExecutor)driver;
		 element = getElement(driver, locator);
		element = driver.findElement(By.xpath(locator));
		jsExecutor.executeScript("arguments[0].click();", element);
	}

	public void scrollToElement(WebDriver driver, String locator) {
		jsExecutor= (JavascriptExecutor)driver;
		 element = getElement(driver, locator);
		element = driver.findElement(By.xpath(locator));
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		jsExecutor= (JavascriptExecutor)driver;
		element = getElement(driver, locator);
		element = driver.findElement(By.xpath(locator));
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')",element);
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		jsExecutor= (JavascriptExecutor)driver;
		 element = getElement(driver, locator);
		element = driver.findElement(By.xpath(locator));
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", element);
	}


	public String getElementValidationMessage(WebDriver driver, String locator) {
		jsExecutor= (JavascriptExecutor)driver;
		 element = getElement(driver, locator);
		element = driver.findElement(By.xpath(locator));
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;",element);
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		jsExecutor= (JavascriptExecutor)driver;
		 element = getElement(driver, locator);
		element= driver.findElement(By.xpath(locator));
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",element);
		if (status) {
			return true;
		} else {
			return false;
		}
	}
	
	public void waitToElementVisiable(WebDriver driver,String locator) {
		explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
	}
	public void waitToElementInvisiable(WebDriver driver,String locator) {
		explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
	}
	public void waitToElementClickable(WebDriver driver,String locator) {
		explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
	}
	public boolean waitToJqueyAndJavascripLoadedSuccess(WebDriver driver) {

		explicitWait = new WebDriverWait(driver, 30);
	    jsExecutor= (JavascriptExecutor)driver;
	    // wait for jQuery to load
	    ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
	      @Override
	      public Boolean apply(WebDriver driver) {
	        try {
	          return ((Long)jsExecutor.executeScript("return jQuery.active") == 0);
	        }
	        catch (Exception e) {
	          return true;
	        }
	      }
	    };

	    // wait for Javascript to load
	    ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
	      @Override
	      public Boolean apply(WebDriver driver) {
	        return jsExecutor.executeScript("return document.readyState")
	            .toString().equals("complete");
	      }
	    };

	  return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}
	
	private WebDriverWait explicitWait;
	private JavascriptExecutor jsExecutor;
	private WebElement element;
	private List<WebElement> elements;
	private Select select;
}
