package wp.week10.session02;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SeleniumClickAction {

	static ChromeDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		normalClick();
	}

	public static void normalClick() {
		driver.findElement(By.linkText("Checkboxes")).click();
	}
	
	public static void javaScriptClick() {
		driver.executeScript("arguments[0].click();", driver.findElement(By.linkText("Checkboxes")));
	}
	
	public static void actionsClick() {
		new Actions(driver)
		.moveToElement(driver.findElement(By.linkText("Checkboxes")))
		.click()
		.perform();
	}

}