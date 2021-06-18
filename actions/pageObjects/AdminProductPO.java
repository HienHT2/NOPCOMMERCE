package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import commons.AbstractPage;
import pageUis.AdminProductPageUI;

public class AdminProductPO extends AbstractPage {
	WebDriver driver;

	public AdminProductPO(WebDriver driver) {

		this.driver = driver;
	}

	public void goToPageAtTableByIndex(String indexPage) {
		waitToElementClickable(driver, AdminProductPageUI.PAGEING_AT_TABLE_BY_INDEX, indexPage);
		clickToElement(driver, AdminProductPageUI.PAGEING_AT_TABLE_BY_INDEX, indexPage);
		
	}

	public boolean isPageActiveAtTableByIndex(String indexPage) {
		waitToElementClickable(driver, AdminProductPageUI.PAGEING_AT_TABLE_ACTIVE_BY_INDEX, indexPage);
		
		return isElementDisplay(driver, AdminProductPageUI.PAGEING_AT_TABLE_ACTIVE_BY_INDEX, indexPage);
	}

	public void checkToSelectAllCheckbox() {
		waitToElementClickable(driver,AdminProductPageUI.SELECT_ALL_CHECKBOX);
		checkToCheckbox(driver, AdminProductPageUI.SELECT_ALL_CHECKBOX);
		
		
	}

	public void uncheckToSelectAllCheckbox() {
		waitToElementClickable(driver,AdminProductPageUI.SELECT_ALL_CHECKBOX);
		uncheckToCheckbox(driver, AdminProductPageUI.SELECT_ALL_CHECKBOX);
		
	}

	public void allProductCheckboxChecked() {
		List<WebElement> allProductCheckboxs= getElements(driver, AdminProductPageUI.SELECT_ALL_CHECKBOX);
		for (WebElement productCheckbox : allProductCheckboxs) {
				Assert.assertTrue(productCheckbox.isSelected());
		}
		
	}

	public void allProductCheckboxUnChecked() {
		List<WebElement> allProductCheckboxs= getElements(driver, AdminProductPageUI.SELECT_ALL_CHECKBOX);
		for (WebElement productCheckbox : allProductCheckboxs) {
				Assert.assertFalse(productCheckbox.isSelected());
		}
		
	}

	public void checkToProductCheckboxByName(String prodcutName) {
		waitToElementClickable(driver, AdminProductPageUI.ITEM_PRODUCT_CHECKBOX,prodcutName);
		checkToCheckbox(driver, AdminProductPageUI.ITEM_PRODUCT_CHECKBOX,prodcutName);
		
		
		
		
	}

	public void waitForProductNumberToBe() {
		String productNumberSelected= getFirstSelectedTextInDropdown(driver, AdminProductPageUI.NUMBER_ITEM_DROPDOWN);
		System.out.println("Number of Element"+ productNumberSelected);
		waitToElementsNumberToBe(driver, AdminProductPageUI.PRODUCT_TABLE_ROW,Integer.parseInt(productNumberSelected));
		
	}
	
	public boolean areProductDetailDisplyed(String productName, String skuID, String price, String quanty, String publishStatus) {
		waitToElementVisiable(driver, AdminProductPageUI.PRODUCT_DETAIL_IN_TABLE,productName,skuID,price, quanty,publishStatus);
		return isElementDisplay(driver, AdminProductPageUI.PRODUCT_DETAIL_IN_TABLE,productName,skuID,price, quanty,publishStatus);
	}

	public void selectShowItemDropdown(String itemNumber) {
		waitToElementClickable(driver, AdminProductPageUI.SHOW_NUMBER_ITEM_DROPDOWN);
		selectItemInDropdown(driver, AdminProductPageUI.SHOW_NUMBER_ITEM_DROPDOWN,itemNumber);
		
		
	}

	public boolean isInfomationtDisplayedAtColumnNameAndRowNumber(String columnName, String rowIndex, String expectedValue) {
		//Lấy ra được index coulum
		int columNameIndex = countElementSize(driver, AdminProductPageUI.COLUMN_NAME_SIBLING,columnName,rowIndex,expectedValue) + 1;
		//String columNameIndex= columNameIndex+1;
		String actualValue=getElementText(driver, AdminProductPageUI.CELL_VALUE_MIX_BY_COLUMN_AND_ROW_INDEX,rowIndex,String.valueOf(columNameIndex));
		
		return actualValue.equals(expectedValue);
	}

	public boolean isPublicStatusAtColumnNameAndRowNumber(String columnName, String rowIndex, String publicStatus) {
		int columNameIndex = countElementSize(driver, AdminProductPageUI.COLUMN_NAME_SIBLING,columnName,rowIndex,publicStatus) + 1;
		return isElementDisplay(driver, AdminProductPageUI.PUBLIC_STATUS_MIXCOLUMN_AND_ROW_INDEX, rowIndex, String.valueOf(columNameIndex),publicStatus);
	}

