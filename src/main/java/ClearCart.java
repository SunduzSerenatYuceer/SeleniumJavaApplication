
import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.*;
        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.PageFactory;

public class ClearCart {
    WebDriver driver;

    //Finding clear cart button.
    @FindBy(xpath = "//div[@class='products-container']/div[6]/div[2]//div[@class='row']/a[@title='Sil']")
    public WebElement clearCartButton; //The Clear button in the Cart Page

    //Constructor
    public ClearCart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //The function for clicking the clear cart button.
    public void clickClearCartButton() {
        clearCartButton.click();
    }


}