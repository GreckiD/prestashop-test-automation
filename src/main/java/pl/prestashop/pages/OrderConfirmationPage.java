package pl.prestashop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderConfirmationPage extends BasePage {

    public OrderConfirmationPage(WebDriver driver, Actions actions) {
        super(driver, actions);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(orderConfirmationPage));
    }

    private By orderConfirmationPage = By.cssSelector("body#order-confirmation");

}
