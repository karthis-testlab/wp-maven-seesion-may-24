package wp.week07.session1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGHooks {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Runs once before all tests in the suite");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Runs once before all tests within the current <test> tag"); 
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Run once before the first test method in the current class");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Run before each test method");
	}
	
	@Test
	public void test1() {
		System.out.println("Inside test1");
	}
	
	@Test
	public void test2() {
		System.out.println("Inside test2");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("Runs after each test method");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("Runs once after all the test methods in the current class");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("Runs once after all tests with in the current class");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("Runs once after all tests in the test suite");
	}

}