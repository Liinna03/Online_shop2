package PageObject;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class CartPage {

    private WebDriver driver;
    @FindBy(how = How.XPATH,using = "//*[@id=\"center_column\"]/ul/li/div/div[2]/h5/a")
    WebElement blouseButton;

    @FindBy(how = How.XPATH,using = "//*[@id=\"add_to_cart\"]/button")
    WebElement cartButton;

    @FindBy(how = How.XPATH,using = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")
    WebElement ProceedToCheckoutButton;


    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public void selectProduct()  {
        /* Search the required WebElements and click them */
        WebElement blouse = waitClick(blouseButton);
        blouse.click();

        WebElement cart = waitClick(cartButton);
        cart.click();
    }

    public void addItem() {
        WebElement ProceedToCheckout = waitClick(ProceedToCheckoutButton);
        ProceedToCheckout.click();
    }

    private WebElement waitClick(WebElement element) {
        return (new WebDriverWait(driver,10))
                .until(ExpectedConditions.elementToBeClickable
                        (element));
    }

}



