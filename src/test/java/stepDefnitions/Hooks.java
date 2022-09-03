package stepDefnitions;

import java.io.IOException;

import io.cucumber.java.After;
import utils.TestContextSetup;

public class Hooks {
	
	TestContextSetup testcontextsetup;
	public Hooks(TestContextSetup testcontextsetup) {
		this.testcontextsetup = testcontextsetup;
		
	}
	
	
	@After
	public void afterScenario() throws IOException{
		
		testcontextsetup.testbase.webDriverManager().quit();
		
	}

}
