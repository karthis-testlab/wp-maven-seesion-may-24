package wp.week14.session1.step.definitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseClass{	
	
	@Before
	public void beforeScenario() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-search-engine-choice-screen");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
	}
	
	@After
	public void afterSCenario(Scenario scenario) throws IOException {
		if(scenario.isFailed()) {
			File src = driver.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("./images/"+scenario.getId()+".png"));
			scenario.attach(driver.getScreenshotAs(OutputType.BYTES), "image/png", "Click Here! --> To view error snap shot.");
		}
		driver.quit();
	}	
	
}