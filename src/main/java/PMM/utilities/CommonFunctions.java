package PMM.utilities;


import PMM.baseClass.TestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import static org.testng.AssertJUnit.fail;

// User Defined Functions
public class CommonFunctions extends TestBase {
    /*public static ThreadLocal<RemoteWebDriver>
            driver = new ThreadLocal<RemoteWebDriver>();*/
    public final int WAIT_TIME_60_SEC = 60;

    private WebDriverWait explicitWait() {
        return new WebDriverWait(getWebDriver(), Duration.ofSeconds(WAIT_TIME_60_SEC));
    }

    /**
     * Click -Method to click on element once it is clickable
     */
    public void click(WebElement element) {
        explicitWait().until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    /**
     * setTextBoxValue - Types the given text to input box
     */

    public void setTextBoxValue(WebElement element, String inputText) {
        explicitWait().until(ExpectedConditions.visibilityOf(element)).sendKeys(inputText);
        //element.sendKeys(inputText);
    }

    /**
     * getText - Method to get element tex
     */
    public String getText(WebElement element) {
        return element.getText();
    }

    /**
     * getSelectedOptionFromDropdown -Method to get selected option from drop down
     */
    public String getSelectedOptionFromDropdown(WebElement element) {
        Select dropdown = new Select(element);
        String option = dropdown.getFirstSelectedOption().getText();
        return option;
    }

    /**
     * acceptAlerts - Used for accepting the alerts
     */
    public void acceptAlerts() throws InterruptedException {
        Alert confirmationAlert = getWebDriver().switchTo().alert();
        confirmationAlert.accept();
        Thread.sleep(1000);
    }

    /**
     * selectValueFromDropdown - To select value from the drop down
     */
    public void selectValueFromDropdown(WebElement element, String value) throws InterruptedException {
        try {
            Select dropdown = new Select(element);
            dropdown.selectByValue(value);
        } catch (NoSuchElementException e) {
            fail("Option " + value + " is not available in drop down");
        }
    }

    /**
     * scrollToElement- Scroll into view specified element
     */
    public void scrollToElement(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) getWebDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void scrollToBottomOfPage() {
        JavascriptExecutor jse = (JavascriptExecutor) getWebDriver();
        jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }
    public void scrollToTopOfPage() {
        JavascriptExecutor jse = (JavascriptExecutor) getWebDriver();
        jse.executeScript("window.scrollTo(0, 0)");
    }
    /**
     * clickWithoutWaitTime -Method to click on element
     */
    public void clickWithoutWaitTime(WebElement element) {
        element.click();
    }

    /**
     * waitUntilElementIsVissible- Method to synchronize selenium with application
     */
    public void waitUntilElementIsVisible(WebElement element) {
        explicitWait().until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * waitUntilElementIsClickable-Method to synchronize selenium with application
     */
    public void waitUntilElementIsClickable(WebElement element) {
        explicitWait().until(ExpectedConditions.elementToBeClickable(element));

    }
    /**
     * waitUntilElementIsClickable-Method to synchronize selenium with application
     */
    public void verifySiteURL(String url) {
        String URL = getWebDriver().getCurrentUrl();
        Assert.assertEquals(URL, url);

    }

    /**
     * waitUntilTextIsPresentInElement-Method to wait until text is present in an
     * element
     *
     */
    public void waitUntilTextIsPresentInElement(WebElement element, String text) {
        explicitWait().until(ExpectedConditions.textToBePresentInElement(element, text));

    }
    public void validateElementIntegerValue(WebElement element, Integer value) {
        Assert.assertEquals(getText(element), value, "Expected text " + value + " is not displayed");
    }

    /**
     * validateElementIsVissible-Validate if element is visible
     *
     */
    public void validateElementIsVissible(WebElement element) {
        Assert.assertTrue(element.isDisplayed(), "desired element" + "" + element + "" + " is not visible");
    }

    /**
     * waitUntilElementIsInVisible- Method to wait until loading icon is invisible
     *
     */
    public void waitUntilElementIsInvisible(WebElement element) {
        explicitWait().until(ExpectedConditions.invisibilityOf(element));
    }

    /**
     * validateElementText-Validate if element text is matching with Expected text
     */
    public void validateElementText(WebElement element, String expectedText) {
        Assert.assertEquals(getText(element), expectedText, "Expected text " + expectedText + " is not displayed");
    }

    /**
     * clearData - Clear text from the textbox
     */
    public void clearData(WebElement element) {
        element.clear();

    }

    /**
     * getAllOptionFromDropdown -Method to get all option from drop down
     *
     */
    public List<WebElement> getAllOptionFromDropdown(WebElement element) {
        Select dropdown = new Select(element);
        List<WebElement> allOptions = dropdown.getOptions();
        return allOptions;
    }

    /**
     * doubleClick -Method to double click on an element
     */
    public void doubleClick(WebElement element) {
        Actions action = new Actions(getWebDriver());
        action.doubleClick(element).perform();
    }

    /**
     * validateSelectedDropdownOption -Method to verify the selected option from a
     * drop down
     */
    public void validateSelectedDropdownOption(WebElement element, String option) {
        String selectedOption = getSelectedOptionFromDropdown(element);
        Assert.assertEquals(selectedOption, option, "Expected option " + option + " is not selected in drop down");
    }

    /**
     * checkOrUncheckCheckBox -Method to check or un-check check box based on the
     * flag passed
     */
    public void checkOrUncheckCheckBox(Boolean flag, WebElement element) {
        if (!(element.isSelected() == flag)) {
            element.click();
        }
    }

    /**
     * clickHiddenElement -Method to click on an element if it is hidden by other
     * elements
     */
    public void clickHiddenElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        js.executeScript("arguments[0].click();", element);
    }

    /**
     * sendKeysUseDown -Method to use arrow movement Down elements
     */
    public void sendKeysUseDown(WebElement element) {
        element.sendKeys(Keys.chord(Keys.DOWN));
    }

    /**
     * sendKeysUseEnter -Method to use Enter key elements
     */
    public void sendKeysUseEnter(WebElement element) {
        element.sendKeys(Keys.chord(Keys.ENTER));
    }
    public void hoverOverElement(WebElement element) {
        Actions actions = new Actions(getWebDriver());
        actions.moveToElement(element);
        actions.perform();
    }

    public void PageLoadTime() {
        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        double loadTime2 = (Double) js.executeScript(
                "return (window.performance.timing.loadEventEnd - window.performance.timing.navigationStart) / 1000");
        System.out.println("Navigation Start " + loadTime2 + " seconds");
        double loadTime1 = (Double) js.executeScript(
                "return (window.performance.timing.loadEventEnd - window.performance.timing.responseEnd) / 1000");
        System.out.println("Response End " + loadTime1 + " seconds");
    }
    public void PageLoadTime2(WebElement element) {
        long start = System.currentTimeMillis();
        waitUntilElementIsVisible(element);
        long finish = System.currentTimeMillis();
        long totalTime = finish - start;
        System.out.println("Total Time for page load - "+totalTime);




    }
}
