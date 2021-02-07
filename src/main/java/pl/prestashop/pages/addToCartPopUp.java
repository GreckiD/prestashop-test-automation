package pl.prestashop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class addToCartPopUp extends BasePage {

    public addToCartPopUp(WebDriver driver, Actions actions) {
        super(driver, actions);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(addToCartPopUp));
    }

    private By addToCartPopUp = By.cssSelector("div#blockcart-modal");
    private By openCartButtonLocator = By.cssSelector(".cart-content-btn a");

    public CartPage openCart(){
        actions.moveToElement(driver.findElement(openCartButtonLocator)).click().build().perform();
        return new CartPage(driver, actions);
    }

}
