package wp.week07.session2;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	int counter = 0, maxLimit = 2;

	public boolean retry(ITestResult result) {

		while (counter < maxLimit) {
			counter++;
			return true;
		}

		return false;
	}

}