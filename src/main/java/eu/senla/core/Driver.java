package eu.senla.core;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@UtilityClass
public final class Driver {

  //private WebDriver driver;
  private ThreadLocal<WebDriver> driver = new ThreadLocal<>();

  //@Parameters({"browser"})
  public WebDriver getInstance() {

    if (driver.get() == null) {
      String browserName = System.getProperty("browser");

      if ("chrome".equalsIgnoreCase(browserName)) {
        //driver = new ChromeDriver();
        driver.set(new ChromeDriver());
      } else if ("firefox".equalsIgnoreCase(browserName)) {
        //driver = new FirefoxDriver();
        driver.set(new FirefoxDriver());
      } else {
        // Default to Chrome or handle error
        driver.set(new ChromeDriver());
      }
      driver.get().manage().window().maximize();
    }

    return driver.get();
  }

  public void quit() {
    driver.get().quit();
    //driver = null;
    driver.remove();
  }
}
