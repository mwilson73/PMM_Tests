package PMM.sitePages.pmm.pages;

import PMM.baseClass.TestBase;
import PMM.utilities.CommonFunctions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SurveysPage extends TestBase{
    CommonFunctions functions;
    //final JavascriptExecutor js = (JavascriptExecutor) getWebDriver();

    @FindBy(xpath = "//span[@class='total-records-count' and text()!=' Total: 0 ']")
    WebElement surveysTotal;

    public SurveysPage() {
        PageFactory.initElements(getWebDriver(), this);
        functions = new CommonFunctions();
    }

    public void surveysLoading() {
        functions.PageLoadTime2(surveysTotal);
    }

}
