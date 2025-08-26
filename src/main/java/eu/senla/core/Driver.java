package eu.senla.core;


import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@UtilityClass
public final class Driver {

  private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

  public static  WebDriver getInstance() {

    if (driver.get() == null) {

      switch (System.getProperty("browser").toLowerCase()) {
        case "chrome" -> driver.set(new ChromeDriver()); //= new ChromeDriver();
        case "firefox" -> driver.set(new FirefoxDriver()); //driver = new FirefoxDriver();
        default -> throw new IllegalArgumentException("Unknown browser");
      }
      driver.get().manage().window().maximize();
    }

    return driver.get();
  }

  public static void driverTearDown() {
    driver.get().quit();
    //driver = null;
    driver.remove();
  }
}
