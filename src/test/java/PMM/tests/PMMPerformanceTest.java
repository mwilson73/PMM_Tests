package PMM.tests;

import PMM.baseClass.TestBase;
import PMM.loginPage.LoginPage;
import PMM.sitePages.pmm.pages.PMMHomePage;
import PMM.sitePages.pmm.pages.ProjectsPage;
import PMM.sitePages.pmm.pages.SurveysPage;
import PMM.sitePages.re.pages.REHomePage;
import PMM.sitePages.re.pages.USBankHomePage;
import PMM.utilities.PasswordEncryptor;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class PMMPerformanceTest extends TestBase {
    LoginPage loginPage;
    REHomePage reHomePage;
    USBankHomePage usBankHomePage;
    PasswordEncryptor encryptor;
    PMMHomePage pmmHomePage;
    ProjectsPage projectsPage;
    SurveysPage surveysPage;

    @BeforeClass
    public void beforeClass() throws IOException {
        initialization();
        loginPage = new LoginPage();
        encryptor = new PasswordEncryptor();
        reHomePage = new REHomePage();
        usBankHomePage = new USBankHomePage();
        pmmHomePage = new PMMHomePage();
        projectsPage = new ProjectsPage();
        surveysPage = new SurveysPage();

    }
    @Test
    public void login() throws Throwable {
        // Log into  Web site
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }
    @Test(dependsOnMethods = "login")
    public void verifyRESitePage() throws Throwable {
        //Click site link and verify homepage text
        reHomePage.clickUSBankLink();
        usBankHomePage.assertSiteHomePage("U.S. Bank. All rights reserved.", "https://usbank-prod.relrelease-element.com/");
    }
    @Test(dependsOnMethods = "verifyRESitePage")
    public void navigateToPMMSite() throws Exception {
        usBankHomePage.clickPMMLink();
        pmmHomePage.assertSitePMMHomePage("https://profilemanager.relrelease-element.com/app/main/home-cu");
    }
    @Test(dependsOnMethods = "navigateToPMMSite")
    public void verifyProjectsTab() throws Exception {
        pmmHomePage.navigateToProjects();
        System.out.println("This is the time to load the Active Projects:");
        projectsPage.activeProjectsLoading();
        System.out.println("This is the time to load the Completed Projects:");
        projectsPage.completedProjects();
    }

    @Test(dependsOnMethods = "verifyProjectsTab")
    public void verifySurveysTab() throws Exception {
        pmmHomePage.navigateToSurveys();
        System.out.println("This is the time to load Surveys:");
        surveysPage.surveysLoading();

    }

}
