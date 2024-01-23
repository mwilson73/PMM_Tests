package PMM.listeners;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.*;
import org.testng.annotations.AfterClass;


import java.io.IOException;

@SuppressWarnings("rawtypes")
public class RetryListener implements ITestListener, ISuiteListener {
    public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
    private static       int count  = 0;
    private final static int maxTry = 1;


    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("I am in onTestStart method " +  getTestMethodName(iTestResult) + " start");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("I am in onTestSuccess method " +  getTestMethodName(iTestResult) + " succeed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("I am in onTestFailure method " +  getTestMethodName(iTestResult) + " failed");
        if (count < maxTry) {
            count++;
            TestNG tng = new TestNG();
            tng.setDefaultTestName("RETRY TEST");
            Class[] classes1 = { iTestResult.getTestClass().getRealClass() };
            tng.setTestClasses(classes1);
            tng.addListener(new RetryListener());
            tng.run();
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("I am in onTestSkipped method "+  getTestMethodName(iTestResult) + " skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("I am in onStart method " + iTestContext.getName());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("I am in onFinish method " + iTestContext.getName());
        String systemType = System.getProperty("os.name").toLowerCase();

        if (systemType.contains("win")) {
            try {
                // Selenium drivers don't always close properly, kill them
                System.out.println("Close one or more driver exe files");
                Runtime.getRuntime().exec("taskkill /f /im chromedriver.exe");
                Runtime.getRuntime().exec("taskkill /f /im chrome.exe");
            } catch (IOException e) {
                System.out.println("Failed to close one or more driver exe files");
            }
        }
    }

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }
    public RemoteWebDriver getWebDriver() {
        return driver.get();
    }


}
