package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	public WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		
		this.driver = driver;
		
	}

	//page objects of the landing page step definition
	By search = (By.xpath("//input[@type='search']"));
	By productname = (By.xpath("//h4[contains(text(),'Tomato')]"));
	
	//actions using  the above page objects
	public void searchItem(String shortName) {
		driver.findElement(search).sendKeys(shortName);
	}
	
	public void getSearchText() {
		
		driver.findElement(search).getText();	 
	}
	
	public String getProductName() {
		
		return driver.findElement(productname).getText().split(" ")[0].trim();
	}
}