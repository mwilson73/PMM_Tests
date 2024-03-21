package PMM.tests;
import PMM.baseClass.TestBase;
import PMM.sitePages.pmm.pages.*;
import PMM.utilities.FileUtil;
import PMM.utilities.PasswordEncryptor;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class PMMImageUploadPerformance extends TestBase {
    PMMLoginPage pmmLoginPage;
    PasswordEncryptor encryptor;
    PMMHomePage pmmHomePage;
    ProjectsPage projectsPage;
    SurveysPage surveysPage;
    UploadImagesPage uploadImagesPage;
    FileUtil util;

    @BeforeClass
    public void beforeClass() throws IOException {
        initialization2();
        pmmLoginPage = new PMMLoginPage();
        encryptor = new PasswordEncryptor();
        pmmHomePage = new PMMHomePage();
        projectsPage = new ProjectsPage();
        surveysPage = new SurveysPage();
        uploadImagesPage = new UploadImagesPage();
        util = new FileUtil();

    }
    @Test
    public void login() throws InterruptedException, AWTException {
        // Log into  Web site
        pmmLoginPage.login(prop.getProperty("username1"), prop.getProperty("password1"));
        // Search for an existing project
        projectsPage.searchForProjects("Performance Test - 01");
        projectsPage.clickProjectStart();
        projectsPage.addCurrentDate();
        Thread.sleep(2000);
        projectsPage.selectDamagedOrMissing();
        projectsPage.validateImages();
        uploadImagesPage.uploadImagesFirstImage();
        uploadImagesPage.uploadImagesSecondImage();
        uploadImagesPage.uploadImagesThirdImage();
        uploadImagesPage.uploadImagesForthImage();
        uploadImagesPage.uploadImagesFithImage();




    }


}
