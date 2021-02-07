package pl.prestashop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver, Actions actions) {
        super(driver, actions);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(addToCartPopUp));
    }

    private By addToCartPopUp = By.cssSelector("body#cart");
    private By realizeOrderButtonLocator = By.cssSelector(".checkout a");

    public DeliveryAndPaymentPage realizeOrder(){
        actions.moveToElement(driver.findElement(realizeOrderButtonLocator)).click().build().perform();
        return new DeliveryAndPaymentPage(driver, actions);
    }

}
