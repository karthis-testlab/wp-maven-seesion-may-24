package pages.chain.pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckoutStepTwoPage {
	
	private ChromeDriver driver;
	
	public CheckoutStepTwoPage(ChromeDriver driver) {
		this.driver = driver;
	}
	
	public String getProductName() {
		 return driver.findElement(By.cssSelector("div.inventory_item_name")).getText();
	}
	
	public CheckoutCompletePage clickFinishBtn() {
		driver.findElement(By.id("finish")).click();
		return new CheckoutCompletePage(driver);
	}
	
	public CheckoutStepTwoPage validateProductName(String expected) {
		Assert.assertEquals(getProductName(), expected);
		return this;
	}

}
