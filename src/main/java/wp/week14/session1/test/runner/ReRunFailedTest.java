package wp.week14.session1.test.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		          features = "@src/test/resources/failedtest.txt",
		          glue = {"wp.week14.session1.step.definitions"},
		          dryRun = false,
		          tags = "@smoke",
		          plugin = { "pretty", "html:reports/result.html", "json:report.json", "rerun:src/test/resources/failedtest.txt"}
		         )

public class ReRunFailedTest extends AbstractTestNGCucumberTests {

}