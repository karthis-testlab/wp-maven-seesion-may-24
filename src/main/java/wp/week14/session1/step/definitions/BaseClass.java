package wp.week14.session1.step.definitions;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass {
	
	private ChromeDriver driver = null;
	private static final ThreadLocal<ChromeDriver> tlDriver = new ThreadLocal<ChromeDriver>();
	
	public void setDriver() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-search-engine-choice-screen");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		tlDriver.set(driver);
	}
	
	public ChromeDriver getDriver() {
		return tlDriver.get();
	}

}