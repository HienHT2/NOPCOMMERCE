package manualTesting;

import automationTestting.Selenium;

public class Jare extends Selenium{

	public static void main(String[] args) {
	 
     
      
	}
	String getParentSponsor() {
		return sponsor;
	}
	void setParentSponsor(String sponsorName) {
		sponsor= sponsorName;
		getSponsor();
	}

}
