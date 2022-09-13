package stepDefnitions;

import java.util.Set;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import utils.TestContextSetup;


public class CheckOutPageStepDefnition {
//	public WebDriver driver;
//	public String landingpageproductName;
	public String offerspageproductname;
	public CheckoutPage checkoutpage;
	
	TestContextSetup testContextSetup;
	
	public CheckOutPageStepDefnition(TestContextSetup testContextSetup){
		this.testContextSetup=testContextSetup;
		checkoutpage = testContextSetup.pageobjectmanager.getCheckoutPage();
	}
	
	
	@Then("^User proceeds to Checkout and validate the (.+) items in checkout page$")
	public void user_proceeds_to_checkout_and_validate_the_name_items_in_checkout_page(String name) throws InterruptedException {
		checkoutpage.checkOutItems();
		Thread.sleep(2000);
	
	}
	@Then("verify user has ability to enter promo code and place order")
	public void verify_user_has_ability_to_enter_promo_code_and_place_order() throws InterruptedException {
		//CheckoutPage checkoutpage = testContextSetup.pageobjectmanager.getCheckoutPage();
		Thread.sleep(5000);
		Assert.assertTrue(checkoutpage.verifyPromoButton());
		Assert.assertTrue(checkoutpage.verifyPlaceOrder());
	}
}
