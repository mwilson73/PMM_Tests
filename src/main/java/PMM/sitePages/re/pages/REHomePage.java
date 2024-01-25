package PMM.sitePages.re.pages;


import PMM.baseClass.TestBase;
import PMM.utilities.CommonFunctions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class REHomePage extends TestBase {
    CommonFunctions functions;

    @FindBy(linkText = "http://USBank-Prod.relrelease-element.com/PartnerCenter")
    WebElement USBankLinkDEMO;


    public REHomePage() {
        PageFactory.initElements(getWebDriver(), this);
        functions = new CommonFunctions();
    }

    public void clickUSBankLink() {
        if (USBankLinkDEMO.isDisplayed()) {functions.clickWithoutWaitTime(USBankLinkDEMO);
            //functions.PageLoadTime();
        }
        else {
            getWebDriver().quit();
        }
    }



}