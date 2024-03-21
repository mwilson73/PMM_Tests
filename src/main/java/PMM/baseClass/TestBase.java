package PMM.baseClass;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class TestBase {
    public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
    public final int WAIT_TIME_10_SEC = 10;
    //public final int WAIT_TIME_60_SEC = 60;
    public static Properties prop;
    //Screenshots screenShot;

    protected static final String CURRENT_DIR = System.getProperty("user.dir");

/*    @AfterClass
    public void afterClass() {
        getWebDriver().close();
        getWebDriver().quit();
    }*/



/*    @AfterMethod
    public void afterMethod() throws Exception {
        screenShot.captureFailedScreenshot("Test");
    }*/


    /*
     * setWebDriver- Method to set the driver instance based on the user input
     *
     * @param drivervalue - to get value from prop file
     */
    protected static void setWebDriver(RemoteWebDriver drivervalue) {
        driver.set(drivervalue);
    }

    protected void implicitWait() {
        getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(WAIT_TIME_10_SEC));
    }

    public TestBase() {

        try {
            prop = new Properties();
            FileInputStream fip = new FileInputStream(System.getProperty("user.dir") + File.separator + "ConfigFile"
                    + File.separator + "config.properties");

            prop.load(fip);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unused")
    public void initialization() throws IOException {
        FileUtils.deleteDirectory(new File("C:\\Selenium Projects\\RE_2_DEMO_SmokeTests\\test-output"));
//		Use this to point to the properties file for the browser value
//		String browserName = prop.getProperty("browser");
        String browserName = System.getProperty("browser");
        if (browserName == null)
            browserName = prop.getProperty("browser");
        String driverPath = System.getProperty("user.dir") + prop.getProperty("drivers_location");
        switch (browserName) {
            case "chrome":
                // Added to download the files into project directory
                Map<String, Object> chromePrefs = new HashMap<>();
                chromePrefs.put("download.default_directory", System.getProperty("user.dir") + "\\downloads\\");
                ChromeOptions options = new ChromeOptions();
                //WebDriverManager.chromedriver().clearDriverCache();
                options.addArguments("--remote-allow-origins=*");
                options.setExperimentalOption("prefs", chromePrefs);
                //WebDriverManager.chromedriver().setup();
                setWebDriver(new ChromeDriver(options));
                getWebDriver();
                break;

            case "edge":
                EdgeOptions options1 = new EdgeOptions();
                //options1.addArguments("--remote-allow-origins=*");
                Map<String, Object> prefs = new HashMap<>();
                prefs.put("download.default_directory", CURRENT_DIR + "\\downloads\\");
                prefs.put("download.prompt_for_download", false);
                Map<String, Object> edgeOptions = new HashMap<>();
                edgeOptions.put("prefs", prefs);
                edgeOptions.put("useAutomationExtension", false);
                options1.setCapability("ms:edgeChrominum", true);
                options1.setCapability("ms:edgeOptions", edgeOptions);

                //WebDriverManager.edgedriver().setup();
                setWebDriver(new EdgeDriver(options1));
                getWebDriver();
                break;
            default:
                System.out.println("Please enter valid browser name in properties file");
                break;
        }

        implicitWait();
        maximizeWindow();

        //Use this to get the URL value from the properties file
        //getWebDriver().get(prop.getProperty("url"));
        String url = System.getProperty("url");
        if (url == null)
            url = prop.getProperty("url");
        getWebDriver().get(url);
        implicitWait();

    }
    public void initialization2() throws IOException {
        FileUtils.deleteDirectory(new File("C:\\Selenium Projects\\RE_2_DEMO_SmokeTests\\test-output"));
//		Use this to point to the properties file for the browser value
//		String browserName = prop.getProperty("browser");
        String browserName = System.getProperty("browser");
        if (browserName == null)
            browserName = prop.getProperty("browser");
        String driverPath = System.getProperty("user.dir") + prop.getProperty("drivers_location");
        switch (browserName) {
            case "chrome":
                // Added to download the files into project directory
                Map<String, Object> chromePrefs = new HashMap<>();
                chromePrefs.put("download.default_directory", System.getProperty("user.dir") + "\\downloads\\");
                ChromeOptions options = new ChromeOptions();
                //WebDriverManager.chromedriver().clearDriverCache();
                options.addArguments("--remote-allow-origins=*");
                options.setExperimentalOption("prefs", chromePrefs);
                //WebDriverManager.chromedriver().setup();
                setWebDriver(new ChromeDriver(options));
                getWebDriver();
                break;

            case "edge":
                EdgeOptions options1 = new EdgeOptions();
                //options1.addArguments("--remote-allow-origins=*");
                Map<String, Object> prefs = new HashMap<>();
                prefs.put("download.default_directory", CURRENT_DIR + "\\downloads\\");
                prefs.put("download.prompt_for_download", false);
                Map<String, Object> edgeOptions = new HashMap<>();
                edgeOptions.put("prefs", prefs);
                edgeOptions.put("useAutomationExtension", false);
                options1.setCapability("ms:edgeChrominum", true);
                options1.setCapability("ms:edgeOptions", edgeOptions);

                //WebDriverManager.edgedriver().setup();
                setWebDriver(new EdgeDriver(options1));
                getWebDriver();
                break;
            default:
                System.out.println("Please enter valid browser name in properties file");
                break;
        }

        implicitWait();
        maximizeWindow();

        //Use this to get the URL value from the properties file
        //getWebDriver().get(prop.getProperty("url"));
        String url = System.getProperty("url2");
        if (url == null)
            url = prop.getProperty("url2");
        getWebDriver().get(url);
        implicitWait();

    }
    /**
     * maximizeWindow - Maximizes the browser window
     */
    private void maximizeWindow() {
        getWebDriver().manage().window().maximize();
        getWebDriver().manage().deleteAllCookies();

    }
    /**
     * getWebDriver-Method to get driver instance
     **/
    public RemoteWebDriver getWebDriver() {
        return driver.get();

    }
}
