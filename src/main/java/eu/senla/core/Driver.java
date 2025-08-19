package eu.senla.core;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@UtilityClass
public final class Driver {
  private WebDriver driver;

  public WebDriver getInstance() {

    if (driver == null) {
      String browserName = System.getProperty("browser");

      if ("chrome".equalsIgnoreCase(browserName)) {
        driver = new ChromeDriver();
      } else if ("firefox".equalsIgnoreCase(browserName)) {
        driver = new FirefoxDriver();
      } else {
        // Default to Chrome or handle error
        driver = new ChromeDriver();
      }
      driver.manage().window().maximize();
    }

//    if (driver == null) {
//      driver = new ChromeDriver();
//      driver.manage().window().maximize();
//    }
    return driver;
  }

  public void quit() {
    driver.quit();
    driver = null;
  }
}
