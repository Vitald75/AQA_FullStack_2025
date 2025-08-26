package eu.senla.listeners;

import eu.senla.core.Driver;
import eu.senla.core.ScreenshotUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Slf4j
public final class ScreenshotListener implements ITestListener {
    @SneakyThrows
    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = Driver.getInstance();
        if (driver != null) {
            ScreenshotUtil.takeScreenshot(driver);
        } else {
            //System.out.println("WebDriver is null. Screenshot not taken.");
            log.warn("WebDriver is null. Screenshot has not been taken");
        }
    }
}
