package pages.chain.pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckoutCompletePage {
	
	private ChromeDriver driver;
	
	public CheckoutCompletePage(ChromeDriver driver) {
		this.driver = driver;
	}
	
	public String getThanksMessage() {
		return driver.findElement(By.className("complete-header")).getText();
	}
	
	public InventoryPage clickBackToHomeBtn() {
		driver.findElement(By.id("back-to-products")).click();
		return new InventoryPage(driver);
	}
	
	public CheckoutCompletePage validateThanksMessage(String expected) {
		Assert.assertEquals(getThanksMessage(), expected);
		return this;
	}

}
