package stepDefnitions;

import java.util.Iterator;
import java.util.Set;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class LandingPageStepDefnition {
	public WebDriver driver;
	public String landingpageproductName;
	public String offerspageproductname;
	@Given("User is on GreenCart landing page")
	public void user_is_on_green_cart_landing_page() {
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	}
	@When("User searched for ShortName {string} and extract the actual name of product")
	public void user_searched_for_short_name_and_extract_the_actual_name_of_product(String shortName) throws InterruptedException {
       driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
       Thread.sleep(2000);
       landingpageproductName = driver.findElement(By.xpath("//h4[contains(text(),'Tomato')]")).getText().split(" ")[0].trim();
	   System.out.println(landingpageproductName +"is extracted from the HomePage");
	   
	}
	@Then("User searched for the {string} ShortName in offers page")
	public void user_searched_for_the_same_short_name_in_offers_page (String shortName) throws InterruptedException {
	
	    driver.findElement(By.linkText("Top Deals")).click();
	    Set<String> s1 = driver.getWindowHandles();
	    Iterator<String> i1 = s1.iterator();
	    String parentwindow = i1.next();
	    String childwindow = i1.next();
	    
	    driver.switchTo().window(childwindow);
	    driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
	    Thread.sleep(2000);
	    offerspageproductname = driver.findElement(By.xpath("//tr/td[contains(text(),'Tomato')]")).getText();
	    System.out.println(offerspageproductname +"is extracted from the offerspage");
	    
	}
	
	@And("validate product name in landing page matches with offers page")
	public void validate_product_name_in_landing_page_matches_with_offers_page() {
		
		Assert.assertEquals(landingpageproductName, offerspageproductname);
		
	}
}
