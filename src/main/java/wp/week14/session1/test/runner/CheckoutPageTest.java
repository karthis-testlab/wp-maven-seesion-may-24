package wp.week14.session1.test.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		          features = "src/main/java/wp/week14/session1/features/checkout.feature",
		          glue = "wp.week14.session1.step.definitions",
		          dryRun = false,
		          plugin = { "pretty", "html:reports/result.html"}
		         )

public class CheckoutPageTest extends AbstractTestNGCucumberTests {

}