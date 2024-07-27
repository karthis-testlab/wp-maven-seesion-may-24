package wp.week11.session01;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ScreenshotTest {
	
    String date = new SimpleDateFormat("ddMMyyyyhhmmSSssss").format(new Date());
	
	@Test
	public void takeScreenshot() throws IOException {		
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://www.codehim.com/demo/single-page-shopping-cart-template/");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		new Actions(driver)
		.moveToElement(driver.findElement(By.xpath("//div[@id='grid']/div[1]")))
		.click(driver.findElements(By.xpath("//div[@class='add_to_cart']")).get(0))
		.perform();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[text()='No items in cart.']")));
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dist = new File("./images/"+date+".png");
		FileUtils.copyFile(src, dist);
	}	

}