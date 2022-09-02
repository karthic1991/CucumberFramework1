package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	public WebDriver driver;
	
	public PageObjectManager(WebDriver driver) {
		
		this.driver = driver;
		
	}
    //it returns landingpage object as classtype
	public LandingPage getLandingPage() {
		
		LandingPage landingpage = new LandingPage(driver);
		return landingpage;
		
	}
	
	public OffersPage getOffersPage() {
		
		OffersPage offerspage = new OffersPage(driver);
		return offerspage;
	}
	
	
	
	
	
	
	
	
	
}
