package pl.prestashop.pages.parts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.prestashop.pages.*;

public class MainMenu extends BasePage {

    public MainMenu(WebDriver driver, Actions actions) {
        super(driver, actions);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(headerLocator));
    }

    private By headerLocator = By.cssSelector(".header-top");
    private By logoLocator = By.cssSelector("img.logo");

    public HomePage openHomePage() {
        actions.moveToElement(driver.findElement(logoLocator)).click().build().perform();
        return new HomePage(driver, actions);
    }

}
