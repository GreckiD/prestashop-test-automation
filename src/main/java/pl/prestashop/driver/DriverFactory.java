package pl.prestashop.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    private static ChromeOptions chromeOptions = new ChromeOptions();

    public static WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        chromeOptions.addArguments("--no-sandbox");
        return new ChromeDriver(chromeOptions);
    }

}