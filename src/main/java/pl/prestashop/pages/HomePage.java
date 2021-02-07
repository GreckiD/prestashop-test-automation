package pl.prestashop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage extends BasePage {

    public HomePage(WebDriver driver, Actions actions) {
        super(driver, actions);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(homePage));
    }

    private By homePage = By.id("index");
    private By productNameLocator = By.cssSelector("article.product-miniature h3.product-title a");

    public ProductPage openProductPage(String productName) {
        try {
            actions.moveToElement(driver.findElement(By.xpath("//a[contains(text(), '" + productName + "')]"))).click()
                    .build().perform();
        }
        catch (Exception e) {
            System.out.println("Nie udało się otworzyć strony produktu. Produktu nie ma na liście");
        }
        return new ProductPage(driver, actions);
    }
}
