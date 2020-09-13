package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import PageObject.CartPage;
import PageObject.HomePage;

import static org.junit.Assert.assertEquals;


public class StepDefinitions {

    private WebDriver driver;

    /* Path to the current project folder */
    private final String Path = System.getProperty("user.dir") + "/src/main/resources/";
    private String picked_item;
    private HomePage homePage;
    private CartPage cartPage;

    @Before
    public void setup() {
        /* Initialize the Webdriver Object */
        System.setProperty("webdriver.chrome.driver", Path + "chromedriver.exe");
        driver = new ChromeDriver();
        String URL = "http://automationpractice.com/index.php";
        driver.get(URL);
        driver.manage().window().maximize();
    }

    @Given("The users enters to the online shop new experience")
    public void The_users_enters_to_the_online_shop_new_experience() {
        /* Initialize the Home Page and Open the Website */
        // homePage.openWebsite();
    }

    @When("The user searches a {string}")
    public void the_user_adds_a_product_to_the_shopping_cart(String string) {
        /* Initialize the Home Page and search a product */
        homePage.searchProduct(string);
    }

    @When("The users adds the item to the shopping cart")
    public void the_users_adds_the_item_to_the_shopping_cart() {
        /* Initialize the Cart Page and add an item to the cart */
        picked_item = cartPage.addItem();
    }

    @Then("The product is added successfully")
    public void the_product_is_added_successfully() {
        /* Initialize the Cart Page and select a product */
        String product =cartPage.selectProduct();
        /* Assert the selected item with the item in the cart */
        assertEquals(picked_item,product);

    }
    @After
    public void close() {
        /* Quit the Webdriver Object */
        driver.quit();
    }

}
