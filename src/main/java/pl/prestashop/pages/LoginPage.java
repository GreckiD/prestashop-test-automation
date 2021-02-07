package pl.prestashop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver, Actions actions) {
        super(driver, actions);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(loginPage));
    }

    private By loginPage = By.id("authentication");
    private By emailInputLocator = By.name("email");
    private By passwordInputLocator = By.name("password");
    private By submitLoginButtonLocator = By.cssSelector("button#submit-login");

    public UserAccountPage logIn(String email, String password) {
        actions.moveToElement(driver.findElement(emailInputLocator)).click().sendKeys(email).build().perform();
        actions.moveToElement(driver.findElement(passwordInputLocator)).click().sendKeys(password).build().perform();
        actions.moveToElement(driver.findElement(submitLoginButtonLocator)).click().build().perform();
        return new UserAccountPage(driver, actions);
    }

}
