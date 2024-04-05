package generic_Utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerImplementation  implements IRetryAnalyzer  {
    
	int no = 0;
	int count = 3;
	
	@Override
	public boolean retry(ITestResult result) {
		while(no < count) {
			no++;
			return true;
		}
		return false;
	}
 

	
}
