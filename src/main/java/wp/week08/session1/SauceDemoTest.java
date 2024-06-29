package wp.week08.session1;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceDemoTest extends TestNGHooks {
	
	@Test
	public void validateAddToCartFlow() {
		String item_name = driver.findElement(By.cssSelector("div.inventory_item:first-child > div.inventory_item_description > div.inventory_item_label > a > div.inventory_item_name")).getText();
		driver.findElement(By.cssSelector("div.inventory_item:first-child > div.inventory_item_description >  div.pricebar > button")).click();
	    driver.findElement(By.cssSelector("div#shopping_cart_container > a")).click();
	    Assert.assertEquals(driver.findElement(By.cssSelector("div.inventory_item_name")).getText(), item_name);
	}
	
	@Test
	public void validateProductNameInCheckPage() {		
		String item_name = driver.findElement(By.cssSelector("div.inventory_item:first-child > div.inventory_item_description > div.inventory_item_label > a > div.inventory_item_name")).getText();
		//driver.findElement(By.cssSelector("div.inventory_item:first-child > div.inventory_item_description >  div.pricebar > button")).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.inventory_item:first-child > div.inventory_item_description >  div.pricebar > button[id^=remove]")));
		driver.findElement(By.cssSelector("div#shopping_cart_container > a")).click();
	    Assert.assertEquals(driver.findElement(By.cssSelector("div.inventory_item_name")).getText(), item_name);
	    driver.findElement(By.cssSelector("button#checkout")).click();
	    driver.findElement(By.cssSelector("input#first-name")).sendKeys("Karthikeyan");
	    driver.findElement(By.cssSelector("input#last-name")).sendKeys("Rajendran");
	    driver.findElement(By.cssSelector("input#postal-code")).sendKeys("626117");
	    driver.findElement(By.cssSelector("input#continue")).click(); 
	    Assert.assertEquals(driver.findElement(By.cssSelector("div.inventory_item_name")).getText(), item_name);
	}

}