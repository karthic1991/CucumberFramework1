package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
	
		public WebDriver driver;
		
		public OffersPage(WebDriver driver) {
			
			this.driver = driver;
			
		}

		//page objects of the landing page step definition
		By search = (By.xpath("//input[@type='search']"));
		By productName =(By.xpath("//tr/td[contains(text(),'Tomato')]"));
		
		
		//actions using  the above page objects
		public void searchItem(String shortName) {
			driver.findElement(search).sendKeys(shortName);
		}
			
		public String getProductName() {
			return driver.findElement(productName).getText();
		}
		
		
		
		
}


