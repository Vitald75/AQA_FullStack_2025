package eu.senla.listeners;

import eu.senla.core.Driver;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public final class ScreenshotListener implements ITestListener {
    @SneakyThrows
    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = Driver.getInstance();
        if (driver != null) {
            ScreenshotHandler.getScreenshot(driver);
        } else {
            System.out.println("WebDriver is null. Screenshot not taken.");
        }
    }
}
