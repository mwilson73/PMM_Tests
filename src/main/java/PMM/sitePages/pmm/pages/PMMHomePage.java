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



    public PMMHomePage() {
        PageFactory.initElements(getWebDriver(), this);
        functions = new CommonFunctions();


    }

    public void assertSitePMMHomePage(String siteURL) throws Exception {
        functions.waitUntilElementIsVisible(pageMessageTextArea);
        functions.verifySiteURL(siteURL);

    }


}
