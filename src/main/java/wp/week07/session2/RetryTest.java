package wp.week07.session2;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryTest {
	
	@Test(retryAnalyzer = Retry.class)
	public void test1() {
		Assert.assertTrue(false);
	}

	@Test(retryAnalyzer = Retry.class)
	public void test2() {
		Assert.assertTrue(true);
	}
	
	@Test(retryAnalyzer = Retry.class)
	public void test3() {
		Assert.assertTrue(true);
	}
	
}