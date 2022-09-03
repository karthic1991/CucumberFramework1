package stepDefnitions;

import java.util.Iterator;
import java.util.Set;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import utils.TestContextSetup;


public class OfferPageStepDefnition {
//	public WebDriver driver;
//	public String landingpageproductName;
	public String offerspageproductname;
	
	TestContextSetup testContextSetup;
	
	public OfferPageStepDefnition(TestContextSetup testContextSetup){
		this.testContextSetup=testContextSetup;
	}
	
	
	
	
	@Then("^User searched for the (.+) ShortName in offers page$")
	public void user_searched_for_the_same_short_name_in_offers_page (String shortName) throws InterruptedException {
	
		switchToOffersPage();
		OffersPage offerspage = new OffersPage(testContextSetup.pageobjectmanager.driver);
		offerspage.searchItem(shortName);
	    //testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
	    Thread.sleep(5000);
	    //offerspageproductname = testContextSetup.driver.findElement(By.xpath("//tr/td[contains(text(),'Tomato')]")).getText();
	    offerspageproductname = offerspage.getProductName();
	    System.out.println(offerspageproductname +"is extracted from the offerspage");
	    
	}
	 public void switchToOffersPage() {
		 LandingPage landingpage = testContextSetup.pageobjectmanager.getLandingPage();
		 landingpage.selectTopDeals();
		 testContextSetup.genericutils.windowHandles();
		 
		 //testContextSetup.driver.findElement(By.linkText("Top Deals")).click();
//		    Set<String> s1 = testContextSetup.driver.getWindowHandles();
//		    Iterator<String> i1 = s1.iterator();
//		    String parentwindow = i1.next();
//		    String childwindow = i1.next();
//		    
//		    testContextSetup.driver.switchTo().window(childwindow);
		    
		 
		 
		 
	 }
	 
	@And("validate product name in landing page matches with offers page")
	public void validate_product_name_in_landing_page_matches_with_offers_page() {
		
		Assert.assertEquals(testContextSetup.landingpageproductName, offerspageproductname);
		
	}
}
