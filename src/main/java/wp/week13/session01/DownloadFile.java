package wp.week13.session01;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DownloadFile {

	public static void main(String[] args) throws IOException {
		
		File file = new File(System.getProperty("user.dir")+"/data/");	
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("download.default_directory", file.getCanonicalPath());
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", map);
		options.addArguments("--disable-search-engine-choice-screen");
		options.addArguments("--start-maximized");	
		ChromeDriver driver = new ChromeDriver(options);		
		driver.get("https://the-internet.herokuapp.com/download");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.linkText("sample.png")).click();
		String[] list = file.list();
		System.out.println(Arrays.toString(list));
		
	}

}
