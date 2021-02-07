package pl.prestashop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeliveryAndPaymentPage extends BasePage {

    public DeliveryAndPaymentPage(WebDriver driver, Actions actions) {
        super(driver, actions);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(addToCartPopUp));
    }

    private By addToCartPopUp = By.cssSelector("body#checkout");
    private By confirmDAddressesButtonLocator = By.name("confirm-addresses");
    private By confirmDeliveryButtonLocator = By.name("confirmDeliveryOption");
    private By checkPaymentOptionButtonLocator = By.id("payment-option-2");
    private By approveConditionsCheckLocator = By.id("conditions_to_approve[terms-and-conditions]");
    private By confirmOrderButtonLocator = By.cssSelector("div#payment-confirmation button");

    public DeliveryAndPaymentPage confirmAddresses(){
        actions.moveToElement(driver.findElement(confirmDAddressesButtonLocator)).click().build().perform();
        return this;
    }

    public DeliveryAndPaymentPage confirmDeliveryOption(){
        actions.moveToElement(driver.findElement(confirmDeliveryButtonLocator)).click().build().perform();
        return this;
    }

    public DeliveryAndPaymentPage checkPaymentOption(){
        actions.moveToElement(driver.findElement(checkPaymentOptionButtonLocator)).click().build().perform();
        return this;
    }

    public DeliveryAndPaymentPage approveConditions(){
        actions.moveToElement(driver.findElement(approveConditionsCheckLocator)).click().build().perform();
        return this;
    }

    public OrderConfirmationPage confirmOrder(){
        actions.moveToElement(driver.findElement(confirmOrderButtonLocator)).click().build().perform();
        return new OrderConfirmationPage(driver, actions);
    }

}
