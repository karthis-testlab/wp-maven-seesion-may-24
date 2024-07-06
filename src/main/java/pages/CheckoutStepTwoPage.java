package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckoutStepTwoPage {
	
	private ChromeDriver driver;
	
	public CheckoutStepTwoPage(ChromeDriver driver) {
		this.driver = driver;
	}
	
	public String getProductName() {
		 return driver.findElement(By.cssSelector("div.inventory_item_name")).getText();
	}
	
	public void clickFinishBtn() {
		driver.findElement(By.id("finish")).click();
	}

}
