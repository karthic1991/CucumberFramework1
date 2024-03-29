package stepDefnitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LandingPage;
import utils.TestContextSetup;


public class LandingPageStepDefnition {
//	public WebDriver driver;
//	public String landingpageproductName;
//	public String offerspageproductname;
	public LandingPage landingPage;
	
	TestContextSetup testContextSetup;
	
	public LandingPageStepDefnition(TestContextSetup testContextSetup){
		this.testContextSetup=testContextSetup;
		this.landingPage = testContextSetup.pageobjectmanager.getLandingPage();
		
	}
	
	
	@Given("User is on GreenCart landing page")
	public void user_is_on_green_cart_landing_page() {
		//Assert.assertTrue(landingPage.getTitleLandingPage().contains("Greenkart"));
		
	}
	@When("^User searched for ShortName (.+) and extract the actual name of product$")
	public void user_searched_for_short_name_and_extract_the_actual_name_of_product(String shortName) throws InterruptedException {
		
		//LandingPage landingPage = testContextSetup.pageobjectmanager.getLandingPage();
		landingPage.searchItem(shortName);
		//testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
       Thread.sleep(2000);
       //testContextSetup.landingpageproductName = testContextSetup.driver.findElement(By.xpath("//h4[contains(text(),'Tomato')]")).getText().split(" ")[0].trim();
       testContextSetup.landingpageproductName = landingPage.getProductName();
	   System.out.println(testContextSetup.landingpageproductName +"is extracted from the HomePage");
	   
	}
	
	@When("User added {string} items of the selected product to cart")
	public void user_added_items_product(String quantity) {
		
		landingPage.IncrementQuantity(Integer.parseInt(quantity));
		landingPage.addToCart();
		
	}
	
}
