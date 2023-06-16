package genericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class Provides Implementation to ITestListener.
 * @author Manoj
 *
 */

public class ListenersImplementation implements ITestListener{
	
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

		String methodName = result.getMethod().getMethodName();
		System.out.println("----Test Execution Started----"); //Example - Method Overriding // and abstraction.
		
		test = report.createTest(methodName);
		test.log(Status.INFO, methodName+" -> Execution Started"); 
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"----Test Execution Successful----");
		
		test.log(Status.PASS, methodName+" -> PASS");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"----Test Execution Failed----");
		System.out.println(result.getThrowable());
		
		test.log(Status.FAIL, methodName+" -> FAIL");
		test.log(Status.WARNING, result.getThrowable());
		
		//Takescreen Shot
		String screenShotName = methodName+"-"+new JavaUtility().getSystemInFormat();
		WebDriverUtilty wLib = new WebDriverUtilty();
		try {
			String path = wLib.takeScreenShot(BaseClass.sDriver, screenShotName);
			test.addScreenCaptureFromPath(path);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("ScreenShot as been taken");
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"----Test Execution Skipped----");
		System.out.println(result.getThrowable());
		
		test.log(Status.SKIP, methodName+" -> SKIP");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("---- Execution Started----");
		
		//Configure the Extent reports
		ExtentSparkReporter html = new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSystemInFormat()+".html");
		html.config().setDocumentTitle("Vtiger Execution Report");
		html.config().setReportName("Execution report BuildV2.3.1");
		html.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(html);
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("Base URL", "http://TestEnv.com");
		report.setSystemInfo("Base Platform", "Windows - Family");
		report.setSystemInfo("Reporter Name", "Manoj");
		
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("----Execution Finished----");
		
		report.flush(); // is responsible for report generation.
	}

}
