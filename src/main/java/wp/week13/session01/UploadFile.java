package wp.week13.session01;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class UploadFile {

	public static void main(String[] args) throws IOException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-search-engine-choice-screen");
		options.addArguments("--start-maximized");	
		ChromeDriver driver = new ChromeDriver(options);		
		driver.get("https://www.ilovepdf.com/word_to_pdf");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("pickfiles")).click();
		File file = new File(System.getProperty("user.dir")+"/data/L&D ATM - Hometask - Introduction To Test Automation.docx");	
		uploadUsingRobotClass(file.getCanonicalPath());
		//driver.findElement(By.id("file-upload")).sendKeys(file.getCanonicalPath());
		//driver.findElement(By.id("file-submit")).click();
		//System.out.println(driver.findElement(By.id("uploaded-files")).getText().trim());

	}
	
	static void uploadUsingRobotClass(String filePath) {
		try {
			Robot robot = new Robot();
			robot.setAutoDelay(1000);
			StringSelection copyFilePath = new StringSelection(filePath);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(copyFilePath, null);
			robot.setAutoDelay(1000);			
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);			
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_CONTROL);
		} catch (AWTException e) {			
			e.printStackTrace();
		}
	}

}
