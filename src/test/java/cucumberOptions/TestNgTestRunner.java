package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features",glue ="stepDefnitions",monochrome =true,dryRun=true)
public class TestNgTestRunner extends AbstractTestNGCucumberTests {

}
