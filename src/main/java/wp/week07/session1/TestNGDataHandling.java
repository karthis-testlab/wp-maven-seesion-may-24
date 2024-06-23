package wp.week07.session1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGDataHandling {
	
	/*
	 * In TestNG we can handle data in two ways
	 * 1. @Parameters
	 * 2. @DataProvider
	 * 
	 */
	
	@DataProvider(name = "testData")
	public Object[][] getData() {
		return new Object [][] {
			{"chrome", "https://example.com", 1, 126.0},
			{"firefox", "https://example.com", 2, 125.3},
			{"edge", "https://example.com", 3, 43.0},
			{"safari", "https://example.com", 4, 32.0}
		};
	}
	
	@Test(dataProvider = "testData")
	public void browserTest1(String browser, String url, int number, double version) {
		System.out.println("Browser Name: "+browser);
		System.out.println("URL Detail: "+url);
	}
	
	@Parameters({ "browserName", "url" })
	//@Test
	public void browserTest(String a, String b) {
		System.out.println("Browser Name: "+a);
		System.out.println("URL Detail: "+b);
	}

}