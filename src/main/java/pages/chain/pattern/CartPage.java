package pages.chain.pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CartPage {
	
	private ChromeDriver driver;
	
	public CartPage(ChromeDriver driver) {
		this.driver = driver;
	}
	
	public String getProductName() {
		return driver.findElement(By.cssSelector("div.inventory_item_name")).getText();
	}
	
	public CheckoutStepOnePage clickCheckoutBtn() {
		driver.findElement(By.cssSelector("button#checkout")).click();
		return new CheckoutStepOnePage(driver);
	}
	
	public CartPage validateProductNameInCartPage(String expected) {
		Assert.assertEquals(getProductName(), expected);
		return this;
	}

}