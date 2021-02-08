
import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.*;
        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.How;
        import org.openqa.selenium.support.PageFactory;

public class GittiGidiyorHomePage {
    WebDriver driver;

    //To give driver for opening the site of "Gittigidiyor"
    private static String MainPageUrl = "https://www.gittigidiyor.com/";

    //Finding Login button on Home Page of Gittigidiyor
    @FindBy(xpath = "//header[@id='main-header']/div[3]/div/div/div/div[3]/div/div[1]/div[@title='Giriş Yap']/div[@class='gekhq4-4 hwMdSM']")
    private WebElement loginButton; // The Login Button of Gittigidiyor



    //Constructor
    public GittiGidiyorHomePage(WebDriver driver) {
        this.driver = driver;
        driver.get(MainPageUrl);
        PageFactory.initElements(driver, this);
    }

    //The function for Login button
    public void clickOnLoginButton() {
        loginButton.click();
    }

}
