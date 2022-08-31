package stepDefnitions;

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
		WebDriverManager.chromedriver().setup();l
	    driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	}
	@When("User searched for ShortName {string} and extract the actual name of product")
	public void user_searched_for_short_name_and_extract_the_actual_name_of_product(String shortName) {
       driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
       String productName = driver.findElement(By.xpath("//h4[contains(text(),'Tomato')]")).getText().split(" ")[0].trim();
	   System.out.println(productName +"is extracted from the HomePage");
	   
	}
	@Then("User searched for the same ShortName in offers page to check the product exit")
	public void user_searched_for_the_same_short_name_in_offers_page_to_check_the_product_exit() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
