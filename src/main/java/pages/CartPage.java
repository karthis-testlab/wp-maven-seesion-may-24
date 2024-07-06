package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class CartPage {
	
	private ChromeDriver driver;
	
	public CartPage(ChromeDriver driver) {
		this.driver = driver;
	}
	
	public String getProductName() {
		return driver.findElement(By.cssSelector("div.inventory_item_name")).getText();
	}
	
	public void clickCheckoutBtn() {
		driver.findElement(By.cssSelector("button#checkout")).click();
	}

}