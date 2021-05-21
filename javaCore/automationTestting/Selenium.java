package automationTestting;
public class Selenium {
	// thuoc tinh:Property/Field/ Variable
	private String name="Selenium WebDriver";
	
	//default
	 String organization="Selenium HQ";
	 //Protected
	 protected String sponsor="Saucelab";
	
	 //PUBLIC
	 public String version="3.141.59";
	//Phương thức:Method/Funciton
	private String getName() {
		return name;
	}
	private void setName(String name) {
		this.name = name;
	}
	String getOrganzation() {
		return this.organization;
	}
	protected String getSponsor() {
		return this.sponsor;
	}
	public void setVersion(String newVersion) {
		this.version = newVersion;
	}
	public static void main(String[] args) {
		Selenium selenium = new Selenium();
		
		//Private
		System.out.println(selenium.name);
		System.out.println(selenium.getName());
		selenium.setName("setNameSelenium");
		System.out.println(selenium.getName());
		selenium.name="Selenium EDI";
		
		//Default
		System.out.println(selenium.organization);
		
		//protected
		System.out.println(selenium.getSponsor());
		System.out.println(selenium.sponsor);
		
		//public
		System.out.println(selenium.version);
		selenium.setVersion("4.10");
		System.out.println(selenium.version);
		
		
	}
}