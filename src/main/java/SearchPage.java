
import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.*;
        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.How;
        import org.openqa.selenium.support.PageFactory;


public class SearchPage {

    WebDriver driver;


    @FindBy(xpath="//input[@data-cy='header-search-input']") //Finding the search box in Home Page
    private WebElement searchBox;  //Search box


    @FindBy(xpath="//button[@data-cy='search-find-button']") //Finding the search button to search the word
    private WebElement searchButton; //Search button


    @FindBy(xpath = "//a[@href='/arama/?k=bilgisayar&sf=2']") //Finding the second page button
    private WebElement nextPage; //The second page button


    @FindBy(xpath = "//span[@class='gg-icon gg-icon-close icon-close']")
    private WebElement closeWarning;

    //Constructor
    public SearchPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    //The function for clicking the search box
    public void clickSearchBox() {
        searchBox.click();
    }

    //The function to send the word "bilgisayar" to search box
    public void setSearchBox(String keys){
        searchBox.sendKeys(keys);
    }

    //The function for search button.
    public void clickSearchButton() {
        searchButton.click();
    }

    public void clickcloseWarning() {
        closeWarning.click();
    }

    //The function to go to second page.
    public void clickNextPage() {
        nextPage.click();
    }

}
