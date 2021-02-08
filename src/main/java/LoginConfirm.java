
import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.*;
        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.PageFactory;

public class LoginConfirm {

    WebDriver driver;


    @FindBy(xpath = "//a[@href='https://www.gittigidiyor.com/uye-girisi']")
    private WebElement loginButtonConfirm;


    public LoginConfirm(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnloginButtonConfirm() {
        loginButtonConfirm.click();
    }


}
