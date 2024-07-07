package pages.chain.pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckoutStepOnePage {
	
	private ChromeDriver driver;
	
	public CheckoutStepOnePage(ChromeDriver driver) {
		this.driver = driver;
	}
	
	public CheckoutStepOnePage enterFirstName(String firstName) {
		driver.findElement(By.cssSelector("input#first-name")).sendKeys(firstName);
		return this;
	}
	
	public CheckoutStepOnePage enterLastName(String lastName) {
		driver.findElement(By.cssSelector("input#last-name")).sendKeys(lastName);
		return this;
	}
	
	public CheckoutStepOnePage enterZipCode(String zipCode) {
		driver.findElement(By.cssSelector("input#postal-code")).sendKeys(zipCode);
		return this;
	}
	
	public CheckoutStepTwoPage clickContinueBtn() {
		driver.findElement(By.cssSelector("input#continue")).click();
		return new CheckoutStepTwoPage(driver);
	}

}