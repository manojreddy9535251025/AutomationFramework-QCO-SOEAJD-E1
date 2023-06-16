package genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class will provide implementation for the IRetryAnalyser.
 * @author Manoj
 */

public class RetryAnalyserImplementation implements IRetryAnalyzer {
	
	int count = 0;
	int retryCount = 4;

	public boolean retry(ITestResult result) {
		
		while (count<retryCount) 
		{
			count++;
			return true;	
		}
		
		return false;
	}

}
