package wp.week10.session02;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SeleniumScrollAction {
	
	static ChromeDriver driver;
	
	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.linkText("WYSIWYG Editor")));
	}
	
	public static void scrollByActionsClass() {
		new Actions(driver)
		.scrollToElement(driver.findElement(By.linkText("WYSIWYG Editor")))
		.perform();
	}

}
