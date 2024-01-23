package PMM.loginPage;



import PMM.baseClass.TestBase;
import PMM.utilities.CommonFunctions;
import PMM.utilities.PasswordEncryptor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
    CommonFunctions functions;
    PasswordEncryptor encryptor;
    //Screenshots screenshot;


    @FindBy(xpath = "//input[@id='dnn_ctr426_Signin_txtUsername']") WebElement usernameField;
    @FindBy(xpath = "//input[@id='dnn_ctr426_Signin_txtPassword']") WebElement passwordField;
    @FindBy(xpath = "//input[@id='dnn_ctr426_Signin_cmdLogin']") WebElement loginButton;



    public LoginPage() {
        PageFactory.initElements(getWebDriver(), this);
        functions = new CommonFunctions();
        encryptor = new PasswordEncryptor();
    }

    public void login(String username,String password) throws Exception {
        String passwordAfterDecode = encryptor.DecodeBase64Java(password);
        functions.setTextBoxValue(usernameField, username);
        functions.setTextBoxValue(passwordField, passwordAfterDecode);
        functions.click(loginButton);



    }
}
