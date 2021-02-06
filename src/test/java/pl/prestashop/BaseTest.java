package pl.prestashop;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import pl.prestashop.driver.DriverFactory;
import pl.prestashop.driver.DriverManager;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriver driver2;
    protected Actions actions;
    protected Actions actions2;


    @BeforeMethod
    public void startDriver(){
        WebDriver driver = DriverFactory.getDriver();
        DriverManager.setWebDriver(driver);
        this.driver = DriverManager.getDriver();
        this.driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        this.driver.manage().window().setSize(new Dimension(1920,1080));
        this.actions = new Actions(this.driver);
    }

    public void startSecondDriver(){
        WebDriver driver = DriverFactory.getDriver();
        DriverManager.setWebDriver2(driver);
        this.driver2 = DriverManager.getDriver2();
        this.driver2.manage().window().setSize(new Dimension(1920,1080));
        this.driver2.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        this.actions2 = new Actions(this.driver2);
    }

    //@AfterTest
    public void closeAllDrivers() {
        if (DriverManager.getDriver() != null && DriverManager.getDriver2() != null) {
            DriverManager.getDriver().quit();
            DriverManager.getDriver2().quit();
        }
    }
}
