package pl.prestashop.pages.parts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.prestashop.pages.*;

public class HeaderTop extends BasePage {

    private WebDriver wait;

    public HeaderTop(WebDriver driver, Actions actions){
        super(driver, actions);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(headerLocator));
    }

    private By headerLocator = By.cssSelector("nav.header-nav");
    private By loginButtonLocator = By.cssSelector("div#_desktop_user_info a");

    public LoginPage openLoginPage(){
        actions.moveToElement(driver.findElement(loginButtonLocator)).click().build().perform();
        return new LoginPage(driver, actions);
    }

}
