package pl.prestashop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver, Actions actions) {
        super(driver, actions);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(productPage));
    }

    private By productPage = By.cssSelector("body#product");
    private By addToCartButtonLocator = By.cssSelector(".add-to-cart");

    public addToCartPopUp addToCart(){
        actions.moveToElement(driver.findElement(addToCartButtonLocator)).click().build().perform();
        return new addToCartPopUp(driver, actions);
    }

}
