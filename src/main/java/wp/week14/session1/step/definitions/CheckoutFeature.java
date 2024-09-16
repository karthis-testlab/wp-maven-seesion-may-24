package wp.week14.session1.step.definitions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutFeature extends BaseClass {	
	
	private String productName;	
	
	@Given("saucelab demo registered user entered the login page")
	public void saucelab_demo_registered_user_entered_the_login_page() {		
		getDriver().get("https://www.saucedemo.com/");
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@Given("the user enters the valid username {string} and {string} password")
	public void the_user_enters_the_valid_username_and_password(String username, String password) {
		getDriver().findElement(By.id("user-name")).sendKeys(username);
		getDriver().findElement(By.id("password")).sendKeys(password);
	}

	@Given("the user clicks on the login button")
	public void the_user_clicks_on_the_login_button() {
		getDriver().findElement(By.id("login-button")).click();
	}

	@Given("user select the first product in the inventory page")
	public void user_select_the_first_product_in_the_inventory_page() {
		productName = getDriver().findElement(By.cssSelector("div.inventory_item_name ")).getText();
		getDriver().findElement(By.xpath("//button[text()='Add to cart']")).click();
	}

	@Given("user goto add cart page and confirm the product name")
	public void user_goto_add_cart_page_and_confirm_the_product_name() {
		getDriver().findElement(By.cssSelector("a.shopping_cart_link")).click();
	}
	
	@Given("^the user selects given (.*) product name from inventory list$")
	public void the_user_selects_given_sauce_labs_bike_light_product_name_from_inventory_list(String productName) {
	   List<WebElement> elements = getDriver().findElements(By.cssSelector("div.inventory_item_name"));
	   List<WebElement> addToCart = getDriver().findElements(By.xpath("//button[text()='Add to cart']"));
	   for (int i = 0; i < elements.size(); i++) {
		   if(elements.get(i).getText().equals(productName)) {
			   this.productName = elements.get(i).getText();
			   addToCart.get(i).click();
			   break;
		   }
	   }	   	   
	}

	@When("the user clicks on the checout page")
	public void the_user_clicks_on_the_checout_page() {
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertEquals(getDriver().findElement(By.cssSelector("div.inventory_item_name")).getText(), productName);
		getDriver().findElement(By.id("checkout")).click();
	}

	@When("the user enters their personal information")
	public void the_user_enters_their_personal_information(DataTable informations) {
		List<List<String>> data = informations.cells();
		for (int i = 0; i < data.size(); i++) {
			getDriver().findElement(By.id("first-name")).sendKeys(data.get(i).get(0));
			getDriver().findElement(By.id("last-name")).sendKeys(data.get(i).get(1));
			getDriver().findElement(By.id("postal-code")).sendKeys(data.get(i).get(2));
		}
	}

	@When("click on the contiue button")
	public void click_on_the_contiue_button() {
		getDriver().findElement(By.id("continue")).click();
	}

	@Then("validate the information displayed in the checout area")
	public void validate_the_information_displayed_in_the_checout_area() {
		Assert.assertEquals(getDriver().findElement(By.cssSelector("div.inventory_item_name")).getText(), productName);		
	}

}