package eu.senla.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public final class Driver {
  private static WebDriver driver;

  private Driver() {

  }

  public static WebDriver getInstance() {
    if (driver == null) {
      driver = new ChromeDriver();
      driver.manage().window().maximize();
    }
    return driver;
  }

  public static void quit() {
    driver.quit();
    driver = null;
  }
}
