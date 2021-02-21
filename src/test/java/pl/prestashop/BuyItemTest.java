package pl.prestashop;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pl.prestashop.Listeners.ListenerManager;
import pl.prestashop.database.JDBCConnector;
import pl.prestashop.pages.OrderConfirmationPage;
import pl.prestashop.pages.parts.*;

import static pl.prestashop.config.BuildConfiguration.getTestData;

@Listeners(ListenerManager.class)

public class BuyItemTest extends BaseTest {

    private String url = getTestData("url");
    private String customerEmail = getTestData("customerEmail");
    private String customerPassword = getTestData("customerPassword");

    private String orderIdentifier;

    @Test
    public void buyItemTest() {
        driver.get(url);
        HeaderTop headerTop = new HeaderTop(driver, actions);
        MainMenu mainMenu = new MainMenu(driver, actions);
        headerTop.openLoginPage().logIn(customerEmail, customerPassword);
        mainMenu.openHomePage().openProductPage("Mug Today is a good day").addToCart().openCart()
                .realizeOrder().confirmAddresses().confirmDeliveryOption().checkPaymentOption().approveConditions().confirmOrder();
        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver, actions);
        orderIdentifier = orderConfirmationPage.getOrderIdentifier();
    }

    @AfterMethod
    public void cleanUpAfterTest() {
        System.out.println("Start CleanUp!");
        JDBCConnector jdbcConnector = new JDBCConnector();
        jdbcConnector.deleteOrder(orderIdentifier);
    }

}