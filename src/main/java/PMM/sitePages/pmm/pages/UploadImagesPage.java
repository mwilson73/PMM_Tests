package PMM.sitePages.pmm.pages;

import PMM.baseClass.TestBase;
import PMM.utilities.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class UploadImagesPage extends TestBase {
    CommonFunctions functions;

    @FindBy(xpath = "//div[@id='uploadImage_0']//button[@type='button']")
    WebElement uploadPhotosButton;
    @FindBy(xpath = "//div[@id='uploadImage_1']//button[@type='button']")
    WebElement uploadPhotosButton2;
    @FindBy(xpath = "//div[@id='uploadImage_2']//button[@type='button']")
    WebElement uploadPhotosButton3;
    @FindBy(xpath = "//div[@id='uploadImage_3']//button[@type='button']")
    WebElement uploadPhotosButton4;
    @FindBy(xpath = "//div[@id='uploadImage_4']//button[@type='button']")
    WebElement uploadPhotosButton5;
    @FindBy(xpath = "//div[@class='modal fade imageUploadPopupModal in show']//span[contains(text(),'Add Attachment')]")
    WebElement pageTitle;
    @FindBy(xpath = "//div[@class='modal fade imageUploadPopupModal in show']//span[@class='ui-button-text ui-clickable'][normalize-space()='Upload']")
    WebElement uploadButton;


    public UploadImagesPage() {
        PageFactory.initElements(getWebDriver(), this);
        functions = new CommonFunctions();
    }

    public void uploadImagesFirstImage() throws InterruptedException{
        functions.clickHiddenElement(uploadPhotosButton);
        Thread.sleep(3000);
        getWebDriver().switchTo().activeElement();
        functions.waitUntilElementIsVisible(pageTitle);
        functions.click(pageTitle);
        Thread.sleep(3000);

/*        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_ENTER);*/

        String uploadPath1 = "C:\\Selenium Projects\\PMM_Tests\\UploadImages\\Img1.jpg";
        String uploadPath2 = "C:\\Selenium Projects\\PMM_Tests\\UploadImages\\Img2.jpg";
        String uploadPath3 = "C:\\Selenium Projects\\PMM_Tests\\UploadImages\\Img3.jpg";
        String uploadPath4 = "C:\\Selenium Projects\\PMM_Tests\\UploadImages\\Img4.jpg";
        String uploadPath5 = "C:\\Selenium Projects\\PMM_Tests\\UploadImages\\Img5.jpg";
        String uploadPath6 = "C:\\Selenium Projects\\PMM_Tests\\UploadImages\\Img6.jpg";
        String uploadPath7 = "C:\\Selenium Projects\\PMM_Tests\\UploadImages\\Img7.jpg";
        String uploadPath8 = "C:\\Selenium Projects\\PMM_Tests\\UploadImages\\Img8.jpg";
        String uploadPath9 = "C:\\Selenium Projects\\PMM_Tests\\UploadImages\\Img9.jpg";
        String uploadPath10 = "C:\\Selenium Projects\\PMM_Tests\\UploadImages\\Img10.jpg";


        getWebDriver().findElement(By.xpath("//div[@class='modal fade imageUploadPopupModal in show']//input[@type='file']"))
                .sendKeys(uploadPath1 + "\n" + uploadPath2 + "\n" + uploadPath3 + "\n" + uploadPath4 + "\n"
                        + uploadPath5 + "\n" + uploadPath6 + "\n" + uploadPath7 + "\n" + uploadPath8 + "\n" + uploadPath9 + "\n" + uploadPath10);

        functions.click(uploadButton);
    }
    public void uploadImagesSecondImage() throws InterruptedException {
        Thread.sleep(1000);
        functions.clickHiddenElement(uploadPhotosButton2);
        Thread.sleep(3000);
        getWebDriver().switchTo().activeElement();
        functions.waitUntilElementIsVisible(pageTitle);
        functions.click(pageTitle);
        Thread.sleep(3000);


        String uploadPath1 = "C:\\Selenium Projects\\PMM_Tests\\UploadImages\\Img1.jpg";
        String uploadPath2 = "C:\\Selenium Projects\\PMM_Tests\\UploadImages\\Img2.jpg";
        String uploadPath3 = "C:\\Selenium Projects\\PMM_Tests\\UploadImages\\Img3.jpg";
        String uploadPath4 = "C:\\Selenium Projects\\PMM_Tests\\UploadImages\\Img4.jpg";
        String uploadPath5 = "C:\\Selenium Projects\\PMM_Tests\\UploadImages\\Img5.jpg";
        String uploadPath6 = "C:\\Selenium Projects\\PMM_Tests\\UploadImages\\Img6.jpg";
        String uploadPath7 = "C:\\Selenium Projects\\PMM_Tests\\UploadImages\\Img7.jpg";
        String uploadPath8 = "C:\\Selenium Projects\\PMM_Tests\\UploadImages\\Img8.jpg";
        String uploadPath9 = "C:\\Selenium Projects\\PMM_Tests\\UploadImages\\Img9.jpg";
        String uploadPath10 = "C:\\Selenium Projects\\PMM_Tests\\UploadImages\\Img10.jpg";


        getWebDriver().findElement(By.xpath("//div[@class='modal fade imageUploadPopupModal in show']//input[@type='file']"))
                .sendKeys(uploadPath1 + "\n" + uploadPath2 + "\n" + uploadPath3 + "\n" + uploadPath4 + "\n"
                        + uploadPath5 + "\n" + uploadPath6 + "\n" + uploadPath7 + "\n" + uploadPath8 + "\n" + uploadPath9 + "\n" + uploadPath10);

        functions.click(uploadButton);
    }
    public void uploadImagesThirdImage() throws InterruptedException {
        Thread.sleep(1000);
        functions.clickHiddenElement(uploadPhotosButton3);
        Thread.sleep(3000);
        getWebDriver().switchTo().activeElement();
        functions.waitUntilElementIsVisible(pageTitle);
        functions.click(pageTitle);
        Thread.sleep(3000);


        String uploadPath1 = "C:\\Selenium Projects\\PMM_Tests\\UploadImages\\Img1.jpg";
        String uploadPath2 = "C:\\Selenium Projects\\PMM_Tests\\UploadImages\\Img2.jpg";
        String uploadPath3 = "C:\\Selenium Projects\\PMM_Tests\\UploadImages\\Img3.jpg";
        String uploadPath4 = "C:\\Selenium Projects\\PMM_Tests\\UploadImages\\Img4.jpg";
        String uploadPath5 = "C:\\Selenium Projects\\PMM_Tests\\UploadImages\\Img5.jpg";
        String uploadPath6 = "C:\\Selenium Projects\\PMM_Tests\\UploadImages\\Img6.jpg";
        String uploadPath7 = "C:\\Selenium Projects\\PMM_Tests\\UploadImages\\Img7.jpg";
        String uploadPath8 = "C:\\Selenium Projects\\PMM_Tests\\UploadImages\\Img8.jpg";
        String uploadPath9 = "C:\\Selenium Projects\\PMM_Tests\\UploadImages\\Img9.jpg";
        String uploadPath10 = "C:\\Selenium Projects\\PMM_Tests\\UploadImages\\Img10.jpg";


        getWebDriver().findElement(By.xpath("//div[@class='modal fade imageUploadPopupModal in show']//input[@type='file']"))
                .sendKeys(uploadPath1 + "\n" + uploadPath2 + "\n" + uploadPath3 + "\n" + uploadPath4 + "\n"
                        + uploadPath5 + "\n" + uploadPath6 + "\n" + uploadPath7 + "\n" + uploadPath8 + "\n" + uploadPath9 + "\n" + uploadPath10);

        functions.click(uploadButton);
    }
    public void uploadImagesForthImage() throws InterruptedException {
        Thread.sleep(1000);
        functions.clickHiddenElement(uploadPhotosButton4);
        Thread.sleep(3000);
        getWebDriver().switchTo().activeElement();
        functions.waitUntilElementIsVisible(pageTitle);
        functions.click(pageTitle);
        Thread.sleep(3000);


        String uploadPath1 = "C:\\Selenium Projects\\PMM_Tests\\UploadImages\\Img1.jpg";
        String uploadPath2 = "C:\\Selenium Projects\\PMM_Tests\\UploadImages\\Img2.jpg";
        String uploadPath3 = "C:\\Selenium Projects\\PMM_Tests\\UploadImages\\Img3.jpg";
        String uploadPath4 = "C:\\Selenium Projects\\PMM_Tests\\UploadImages\\Img4.jpg";
        String uploadPath5 = "C:\\Selenium Projects\\PMM_Tests\\UploadImages\\Img5.jpg";
        String uploadPath6 = "C:\\Selenium Projects\\PMM_Tests\\UploadImages\\Img6.jpg";
        String uploadPath7 = "C:\\Selenium Projects\\PMM_Tests\\UploadImages\\Img7.jpg";
        String uploadPath8 = "C:\\Selenium Projects\\PMM_Tests\\UploadImages\\Img8.jpg";
        String uploadPath9 = "C:\\Selenium Projects\\PMM_Tests\\UploadImages\\Img9.jpg";
        String uploadPath10 = "C:\\Selenium Projects\\PMM_Tests\\UploadImages\\Img10.jpg";


        getWebDriver().findElement(By.xpath("//div[@class='modal fade imageUploadPopupModal in show']//input[@type='file']"))
                .sendKeys(uploadPath1 + "\n" + uploadPath2 + "\n" + uploadPath3 + "\n" + uploadPath4 + "\n"
                        + uploadPath5 + "\n" + uploadPath6 + "\n" + uploadPath7 + "\n" + uploadPath8 + "\n" + uploadPath9 + "\n" + uploadPath10);

        functions.click(uploadButton);
    }
    public void uploadImagesFithImage() throws InterruptedException {
        Thread.sleep(1000);
        functions.clickHiddenElement(uploadPhotosButton5);
        Thread.sleep(3000);
        getWebDriver().switchTo().activeElement();
        functions.waitUntilElementIsVisible(pageTitle);
        functions.click(pageTitle);
        Thread.sleep(3000);


        String uploadPath1 = "C:\\Selenium Projects\\PMM_Tests\\UploadImages\\Img1.jpg";
        String uploadPath2 = "C:\\Selenium Projects\\PMM_Tests\\UploadImages\\Img2.jpg";
        String uploadPath3 = "C:\\Selenium Projects\\PMM_Tests\\UploadImages\\Img3.jpg";
        String uploadPath4 = "C:\\Selenium Projects\\PMM_Tests\\UploadImages\\Img4.jpg";
        String uploadPath5 = "C:\\Selenium Projects\\PMM_Tests\\UploadImages\\Img5.jpg";
        String uploadPath6 = "C:\\Selenium Projects\\PMM_Tests\\UploadImages\\Img6.jpg";
        String uploadPath7 = "C:\\Selenium Projects\\PMM_Tests\\UploadImages\\Img7.jpg";
        String uploadPath8 = "C:\\Selenium Projects\\PMM_Tests\\UploadImages\\Img8.jpg";
        String uploadPath9 = "C:\\Selenium Projects\\PMM_Tests\\UploadImages\\Img9.jpg";
        String uploadPath10 = "C:\\Selenium Projects\\PMM_Tests\\UploadImages\\Img10.jpg";


        getWebDriver().findElement(By.xpath("//div[@class='modal fade imageUploadPopupModal in show']//input[@type='file']"))
                .sendKeys(uploadPath1 + "\n" + uploadPath2 + "\n" + uploadPath3 + "\n" + uploadPath4 + "\n"
                        + uploadPath5 + "\n" + uploadPath6 + "\n" + uploadPath7 + "\n" + uploadPath8 + "\n" + uploadPath9 + "\n" + uploadPath10);

        functions.click(uploadButton);
    }
}
