package wp.week10.session01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MarutiSuzukiTest {
	
	// AAA Rule
	
	/*
	 *
	 * A - Arrange {Where you set up initial conditions and input for test}
	 * A - Act {Where you execute the code under test}
	 * A - Assert {Where you validate the expected outcomes and behaviors}
	 * 
	 */
	
	ChromeDriver driver;	

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.marutisuzuki.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@Test
	public void testSwiftSearchPage() {
		driver.findElement(By.className("headerSearch-btn")).click();
		driver.findElement(By.name("key")).sendKeys("Swift", Keys.ENTER);
		driver.findElement(By.className("icon-general_info")).click();
		Select city_dropDown = new Select(driver.findElement(By.id("selectcity1")));
		System.out.println("Total Number Cities in dropdown: " + city_dropDown.getOptions().size());
		city_dropDown.selectByIndex(city_dropDown.getOptions().size() - 1);
		driver.findElement(By.partialLinkText("SAFETY")).click();
		System.out.println(driver.findElement(By.className("caption-text")).getText());
		driver.findElement(By.partialLinkText("COLOURS")).click();
		String attribute = driver.findElement(By.cssSelector("[class='active-tab carcolors'] > a > small")).getAttribute("class");
	    String[] split = attribute.split("-");
	    System.out.println(split[1]);
	    System.out.println(split[split.length - 1]);
	    System.out.println(driver.findElement(By.xpath("//strong[text()='Color:']/following-sibling::span[@style]")).getText()); 
	    Assert.assertTrue(driver.getCurrentUrl().contains("/swift"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}