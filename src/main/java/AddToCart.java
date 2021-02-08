
import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.*;
        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.How;
        import org.openqa.selenium.support.PageFactory;


public class AddToCart {

    WebDriver driver;


    @FindBy(how = How.ID, using = "add-to-basket") //To find add button for adding product to the Cart.
    private WebElement addToCartButton; // The add button

    @FindBy(xpath = "//a[@class='dIB']") //To find button for opening the Cart
    private WebElement cartHolder; // The Cart button

    //Constructor
    public  AddToCart(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    //The function for adding the product to the Cart
    public void clickAddToCartButton(){
        addToCartButton.click();
    }

    //The function for opening the Cart
    public void clickCartHolder( ) {
        cartHolder.click();
    }
    //The function for finding and getting the price of product from The cart
    public String cartPrice(){
        String[] cart_price = driver.findElement(By.className("new-price")).getText().split(" ");
        String cartPrice = cart_price[0];
        return cartPrice;
    }
}
