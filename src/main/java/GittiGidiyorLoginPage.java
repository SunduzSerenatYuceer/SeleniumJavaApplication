
import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.*;
        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.How;
        import org.openqa.selenium.support.PageFactory;


public class GittiGidiyorLoginPage {
    WebDriver driver;


    @FindBy(how = How.ID, using = "L-UserNameField") //To find mail address box
    private WebElement loginMail;    //The box for sending the mail


    @FindBy(how = How.ID, using = "L-PasswordField") //To find password box
    private WebElement loginPassword; //The box for sending the password


    @FindBy(how = How.ID, using = "gg-login-enter") //To find login button for login the site
    private WebElement loginButton; // The Login button in the Login page

    //Constructor
    public GittiGidiyorLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Sending the mail to mail box in Login page.
    public void setLoginMail(String strEmail) {
        loginMail.sendKeys(strEmail);
    }

    //Sending the password to password box in Login page.
    public void setLoginPassword(String password) {
        loginPassword.sendKeys(password);
    }

    //The function for Login button.
    public void clickOnLogin() {
        loginButton.click();
    }


}
