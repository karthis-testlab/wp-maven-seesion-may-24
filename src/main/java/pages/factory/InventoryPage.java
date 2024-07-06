package pages.factory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {
	
	@FindBy(css = "div.inventory_item:first-child > div.inventory_item_description > div.inventory_item_label > a > div.inventory_item_name")
	WebElement firstProuctNameElement;
	
	@FindBy(css = "div.inventory_item:first-child > div.inventory_item_description >  div.pricebar > button")
	WebElement firstProuctAddToCartButton;
	
	@FindBy(css = "div#shopping_cart_container > a")
	WebElement shippingCartIconElement;	
	
	public InventoryPage(ChromeDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String getFirstProductName() {
		return firstProuctNameElement.getText();
	}
	
	public void clickFristProductAddToCart() {
		firstProuctAddToCartButton.click();
	}
	
	public void clickShippingCartIcon() {
		shippingCartIconElement.click();
	}

}