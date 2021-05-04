package pl.prestashop.Listeners;

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
        if (DriverManager.getWebDriver() != null) {
            screenshotFactory.takeScreenshot(DriverManager.getWebDriver(), result.getName());
        }
        if (DriverManager.getWebDriver2() != null) {
            screenshotFactory.takeScreenshot(DriverManager.getWebDriver2(), result.getName());
        }
        System.out.println("Test result: FAILED!");
    }

}
