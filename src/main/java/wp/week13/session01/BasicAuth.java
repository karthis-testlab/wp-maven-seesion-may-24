package wp.week13.session01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BasicAuth {
	
	static ChromeDriver driver;

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-search-engine-choice-screen");
		options.addArguments("--start-maximized");
		options.addArguments("--headless");
		driver = new ChromeDriver(options);		
		driver.register(UsernameAndPassword.of("admin", "admin"));		
		driver.get("https://the-internet.herokuapp.com/basic_auth");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		System.out.println(driver.findElement(By.tagName("h3")).getText());
		driver.quit();

	}
	
	static String basicAuth() {
		return "https://username:password@the-internet.herokuapp.com/basic_auth";
	}
	

}