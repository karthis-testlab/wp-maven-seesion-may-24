package pages.chain.pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class InventoryPage {
	
private ChromeDriver driver;
	
	public InventoryPage(ChromeDriver driver) {
		this.driver = driver;
	}
	
	public String getFirstProductName() {
		return driver.findElement(By.cssSelector("div.inventory_item:first-child > div.inventory_item_description > div.inventory_item_label > a > div.inventory_item_name")).getText();
	}
	
	public InventoryPage clickFristProductAddToCart() {
		driver.findElement(By.cssSelector("div.inventory_item:first-child > div.inventory_item_description >  div.pricebar > button")).click();
		return this;
	}
	
	public CartPage clickShippingCartIcon() {
		driver.findElement(By.cssSelector("div#shopping_cart_container > a")).click();
		return new CartPage(driver);
	}
	

}
