package pl.prestashop.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import pl.prestashop.driver.DriverManager;

public class TestMethodListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("--------------------------------");
        System.out.println("Start test: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test result: SUCCESS!");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ScreenshotFactory screenshotFactory = new ScreenshotFactory();
        if (DriverManager.getDriver() != null) {
            screenshotFactory.getScreenshot(DriverManager.getDriver(), result.getName());
        }
        if (DriverManager.getDriver2() != null) {
            screenshotFactory.getScreenshot(DriverManager.getDriver2(), result.getName());
        }
        System.out.println("Test result: FAILED!");
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
