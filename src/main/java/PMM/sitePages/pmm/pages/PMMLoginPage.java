package PMM.sitePages.pmm.pages;
import PMM.baseClass.TestBase;
import PMM.utilities.CommonFunctions;
import PMM.utilities.PasswordEncryptor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PMMLoginPage extends TestBase {
    CommonFunctions functions;
    PasswordEncryptor encryptor;





    @FindBy(xpath = "//input[@placeholder='User name or email *']")
    WebElement usernameField;
    @FindBy(xpath = "//input[@placeholder='Password *']")
    WebElement passwordField;
    @FindBy(xpath = "//button[normalize-space()='Log in']")
    WebElement loginButton;



    public PMMLoginPage() {
        PageFactory.initElements(getWebDriver(), this);
        functions = new CommonFunctions();
        encryptor = new PasswordEncryptor();


    }

    public void login(String username,String password){
        //String passwordAfterDecode = encryptor.DecodeBase64Java(password);
        functions.waitUntilElementIsVisible(usernameField);
        functions.setTextBoxValue(usernameField, username);
        functions.setTextBoxValue(passwordField, password);
        functions.click(loginButton);
    }




    }
