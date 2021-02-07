package pl.prestashop;

import org.testng.annotations.Test;
import pl.prestashop.pages.*;
import pl.prestashop.pages.parts.*;

import static pl.prestashop.config.BuildConfiguration.getTestData;

public class BuyItemTest extends BaseTest{

    private String url = getTestData("url");
    private String customerEmail = getTestData("customerEmail");
    private String customerPassword = getTestData("customerPassword");

    @Test
    public void buyItemTest() {
        driver.get(url);
        HeaderTop headerTop = new HeaderTop(driver, actions);
        MainMenu mainMenu = new MainMenu(driver, actions);
        headerTop.openLoginPage().logIn(customerEmail, customerPassword);
        mainMenu.openHomePage().openProductPage("Mug Today is a good day").addToCart().openCart()
                .realizeOrder().confirmAddresses().confirmDeliveryOption().checkPaymentOption().approveConditions().confirmOrder();
    }

}
