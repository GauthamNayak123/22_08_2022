package GenericUtils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerS implements ITestListener {
	
	ExtentReports reports;//attach the reporter
	ExtentTest test; //to make entries of test case and logs
	
	
	public void onTestStart(ITestResult result) {
		test=reports.createTest(result.getMethod().getMethodName());
	}
	
	
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS,result.getMethod().getMethodName()+" is Passed");
	}
	
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getName()+" is Failed");
		test.log(Status.FAIL, result.getThrowable());
		
		try {
			String path = BaseClass.getscreenshot(result.getName());
			test.addScreenCaptureFromPath(path);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName()+"Skipped");

	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}
	
	public void onStart(ITestContext context) {
		JavaUtil jutil=new JavaUtil();
		String date=jutil.getDate();
		ExtentHtmlReporter reporter;
		reporter=new ExtentHtmlReporter(AutoConstants.ExtentReportPath+date+".html");
		reporter.config().setDocumentTitle("Boodmo");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setReportName("Regression");

		reports= new ExtentReports();
		reports.attachReporter(reporter);

		reports.setSystemInfo("AppURL", "https://boodmo.com/");
		reports.setSystemInfo("Env", "Test QA");
		reports.setSystemInfo("Build", "2.1");
		reports.setSystemInfo("Reporter name", "Gautham");
	}
	
	public void onFinish(ITestContext context) {
		reports.flush();
	}
}
