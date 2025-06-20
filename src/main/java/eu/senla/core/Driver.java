package eu.senla.core;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@UtilityClass
public final class Driver {
  private WebDriver driver;

  public WebDriver getInstance() {
    if (driver == null) {
      driver = new ChromeDriver();
      driver.manage().window().maximize();
    }
    return driver;
  }

  public void quit() {
    driver.quit();
    driver = null;
  }
}