	public void clickToEditIconProductDetailByName(String productName) {
		waitToElementClickable(driver, AdminProductPageUI.EDIT_ICON_BY_PRODUCT_NAME, productName);
		clickToElement(driver, AdminProductPageUI.EDIT_ICON_BY_PRODUCT_NAME, productName);
		
		
		
	}

	public void inputProductNameTextbox(String productName) {
		waitToElementVisiable(driver, AdminProductPageUI.PRODUCT_NAME_TEXTBOX);
		senkeyToElement(driver, AdminProductPageUI.PRODUCT_NAME_TEXTBOX, productName);
		
	}

	public void clickToSearchButton() {
		waitToElementVisiable(driver, AdminProductPageUI.SEARCH_BUTTON);
		clickToElement(driver, AdminProductPageUI.SEARCH_BUTTON);
		waitAjaxLoadingInvisible(driver);
		
		
	}

	public void scrollToPicturePanel() {
		scrollToElement(driver, AdminProductPageUI.PICTURE_PANEL);
		
		
	}

	public void inputToAltTextBox(String imageDescription) {
		waitToElementVisiable(driver, AdminProductPageUI.ALT_TEXTBOX);
		senkeyToElement(driver,AdminProductPageUI.ALT_TEXTBOX, imageDescription);
		
	}

	public void inputToTitleTextBox(String imageTitle) {
		waitToElementVisiable(driver, AdminProductPageUI.TITLE_TEXTBOX);
		senkeyToElement(driver,AdminProductPageUI.TITLE_TEXTBOX, imageTitle);
		
	}
	
	public void clickToIconAtToOderTextBox(String iconValue) {
		waitToElementClickable(driver, AdminProductPageUI.ICON_VALUE_AT_ORDER_TEXBOX,iconValue);
		clickToElement(driver, AdminProductPageUI.ICON_VALUE_AT_ORDER_TEXBOX, iconValue);
		
	}
	public void clickToAddProductPictureButton() {
		waitToElementClickable(driver, AdminProductPageUI.ADD_PRODUCT_PICTURE_BUTTON);
		clickToElement(driver, AdminProductPageUI.ADD_PRODUCT_PICTURE_BUTTON);
		waitAjaxLoadingInvisible(driver);
		
	}
	//productName,pictureOrder, pictureALT, pictureTitle
	public boolean areImageDetailDisplayed(String productName, String pictureOrder, String pictureALT, String pictureTitle) {
		waitToElementVisiable(driver, AdminProductPageUI.IMAGE_UPLOAD_DETAIL, productName.toLowerCase().replace(" ", "-"),pictureOrder,pictureALT,pictureTitle);
		return isElementDisplay(driver, AdminProductPageUI.IMAGE_UPLOAD_DETAIL, productName.toLowerCase().replace(" ", "-"),pictureOrder,pictureALT,pictureTitle);
		
		
	}
	
	//fileName, productName, "AD_CS4_PH", "75", "10000","true"
	public boolean areProductDisplayed(String productORDefautlName, String productName,  String productSku, String productPrice, String productQty,String productStatus) {
		waitToElementVisiable(driver, AdminProductPageUI.PRODUCT_DETAIL, productORDefautlName.toLowerCase().replace(" ", "-"),productName,productSku,productPrice,productQty,productStatus);
		return isElementDisplay(driver, AdminProductPageUI.PRODUCT_DETAIL, productORDefautlName.toLowerCase().replace(" ", "-"),productName,productSku,productPrice,productQty,productStatus);
		
	}
	public void clickToSaveButton() {
		waitToElementClickable(driver, AdminProductPageUI.SAVE_BUTTON);
		clickToElement(driver, AdminProductPageUI.SAVE_BUTTON);
		waitAjaxLoadingInvisible(driver);
	}

	public void inputToProductNameTextbox(String string) {
		// TODO Auto-generated method stub
		
	}

	public void clickToDeleteButtonByPictureName(String pictureTitle) {
		waitToElementClickable(driver, AdminProductPageUI.DELETE_BUTTON,pictureTitle);
		clickToElement(driver, AdminProductPageUI.DELETE_BUTTON,pictureTitle);
		waitAlertPresent(driver);
		acceptAlert(driver);
		waitAjaxLoadingInvisible(driver);
		
	}

	public boolean isNewPictrueUploadSuccess(String fileName) {
		waitToElementInvisiable(driver, AdminProductPageUI.SPINNER_UPLOAD);
		return isElementDisplay(driver, AdminProductPageUI.UPLOAD_FILE_NAME, fileName);
	}

	
}
