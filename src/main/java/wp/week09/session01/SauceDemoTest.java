package wp.week09.session01;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.CheckoutCompletePage;
import pages.CheckoutStepOnePage;
import pages.CheckoutStepTwoPage;
import pages.factory.InventoryPage;
import pages.factory.LoginPage;


public class SauceDemoTest {
	
	ChromeDriver driver;
	LoginPage loginPage;
	InventoryPage inventortPage;
	CartPage cartPage;
	CheckoutStepOnePage checkoutStepOnePage;
	CheckoutStepTwoPage checkoutStepTwoPage;
	CheckoutCompletePage checkoutCompletePage;
	
	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		loginPage = new LoginPage(driver);
		inventortPage = new InventoryPage(driver);
		cartPage = new CartPage(driver);
		checkoutStepOnePage = new CheckoutStepOnePage(driver);
		checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
		checkoutCompletePage = new CheckoutCompletePage(driver);
		driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		loginPage.enterUsername("standard_user");
		loginPage.enterPassword("secret_sauce");
		loginPage.clickLoginBtn();
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
	
	@Test(enabled = true)
	public void validateProductNameInCartPage() {		
		String item_name = inventortPage.getFirstProductName();
		inventortPage.clickFristProductAddToCart();
	    inventortPage.clickShippingCartIcon();
	    Assert.assertEquals(cartPage.getProductName(), item_name);	    
	}
	
	@Test(enabled = true)
	public void validateProductNameInCheckPage() {		
		String item_name = inventortPage.getFirstProductName();
		inventortPage.clickFristProductAddToCart();
	    inventortPage.clickShippingCartIcon();
	    Assert.assertEquals(cartPage.getProductName(), item_name);
	    cartPage.clickCheckoutBtn();
	    checkoutStepOnePage.enterFirstName("Karthikeyan");
	    checkoutStepOnePage.enterLastName("Rajendran");
	    checkoutStepOnePage.enterZipCode("626117");
	    checkoutStepOnePage.clickContinueBtn();
	    Assert.assertEquals(checkoutStepTwoPage.getProductName(), item_name);
	    checkoutStepTwoPage.clickFinishBtn();
	    Assert.assertEquals(checkoutCompletePage.getThanksMessage(), "Thank you for your order!");
	    checkoutCompletePage.clickBackToHomeBtn();
	}	

}