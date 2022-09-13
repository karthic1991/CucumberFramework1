package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
public WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
            By cartbag = By.xpath("//img[@alt='Cart']");;
            By checkoutbutton =  By.xpath("//button[contains(text(), 'PROCEED TO CHECKOUT')]");
            By promobutton = By.xpath("//button[@class='promoBtn']");
            By placeorder = By.xpath("//button[contains(text(),'Place Order')]");
            
            
            
            public void checkOutItems() {
            	
            	driver.findElement(cartbag).click();
            	driver.findElement(checkoutbutton).click();
            }
	
            public boolean verifyPromoButton () {
            	
            	return driver.findElement(promobutton).isDisplayed();
            }
            
            public boolean verifyPlaceOrder() {
            	
            	return driver.findElement(placeorder).isDisplayed();
            }
	
	
	
	
	
	
	
}
