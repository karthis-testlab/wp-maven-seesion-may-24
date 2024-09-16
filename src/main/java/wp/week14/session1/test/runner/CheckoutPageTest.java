package wp.week14.session1.test.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		          features = "src/main/java/wp/week14/session1/features/checkout.feature",
		          glue = {"wp.week14.session1.step.definitions"},
		          dryRun = false,		          
		          plugin = { 
		        		  "pretty", 
		        		  "html:reports/result.html", 
		        		  "json:report.json", 
		        		  "rerun:src/test/resources/failedtest.txt",
		        		  "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"
		        		  }
		         )

public class CheckoutPageTest extends AbstractTestNGCucumberTests {
	
	@DataProvider(parallel = true)
    public Object[][] scenarios() {
		return super.scenarios();		
	}

}