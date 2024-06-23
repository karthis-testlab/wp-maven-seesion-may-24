package wp.week07.session1;

import org.testng.annotations.Test;

public class TestNGAttributes {
	
	
	@Test(priority = 0, enabled = false)
	public void ctest() {
		System.out.println("Runs Test C");
	}

	@Test(priority = 1, enabled = true, dependsOnMethods = {"btest"})
	public void atest() {
		System.out.println("Runs Test A");

	}

	@Test(priority = 2, enabled = true)
	public void btest() {
		System.out.println("Runs Test B");
	}
	
	@Test(invocationCount = 4)
	public void dtest() {
		System.out.println("Runs Test D");
	}
	
	@Test(timeOut = 200)
	public void etest() throws InterruptedException {
		Thread.sleep(500);
		System.out.println("Runs Test E");
	}

}