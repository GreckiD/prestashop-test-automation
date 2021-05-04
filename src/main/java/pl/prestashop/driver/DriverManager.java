package pl.prestashop.driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
    private static ThreadLocal<WebDriver> webDriver2 = new ThreadLocal<WebDriver>();

    public static WebDriver getWebDriver() {
        return webDriver.get();
    }

    public static WebDriver getWebDriver2() {
        return webDriver2.get();
    }

    public static void setWebDriver(WebDriver driver) {
        webDriver.set(driver);
    }

    public static void setWebDriver2(WebDriver driver) {
        webDriver2.set(driver);
    }
}
