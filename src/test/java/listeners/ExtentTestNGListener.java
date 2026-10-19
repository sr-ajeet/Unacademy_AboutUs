package listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.BaseTest;
import utilities.ExtentManager;
import utilities.ScreenshotUtility;

public class ExtentTestNGListener implements ITestListener {

    private static final ExtentReports extent =
            ExtentManager.getinstance();

    private static ThreadLocal<ExtentTest> test =
            new ThreadLocal<>();

    public static ExtentTest getCurrentTest() {
        return test.get();
    }

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest extentTest =
                extent.createTest(
                        result.getMethod().getMethodName(),
                        result.getMethod().getDescription());

        extentTest.assignAuthor("Ajeet Singh");
        extentTest.assignCategory("About Us Module");

        test.set(extentTest);

        test.get().info("Execution Started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.get().pass("Test Passed Successfully");

        attachScreenshot(result, "PASS");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.get().fail("Test Failed");

        if (result.getThrowable() != null) {
            test.get().fail(result.getThrowable());
        }

        attachScreenshot(result, "FAIL");
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        test.get().skip("Test Skipped");

        if (result.getThrowable() != null) {
            test.get().skip(result.getThrowable());
        }
    }

    @Override
    public void onStart(ITestContext context) {

        System.out.println(
                "Starting Test Suite : "
                        + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();

        System.out.println(
                "Extent Report Generated Successfully");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(
            ITestResult result) {

        test.get().warning(
                "Test Failed But Within Success Percentage");
    }

    private void attachScreenshot(
            ITestResult result,
            String status) {

        try {

            WebDriver driver = getDriver(result);

            if (driver == null) {
                return;
            }

            String path =
                    ScreenshotUtility.capture(
                            driver,
                            result.getMethod()
                                    .getMethodName()
                                    + "_"
                                    + status);

            test.get()
                    .addScreenCaptureFromPath(
                            path,
                            status + " Screenshot");

        } catch (IOException e) {

            test.get()
                    .warning(
                            "Unable To Attach Screenshot : "
                                    + e.getMessage());
        }
    }

    private WebDriver getDriver(
            ITestResult result) {

        Object current =
                result.getInstance();

        if (current instanceof BaseTest) {

            return ((BaseTest) current)
                    .getDriver();
        }

        return null;
    }

    /**
     * Log execution steps in Extent Report
     */
    public static void logStep(String message) {

        ExtentTest currentTest =
                test.get();

        if (currentTest != null) {

            currentTest.info(
                    "STEP : " + message);
        }
    }

    /**
     * Log Pass Step
     */
    public static void logPassStep(
            String message) {

        ExtentTest currentTest =
                test.get();

        if (currentTest != null) {

            currentTest.pass(
                    "PASS : " + message);
        }
    }

    /**
     * Log Fail Step
     */
    public static void logFailStep(
            String message) {

        ExtentTest currentTest =
                test.get();

        if (currentTest != null) {

            currentTest.fail(
                    "FAIL : " + message);
        }
    }

    /**
     * Log Warning Step
     */
    public static void logWarningStep(
            String message) {

        ExtentTest currentTest =
                test.get();

        if (currentTest != null) {

            currentTest.warning(
                    "WARNING : " + message);
        }
    }

    /**
     * Generic Log Method
     */
    public static void log(
            Status status,
            String message) {

        ExtentTest currentTest =
                test.get();

        if (currentTest != null) {

            currentTest.log(
                    status,
                    message);
        }
    }
    
    public static void logStep1 (String message) {

        System.out.println("STEP => " + message);

        ExtentTest currentTest =
                test.get();

        if (currentTest != null) {
            currentTest.info(
                    "STEP : " + message);
        }
    }
}