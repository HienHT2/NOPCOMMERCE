package basic;



public class Topic_04_Dynamic_Locator {

	public static void main(String[] args) {
		//final String DYNAMIC_LINK="//div[@class='footer-upper']//a[text()='%s']";
		final String DYNAMIC_TOTAL="//td[text()='%s']/following-sibling::td[text()='%s']";
		final String DYNAMIC_TOTAL1="//td[text()='%s']/following-sibling::td[text()='%s']//a[text()='%s']";
	    clickToElement(DYNAMIC_TOTAL, "Sitemap","123456");
	    clickToElement(DYNAMIC_TOTAL, "Search","12876");
	    clickToElement(DYNAMIC_TOTAL1, "News","123450","xyz");
	    clickToElement(DYNAMIC_TOTAL1, "Blog", "123450","acb");
	   
	    

	}

//	public static void clickToElement(String locator, String pageName) {
//		//locator = //div[@class='footer-upper']//a[text()='%s']
//		//pageName=Sitemap
//		
//		locator = String.format(locator, pageName);
//		//locator = String.format("//div[@class='footer-upper']//a[text()='%s']",Sitemap )
//		System.out.println("Click to Element:" + locator);
//	}
//	public static void isElementDisplayed(String locator, String CountryName, String total) {
//		locator = String.format(locator, CountryName,total );
//		System.out.println("Element isDisplay:" + locator);
//	}
	public static void clickToElement(String locator, String... values) {
		//gan du lieu vao 1 dymanic locator
		//rest parametr
		locator = String.format(locator, (Object[])values);
		System.out.println("Element isDisplay:" + locator);
	}

}
