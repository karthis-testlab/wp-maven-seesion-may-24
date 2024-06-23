package wp.week06.session2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SauceDemoTest {
	
	ChromeDriver driver;
	
	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.cssSelector("input#user-name")).sendKeys("standard_user");
		driver.findElement(By.cssSelector("input#password")).sendKeys("secret_sauce");
		driver.findElement(By.cssSelector("input#login-button")).click();
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
	
	@Test(enabled = true)
	public void validateProductNameInCartPage() {		
		String item_name = driver.findElement(By.cssSelector("div.inventory_item:first-child > div.inventory_item_description > div.inventory_item_label > a > div.inventory_item_name")).getText();
		driver.findElement(By.cssSelector("div.inventory_item:first-child > div.inventory_item_description >  div.pricebar > button")).click();
	    driver.findElement(By.cssSelector("div#shopping_cart_container > a")).click();
	    Assert.assertEquals(driver.findElement(By.cssSelector("div.inventory_item_name")).getText(), item_name);	    
	}
	
	@Test(enabled = true)
	public void validateProductNameInCheckPage() {		
		String item_name = driver.findElement(By.cssSelector("div.inventory_item:first-child > div.inventory_item_description > div.inventory_item_label > a > div.inventory_item_name")).getText();
		driver.findElement(By.cssSelector("div.inventory_item:first-child > div.inventory_item_description >  div.pricebar > button")).click();
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