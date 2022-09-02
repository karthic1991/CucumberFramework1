package utils;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;

public class TestContextSetup {

	public WebDriver driver;
	public String landingpageproductName;
	public PageObjectManager pageobjectmanager;
	public TestBase testbase;
	public GenericUtils genericutils;
	
	public TestContextSetup() {
		testbase = new TestBase();
		 pageobjectmanager = new PageObjectManager(testbase.webDriverManager());
		 genericutils = new GenericUtils(testbase.webDriverManager());
	}
}
