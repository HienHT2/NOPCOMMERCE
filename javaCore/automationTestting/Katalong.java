package automationTestting;

public class Katalong {

	public static void main(String[] args) {
		Selenium selenium= new Selenium();
		selenium.organization="KMS";
		System.out.println(selenium.getOrganzation());
        selenium.sponsor="abc";
        selenium.getSponsor();
        System.out.println( selenium.sponsor);
        System.out.println(selenium.getSponsor());
        
	}

}
