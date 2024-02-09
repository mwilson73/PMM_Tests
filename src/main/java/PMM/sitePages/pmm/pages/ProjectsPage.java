package PMM.sitePages.pmm.pages;

import PMM.baseClass.TestBase;
import PMM.utilities.CommonFunctions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectsPage extends TestBase {
    CommonFunctions functions;
    //final JavascriptExecutor js = (JavascriptExecutor) getWebDriver();




    @FindBy(xpath = "//*[contains(text(),'Active Projects')]/span[@class='m-badge m-badge--brand' and text()!='0']")
    WebElement activeProjectsTotal;
    @FindBy(xpath = "//*[contains(text(),'Completed Projects')]/span[@class='m-badge m-badge--brand' and text()!='0']")
    WebElement completedProjectsTotal;
    @FindBy(xpath = "//*[contains(text(),'Completed Projects')]")
    WebElement completedProjectsLink;



    public ProjectsPage() {
        PageFactory.initElements(getWebDriver(), this);
        functions = new CommonFunctions();


    }

    public void activeProjectsLoading() {
        functions.PageLoadTime2(activeProjectsTotal);
    }
    public void completedProjects() {
        functions.click(completedProjectsLink);
        functions.PageLoadTime2(completedProjectsTotal);




    }
}
