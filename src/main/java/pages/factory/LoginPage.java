package pages.factory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(id = "user-name")
	WebElement userNameField;
	
	@FindBy(id = "password")
	WebElement passwordField;
	
	@FindBy(id = "login-button")
	WebElement loginButton;
	

	public LoginPage(ChromeDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void enterUsername(String userName) {
		userNameField.sendKeys(userName);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void clickLoginBtn() {
		loginButton.click();
	}

}