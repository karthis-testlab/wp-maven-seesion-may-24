package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckoutStepOnePage {
	
	private ChromeDriver driver;
	
	public CheckoutStepOnePage(ChromeDriver driver) {
		this.driver = driver;
	}
	
	public void enterFirstName(String firstName) {
		driver.findElement(By.cssSelector("input#first-name")).sendKeys(firstName);
	}
	
	public void enterLastName(String lastName) {
		driver.findElement(By.cssSelector("input#last-name")).sendKeys(lastName);
	}
	
	public void enterZipCode(String zipCode) {
		driver.findElement(By.cssSelector("input#postal-code")).sendKeys(zipCode);
	}
	
	public void clickContinueBtn() {
		driver.findElement(By.cssSelector("input#continue")).click();
	}

}