package pl.prestashop.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerManager implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("--------------------------------");
        System.out.println("Start test: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("SUCCESS!");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("FAILED!");
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
