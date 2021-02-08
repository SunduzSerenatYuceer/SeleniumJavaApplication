
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


class IncreaseQuantity{
    WebDriver driver;


    @FindBy(xpath = "//span[@class='plus icon-plus gg-icon gg-icon-plus']") //Finding increase quantity button for products
    public WebElement increaseQuantityButton; // Increase quantity button

    //Constructor
    public IncreaseQuantity(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //The function for clicking increase quantity button.
    public void clickIncreaseQuantityButton() {
        increaseQuantityButton.click();
    }

    //The function for getting quantity of the product from Cart page
    public int getCurrentQuantity() {
        WebElement checkQuantity = driver.findElement(By.className("amount"));
        int quantity = Integer.parseInt(checkQuantity.getAttribute("value"));
        return quantity;
    }


}