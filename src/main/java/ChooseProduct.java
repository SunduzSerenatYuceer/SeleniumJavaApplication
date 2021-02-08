
import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.*;
        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.PageFactory;

        import java.util.List;
        import java.util.Random;


public class ChooseProduct {
    WebDriver driver;


    @FindBy(xpath="//div[@class='product-info-con clearfix ']") //Finding all products to choose randomly
    private List<WebElement> items; // The list of products

    //Constructor
    public ChooseProduct(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //The function for choosing a random product from items and clicking on the selected item
    public void chooseRandomProduct() {
        Random rand = new Random();
        WebElement random = items.get(rand.nextInt(27) + 11);
        random.click();
    }

    //The function for finding and getting the price of product from the product page
    public String productPrice() {
        String price = "";
        String[] productPrice = driver.findElement(By.id("sp-price-highPrice")).getText().split(" ");
        price = productPrice[0];
        return price;
    }

}

