package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckoutCompletePage {
	
	private ChromeDriver driver;
	
	public CheckoutCompletePage(ChromeDriver driver) {
		this.driver = driver;
	}
	
	public String getThanksMessage() {
		return driver.findElement(By.className("complete-header")).getText();
	}
	
	public void clickBackToHomeBtn() {
		driver.findElement(By.id("back-to-products")).click();
	}

}
