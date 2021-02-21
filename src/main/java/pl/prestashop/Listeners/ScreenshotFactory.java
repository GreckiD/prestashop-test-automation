package pl.prestashop.Listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class ScreenshotFactory {

    public void getScreenshot(WebDriver driver, String testName) {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        String screenshotPath = "target/surefire-reports/screenshots/" + testName + "-" + date + "-" + time;
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(scrFile, new File(screenshotPath));
            System.out.println("Screenshot: " + screenshotPath);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
