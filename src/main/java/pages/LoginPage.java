package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Step 1: We need to create class based on the application pages
 * Step 2: We need to create private reference variable for the driver
 * Step 3: We need to create parameterized Constructor
 * Step 4: We need to add driver argument in the Constructor
 * Step 5: Initialised the current class driver to argumenent passed driver
 *  
 */
public class LoginPage {

	private ChromeDriver driver;

	public LoginPage(ChromeDriver driver) {
		this.driver = driver;
	}

	public void enterUsername(String userName) {
		driver.findElement(By.id("user-name")).sendKeys(userName);
	}

	public void enterPassword(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
	}

	public void clickLoginBtn() {
		driver.findElement(By.id("login-button")).click();
	}

}