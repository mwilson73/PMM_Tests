package PMM.sitePages.pmm.pages;

import PMM.baseClass.TestBase;
import PMM.utilities.CommonFunctions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PMMHomePage extends TestBase {
    CommonFunctions functions;
    //final JavascriptExecutor js = (JavascriptExecutor) getWebDriver();



    @FindBy(xpath = "//span[normalize-space()='CU Dashboard']")
    WebElement pageMessageTextArea;
    @FindBy(xpath = "//span[contains(text(),'Projects')]")
    WebElement projectsLink;
    @FindBy(xpath = "//span[contains(text(),'Surveys')]")
    WebElement surveysLink;




    public PMMHomePage() {
        PageFactory.initElements(getWebDriver(), this);
        functions = new CommonFunctions();


    }

    public void assertSitePMMHomePage(String siteURL) throws Exception {
        functions.PageLoadTime2(projectsLink);
        functions.waitUntilElementIsVisible(pageMessageTextArea);
        functions.verifySiteURL(siteURL);

    }
    public void navigateToProjects() {
        functions.click(projectsLink);

    }

    public void navigateToSurveys() {
        functions.click(surveysLink);

    }


}
