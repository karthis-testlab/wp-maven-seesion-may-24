package wp.week08.session1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class TestNGHooks {
	
	public RemoteWebDriver driver;
	public WebDriverWait wait;
	
	@BeforeSuite
	public void beforeSuite() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	
	@BeforeTest
	public void beforeTest() {
		
	}
	
	@BeforeClass
	public void beforeClass() {
		
	}
	
	@Parameters({ "url", "uName", "password"})
	@BeforeMethod
	public void beforeMethod(String url, String uName, String pwd) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.cssSelector("input#user-name")).sendKeys(uName);
		driver.findElement(By.cssSelector("input#password")).sendKeys(pwd);
		driver.findElement(By.cssSelector("input#login-button")).click();	
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		if(!result.isSuccess()) {
			File srcImg = driver.getScreenshotAs(OutputType.FILE);
			File dstImg = new File("./images/"+result.getName()+".png");
			FileUtils.copyFile(srcImg, dstImg);		
		}		
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.id("logout_sidebar_link")).click();
	}
	
	@AfterClass
	public void afterClass() {
		
	}
	
	@AfterTest
	public void afterTest() {
		
	}
	
	@AfterSuite
	public void afterSuite() {
		driver.close();
	}

}