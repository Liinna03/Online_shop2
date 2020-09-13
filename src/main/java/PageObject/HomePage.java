package PageObject;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage{
    private WebDriver driver;

    @FindBy(how = How.XPATH,using = "//*[@id=\"header_logo\"]/a/img")
    WebElement  Find_logo;

    @FindBy(how = How.XPATH,using = "//*[@id=\"search_query_top\"]")
    WebElement searchBar;

    @FindBy(how = How.XPATH,using = "//*[@id=\"searchbox\"]/button")
    WebElement SearchButton;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public void openWebsite() {
        /* Discar the Javascript Alert */
        //WebElement JavaScriptAlert = waitClick(javascriptAlert);
        //clickOnElement(JavaScriptAlert);

    }

    public void searchProduct(String product) {
        /* Search the desired item*/
        WebElement search_bar = waitClick(searchBar);
        sendText(search_bar,product);
        //sendEnter(search_bar);
        //WebElement Search = waitClick(SearchButton);
        //Search.click();

    }

    private void clickOnElement(@NotNull WebElement element) {
        element.click();
    }

    private void sendText(@NotNull WebElement element, String text) {
        element.sendKeys(text);
    }

    private void sendEnter(@NotNull WebElement element) {
        element.sendKeys(Keys.ENTER);
    }

    private WebElement waitClick(WebElement element) {
        return (new WebDriverWait(driver,10))
                .until(ExpectedConditions.elementToBeClickable
                        (element));
    }


}
