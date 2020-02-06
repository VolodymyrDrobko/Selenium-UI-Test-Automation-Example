package core;

import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Optional;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext iTestContext) {
        String testName = iTestContext.getCurrentXmlTest().getName();
        String browserName = Optional.ofNullable(Configuration.getBrowser())
                .orElse(iTestContext.getCurrentXmlTest().getParameter("browserName"));
        ReportManager.setUpReport(testName, browserName);
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        String testCaseName = iTestResult.getMethod().getMethodName();
        ReportManager.createReport(testCaseName);
        System.out.println("Test case is started - " + testCaseName);
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        ReportManager.log(Status.PASS, iTestResult.getMethod().getMethodName());
        System.out.println(iTestResult.getMethod().getMethodName() + " - PASSED");
        ReportManager.flushReport();
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        ReportManager.log(Status.FAIL, iTestResult.getMethod().getMethodName());
        System.out.println(iTestResult.getMethod().getMethodName() + " >>>>> FAILED");
        ReportManager.flushReport();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        ReportManager.log(Status.SKIP, iTestResult.getMethod().getMethodName());
        System.out.println(iTestResult.getMethod().getMethodName() + " >>>>> SKIPPED");
        ReportManager.flushReport();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        ReportManager.flushReport();
    }
}
