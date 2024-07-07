package pages.chain.pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
	
	private ChromeDriver driver;

	public LoginPage(ChromeDriver driver) {
		this.driver = driver;
	}

	public LoginPage enterUsername(String userName) {
		driver.findElement(By.id("user-name")).sendKeys(userName);
		return this;
	}

	public LoginPage enterPassword(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
		return this;
	}

	public InventoryPage clickLoginBtn() {
		driver.findElement(By.id("login-button")).click();
		return new InventoryPage(driver);
	}

}