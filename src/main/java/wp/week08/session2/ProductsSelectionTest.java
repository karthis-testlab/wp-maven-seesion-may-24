package wp.week08.session2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ProductsSelectionTest {
	
	RemoteWebDriver driver;
	WebDriverWait wait;
	
	@DataProvider
	public String[][] getData() {
		return ExcelUtility.getData("testdata");
	}
	
	@Test(dataProvider = "getData")
	public void validateCheckOutCode(String productName, String fName, String lName, String zCode) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		driver.findElement(By.cssSelector("input#user-name")).sendKeys("standard_user");
		driver.findElement(By.cssSelector("input#password")).sendKeys("secret_sauce");
		driver.findElement(By.cssSelector("input#login-button")).click();
		selectProduct(productName);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[id^=remove]")));
		driver.findElement(By.cssSelector("div#shopping_cart_container > a")).click();
		driver.findElement(By.cssSelector("button#checkout")).click();
	    driver.findElement(By.cssSelector("input#first-name")).sendKeys(fName);
	    driver.findElement(By.cssSelector("input#last-name")).sendKeys(lName);
	    driver.findElement(By.cssSelector("input#postal-code")).sendKeys(zCode);
	    driver.findElement(By.cssSelector("input#continue")).click();
	    driver.findElement(By.id("finish")).click();
	    Assert.assertEquals(driver.findElement(By.className("complete-header")).getText(), "Thank you for your order!");
	    Assert.assertTrue(driver.getCurrentUrl().contains("/checkout-complete.html"));
	    driver.quit();
	}
	
	
	public void selectProduct(String productName) {
		List<WebElement> products = driver.findElements(By.className("inventory_item_name"));
		List<WebElement> addToCart = driver.findElements(By.xpath("//button[text()='Add to cart']"));
		for (int i = 0; i < products.size(); i++) {
			if(products.get(i).getText().equals(productName)) {
				addToCart.get(i).click();
				break;
			}
		}
	}

}