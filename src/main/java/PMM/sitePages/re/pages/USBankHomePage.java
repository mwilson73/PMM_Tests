package PMM.sitePages.re.pages;

import PMM.baseClass.TestBase;
import PMM.utilities.CommonFunctions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class USBankHomePage extends TestBase {

    CommonFunctions functions;


    @FindBy(xpath = "//div[contains(text(),'U.S. Bank. All rights reserved.')]")
    WebElement pageMessageTextArea;

    @FindBy(xpath = "//img[@alt='U.S. Bank']")
    WebElement usbankLogo;
    @FindBys(@FindBy(xpath = "//*[@id=\"tddnn_dnnSOLPARTMENU_ctldnnSOLPARTMENU70\"]/td"))
    public List<WebElement> accessList;
    @FindBy(xpath = "//a[normalize-space()='Profile Manager']")
    WebElement pmmLink;



    public USBankHomePage() {
        PageFactory.initElements(getWebDriver(), this);
        functions = new CommonFunctions();

    }

    public void assertSiteHomePage(String welcomeMessage, String siteURL) throws Exception {
        if (accessList.size()>0){
            getWebDriver().quit();
        }
        else{
            functions.waitUntilElementIsVisible(usbankLogo);
            functions.waitUntilTextIsPresentInElement(pageMessageTextArea, welcomeMessage);
            functions.verifySiteURL(siteURL);

        }
    }
    public void clickPMMLink(){
        functions.click(pmmLink);

    }

}


