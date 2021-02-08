import org.apache.log4j.*;
        import org.junit.After;
        import org.junit.Assert;
        import org.junit.Before;
        import org.junit.Test;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;


public class JTest {

    WebDriver driver;

    @Before
    public void setup() {

        //Creating WebDriver ChromeDriver
        System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void TestHomepage() throws InterruptedException {

        //Creating Logger
        final Logger logger = Logger.getLogger(this.getClass());
        PropertyConfigurator.configure("src/log4j.properties");

        //Testcase for HomePage of Gittigidiyor
        GittiGidiyorHomePage homePage;
        homePage = new GittiGidiyorHomePage(driver);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.gittigidiyor.com/"); //Checking if HomePage is open.
        logger.debug("Homepage is opened successfully.");
        homePage.clickOnLoginButton(); // Opening Login Page
        logger.debug("Homepage is opened successfully.");
        Thread.sleep(3000); //Waiting for loading the page.
        LoginConfirm LoginConfirm; //Creating HomePage element.
        LoginConfirm = new LoginConfirm(driver);
        LoginConfirm.clickOnloginButtonConfirm();
        logger.debug("Homepage is opened successfully.");
        Thread.sleep(3000); //Waiting for the page.

        //Test Case for LoginPage of Gittigidiyor
        GittiGidiyorLoginPage loginPage; //Creating a LoginPage element.
        loginPage = new GittiGidiyorLoginPage(driver);
        loginPage.setLoginMail("fortestingprojectmail@gmail.com"); //Sending mail information to Login page
        loginPage.setLoginPassword("s55075507"); //Sending password information to Login page
        loginPage.clickOnLogin();  // Login to Gittigidiyor
        Thread.sleep(3000); //Waiting for loading the page.
        Assert.assertFalse((driver.findElements(By.className("btnSignIn")).size() > 0)); //Checking if Login process is successful.
        logger.debug("Login successful.");

        //Test Case for Searching Product
        SearchPage searchPageChange;
        searchPageChange = new SearchPage(driver);
        searchPageChange.clickSearchBox();  //Clicking Search Box to enter a word that will be searched.
        searchPageChange.setSearchBox("bilgisayar"); //Sending the word in search box.
        searchPageChange.clickSearchButton();   //Searching the word
        Thread.sleep(2000); //Waiting for loading the page.
        searchPageChange.clickcloseWarning();
        Thread.sleep(2000);
        searchPageChange.clickNextPage();
        Thread.sleep(3000); //Waiting for loading the page.
        Assert.assertEquals("https://www.gittigidiyor.com/arama/?k=bilgisayar&sf=2", driver.getCurrentUrl()); //Checking if the second page of the committed search is opened.
        logger.debug("Search page 2 is opened successfully.");

        //Testcase for choosing a product randomly and getting price of product
        ChooseProduct chooseProduct;
        chooseProduct = new ChooseProduct(driver);
        chooseProduct.chooseRandomProduct(); // Choosing a product randomly and clicking the product.
        Thread.sleep(3000); //Waiting for loading the page.
        Assert.assertFalse((driver.findElements(By.className("wrapper product")).size() > 0)); //Checking if the Product Page is opened.
        logger.debug("Product page is opened successfully.");
        String pagePrice = chooseProduct.productPrice(); //Getting price of the product from Product Page.
        System.out.println(pagePrice);

        //Test Case for adding a product that is chosen and comparison of products
        AddToCart addToCart;
        addToCart = new AddToCart(driver);
        addToCart.clickAddToCartButton(); //Adding product
        Thread.sleep(3000); //Waiting for loading the page.
        addToCart.clickCartHolder(); //Opening Cart page.
        String cartPrice = addToCart.cartPrice(); //Getting price of the product from Cart Page.
        Assert.assertEquals(pagePrice, cartPrice); //Checking tif prices are equal.
        logger.debug("Product price is equal to the cart price.");

        //Test Case for increasing quantity of the product
        IncreaseQuantity increaseProductQuantity;
        increaseProductQuantity = new IncreaseQuantity(driver);
        increaseProductQuantity.clickIncreaseQuantityButton(); //Increasing quantity of the product.
        Thread.sleep(3000); //Waiting for loading the page.
        int quantity = increaseProductQuantity.getCurrentQuantity(); // Getting the quantity of the product
        Assert.assertEquals(quantity, 2); //Checking if the quantity of the product is equal to "2".
        logger.debug("Quantity of the product increased to 2 successfully.");

        //Test Case for clearing the Cart
        ClearCart clearCart;
        clearCart = new ClearCart(driver);
        clearCart.clickClearCartButton(); //Pressing the button to clear cart
        Assert.assertFalse(driver.findElements(By.xpath("//div[@class='gg-d-24']//h2")).isEmpty()); //Checking if the Cart is empty.
        logger.debug("The cart is emptied successfully.");
        Thread.sleep(3000); //Waiting for clearing cart


    }


    @After
    public void close() {
        driver.close();  //To close chromedriver.exe
    }


}
