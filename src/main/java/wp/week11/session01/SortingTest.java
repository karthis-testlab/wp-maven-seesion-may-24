package wp.week11.session01;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SortingTest {
	
	FirefoxDriver driver;	
	
	@BeforeMethod
	public void setUp() {
	    driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
	}
	
	@Test
	public void testLowestPriceShouldDisplayFirst() {
		List<Double> prices = new ArrayList<Double>();
		List<WebElement> elements = driver.findElements(By.className("inventory_item_price"));
		for (WebElement element : elements) {
			prices.add(Double.valueOf(element.getText().replaceAll("\\$", "")));		
		}		
		Collections.sort(prices);
		Select dropdown = new Select(driver.findElement(By.className("product_sort_container")));
		dropdown.selectByVisibleText("Price (low to high)");
		String actual = driver.findElement(By.className("inventory_item_price")).getText();
		String expected = "$"+prices.get(0);
		System.out.println("Actual: "+actual);
		System.out.println("Expected: "+expected);
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void testProductNameDisplayedAsAtoZ() {
		Select dropdown = new Select(driver.findElement(By.className("product_sort_container")));
		dropdown.selectByVisibleText("Price (low to high)");
		List<String> productName = new ArrayList<String>();
		List<WebElement> elements = driver.findElements(By.className("inventory_item_name"));
		for (WebElement element : elements) {
			productName.add(element.getText());		
		}		
		System.out.println(productName);
		Collections.sort(productName, Collections.reverseOrder());
		System.out.println(productName);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}