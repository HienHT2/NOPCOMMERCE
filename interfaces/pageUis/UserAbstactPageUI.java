package pageUis;

public class UserAbstactPageUI {
	//4 locator
	public static final String MY_PRODUCT_REVIEW_LINK="//div[@class='listbox']//a[text()='My product reviews']";
	public static final String CUSTOMER_INFO_LINK="//div[@class='listbox']//a[text()='Customer info']";
	public static final String ADDRESS_LINK="//div[@class='listbox']//a[text()='Addresses']";
	public static final String ORDERS_LINK="//div[@class='listbox']//a[text()='Orders']";
	//Dynamic Link
	public static final String DYNAMIC_LINK="//div[@class='listbox']//a[text()='%s']";
	public static final String LOADING_ICON ="//div[@id='ajaxBusy']/span";
	public static final String UPLOAD_FILE_TYPE_PANEL="//div[@id='%s']//input[@type='file']";
	public static final String PLUS_ICON_BY_PANEL="//div[@id='%s']//i[contains(@class,'fa-plus')]";
	
}
