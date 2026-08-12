package listeners;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utils.ExtentManager;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {

	private ExtentReports extent = ExtentManager.getInstance();
	private ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	@Override
	public void onTestStart(ITestResult result) {
		
		
		String testName = result.getMethod().getMethodName();
		Object[] parameters = result.getParameters();
		if(parameters.length > 0) {
			testName = testName + " - ";
			
			for (Object parameter : parameters) {
				testName = testName + parameter + " | ";
			}
		}
		
		
		String description = result.getMethod().getDescription();
		
		test.set(extent.createTest(testName, description));
		test.get().assignAuthor("Bismay Pati");
		test.get().info("Test started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.get().pass("Test passed successfully");
		test.remove();
	}

	@Override
	public void onTestFailure(ITestResult result) {

		test.get().fail("Test failed");

		WebDriver driver = ((BaseTest) result.getInstance()).getDriver();

		// Save screenshot to screenshots folder
		ScreenshotUtil.takeScreenshot(driver, result.getName());

		// Capture screenshot as Base64
		String base64Screenshot = ScreenshotUtil.getScreenshotAsBase64(driver);

		// Attach screenshot directly to Extent Report
		test.get().addScreenCaptureFromBase64String(base64Screenshot, "Failure Screenshot");
		test.remove();
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.get().skip("Test skipped");
		test.remove();
	}

	@Override
	public void onFinish(org.testng.ITestContext context) {
		extent.flush();
	}
}
