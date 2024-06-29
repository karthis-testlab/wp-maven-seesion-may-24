package wp.week08.session1;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
	
	int count = 0, limit = 2;

	public boolean retry(ITestResult result) {
		if(count < limit) {
			count++;
			return true;
		}
		return false;
	}

}