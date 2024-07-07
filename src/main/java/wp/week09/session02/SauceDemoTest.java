package wp.week09.session02;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.chain.pattern.InventoryPage;
import pages.chain.pattern.LoginPage;



public class SauceDemoTest {
	
	ChromeDriver driver;	
	
	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();		
		driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		new LoginPage(driver)	
		.enterUsername("standard_user")
		.enterPassword("secret_sauce")
		.clickLoginBtn();
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
	
	@Test(enabled = true)
	public void validateProductNameInCartPage() {		
		
		new InventoryPage(driver)		
		.clickFristProductAddToCart()
	    .clickShippingCartIcon()
	    .validateProductNameInCartPage("Sauce Labs Backpack");	
	    
	}
	
	@Test(enabled = true)
	public void validateProductNameInCheckPage() {	
		
		new InventoryPage(driver)		
		.clickFristProductAddToCart()
	    .clickShippingCartIcon()
	    .validateProductNameInCartPage("Sauce Labs Backpack")
	    .clickCheckoutBtn()
	    .enterFirstName("Karthikeyan")
	    .enterLastName("Rajendran")
	    .enterZipCode("626117")
	    .clickContinueBtn()
	    .validateProductName("Sauce Labs Backpack")
	    .clickFinishBtn()
	    .validateThanksMessage("Thank you for your order!")
	    .clickBackToHomeBtn();
		
	}	

}