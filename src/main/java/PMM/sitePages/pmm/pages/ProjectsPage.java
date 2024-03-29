package PMM.sitePages.pmm.pages;

import PMM.baseClass.TestBase;
import PMM.utilities.CommonFunctions;
import PMM.utilities.FileUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ProjectsPage extends TestBase {
    CommonFunctions functions;


    @FindBy(xpath = "//*[contains(text(),'Active Projects')]/span[@class='m-badge m-badge--brand' and text()!='0']")
    WebElement activeProjectsTotal;
    @FindBy(xpath = "//*[contains(text(),'Completed Projects')]/span[@class='m-badge m-badge--brand' and text()!='0']")
    WebElement completedProjectsTotal;
    @FindBy(xpath = "//*[contains(text(),'Completed Projects')]")
    WebElement completedProjectsLink;
    @FindBy(xpath = "//input[@placeholder='Search by Project Name, Branch Name or Branch Number']")
    WebElement projectSearchField;
    @FindBy(xpath = "//tr[@class='ng-tns-c9-3']//td[@class='text-center'][normalize-space()='No data']")
    WebElement searchResults;
    @FindBy(xpath = "//input[@id='icon']")
    WebElement dateField;
    @FindBy(xpath = "//button[normalize-space()='START']")
    WebElement startButton;
    @FindBy(xpath = "//button[@data-dismiss='modal'][normalize-space()='Continue']")
    WebElement continueButton;
    @FindBy(xpath = "//div[@class='ui-radiobutton-box ui-widget ui-state-default ui-state-active']")
    WebElement dmgNoButton;
    @FindBy(xpath = "//input[@class='checkbox ng-untouched ng-pristine ng-valid']")
    WebElement validateImagesCheck;
    @FindBy(xpath = "//div[@class='modal fade projectTasksModal in show']//span[@class='name'][normalize-space()='Select date your kit arrived']")
    WebElement projectModalTitle;
    @FindBy(xpath = "//a[contains(@href,'#validateImage_0')]")
    WebElement validateImage1;
    @FindBy(xpath = "//a[contains(@href,'#validateImage_1')]")
    WebElement validateImage2;
    @FindBy(xpath = "//a[contains(@href,'#validateImage_2')]")
    WebElement validateImage3;
    @FindBy(xpath = "//a[contains(@href,'#validateImage_3')]")
    WebElement validateImage4;
    @FindBy(xpath = "//a[contains(@href,'#validateImage_4')]")
    WebElement validateImage5;



    public ProjectsPage() {
        PageFactory.initElements(getWebDriver(), this);
        functions = new CommonFunctions();
    }

    public String currentDate() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        Date currentDate = cal.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        String todaysDate = formatter.format(currentDate);
        return todaysDate;


    }

    public void activeProjectsLoading() {
        functions.PageLoadTime2(activeProjectsTotal);
    }

    public void completedProjects() {
        functions.click(completedProjectsLink);
        functions.PageLoadTime2(completedProjectsTotal);
    }

    public void searchForProjects(String projectName) {
        functions.setTextBoxValue(projectSearchField, projectName);
        functions.waitUntilElementIsInvisible(searchResults);
        functions.sendKeysUseEnter(projectSearchField);
        functions.sendKeysUseEnter(startButton);
    }

    public void clickProjectStart() throws InterruptedException {
        Thread.sleep(2000);
        functions.waitUntilElementIsVisible(startButton);
        functions.clickHiddenElement(startButton);

    }

    public void addCurrentDate() {
        getWebDriver().switchTo().activeElement();
        functions.waitUntilElementIsVisible(projectModalTitle);
        //clears the date field
        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        js.executeScript("arguments[0].value = '';", dateField);
        //Adds current date to date field
        WebElement calendarManualInput = dateField;
        calendarManualInput.sendKeys(currentDate());
        functions.clickHiddenElement(continueButton);
    }

    public void selectDamagedOrMissing() {
        functions.clickHiddenElement(dmgNoButton);
        functions.clickHiddenElement(continueButton);
    }

    public void validateImages() throws InterruptedException {
        getWebDriver().switchTo().activeElement();
        functions.waitUntilElementIsVisible(validateImage1);
        functions.clickHiddenElement(validateImagesCheck);
        functions.waitUntilElementIsVisible(validateImage2);
        functions.clickHiddenElement(validateImagesCheck);
        functions.waitUntilElementIsVisible(validateImage3);
        functions.clickHiddenElement(validateImagesCheck);
        functions.waitUntilElementIsVisible(validateImage4);
        functions.clickHiddenElement(validateImagesCheck);
        functions.waitUntilElementIsVisible(validateImage5);
        functions.clickHiddenElement(validateImagesCheck);
        functions.clickHiddenElement(continueButton);
    }
}









