package stepDefnitions;

import java.util.Iterator;
import java.util.Set;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class LandingPageStepDefnition {
	public WebDriver driver;
	@Given("User is on GreenCart landing page")
	public void user_is_on_green_cart_landing_page() {
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	}
	@When("User searched for ShortName {string} and extract the actual name of product")
	public void user_searched_for_short_name_and_extract_the_actual_name_of_product(String shortName) {
       driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
       String landingpageproductName = driver.findElement(By.xpath("//h4[contains(text(),'Tomato')]")).getText().split(" ")[0].trim();
	   System.out.println(landingpageproductName +"is extracted from the HomePage");
	   
	}
	@Then("User searched for the {string} ShortName in offers page")
	public void user_searched_for_the_same_short_name_in_offers_page (String shortName) {
	
	    driver.findElement(By.linkText("Top Deals")).click();
	    Set<String> s1 = driver.getWindowHandles();
	    Iterator<String> i1 = s1.iterator();
	    String parentwindow = i1.next();
	    String childwindow = i1.next();
	    
	    driver.switchTo().window(childwindow);
	    driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
	    String offerspageproductname = driver.findElement(By.xpath("//tr/td[contains(text(),'Tomato')]")).getText();
	    System.out.println(offerspageproductname +"is extracted from the offerspage");
	    
	}

}
