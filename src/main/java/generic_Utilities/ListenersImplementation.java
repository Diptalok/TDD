package generic_Utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementation implements ITestListener {

	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getMethod().getMethodName());
		System.out.println("Test execution is started");
		
		test = report.createTest(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test execution is passed");
		test.log(Status.PASS, "Test execution is passed");
		
		JavaUtility j = new JavaUtility();
		String screenshotName = j.getDate();
		SeleniumUtilities s = new SeleniumUtilities();
		try {
			String path = s.screenshot(BaseClass.sDriver, "validation for pass "+screenshotName);
			test.addScreenCaptureFromPath(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test execution is failed");
		test.log(Status.FAIL, "Test execution is failed");
		
		JavaUtility j = new JavaUtility();
		String screenshotName = j.getDate();
		SeleniumUtilities s = new SeleniumUtilities();
		try {
			String path = s.screenshot(BaseClass.sDriver, "validation for failure"+screenshotName);
			test.addScreenCaptureFromPath(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test execution is skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test suite is started");
		System.out.println(context.getAllTestMethods());
		
		ExtentSparkReporter rep = new ExtentSparkReporter(".\\Extent Reports\\Reports - "+new JavaUtility().getDate()+".html");
        rep.config().setDocumentTitle("TDD Execution Report");
        rep.config().setReportName("vtiger App Opportunity Module Execution report");
        rep.config().setTheme(Theme.DARK);
        
        report = new ExtentReports();
        report.attachReporter(rep);
        report.setSystemInfo("Base Browser", "Chrome");
        report.setSystemInfo("Base Platform", "windows");
        report.setSystemInfo("Base url", "https://localhost:8888");
        report.setSystemInfo("Reporter Name", "Diptalok");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test suite is finished");
		report.flush();
	}

}
