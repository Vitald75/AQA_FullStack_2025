package eu.senla.core;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

@UtilityClass
public final class Driver {

  private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();


  public static  WebDriver getInstance() {

   if (driver.get() == null) {
        String browser = System.getProperty("browser").toLowerCase();
        if (Boolean.parseBoolean(System.getProperty("SELENOID_ENABLE"))) {
          initRemoteDriver(browser);
        } else {
          initLocalDriver(browser);
        }
      driver.get().manage().window().maximize();
    }

    return driver.get();
  }

  private static void initLocalDriver(String browser) {
    switch (browser) {
      case "chrome" -> {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
                if (Boolean.parseBoolean(ReadPropertiesFile.getProperty("HEADLESS"))) {
                   options.addArguments("--headless=new");
               }
        driver.set(new ChromeDriver(options));
      }
      case "firefox" -> {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--width=1920");
        options.addArguments("--height=1080");
                if (Boolean.parseBoolean(ReadPropertiesFile.getProperty("HEADLESS"))) {
                   options.addArguments("--headless");
               }
        driver.set(new FirefoxDriver(options));
      }
      default -> throw new IllegalArgumentException("Передан неподдерживаемый браузер");
    }
  }

  private static void initRemoteDriver(String browser) {
    try {
      DesiredCapabilities capabilities = new DesiredCapabilities();
      switch (browser) {
        case "chrome" -> {
          ChromeOptions chromeOptions = new ChromeOptions();
          // required for Docker/Selenoid stability. (info by ChatGPT)
          chromeOptions.addArguments("--no-sandbox");
          chromeOptions.addArguments("--disable-dev-shm-usage");
          if (Boolean.parseBoolean(ConstantsClass.HEADLESS)) {
            chromeOptions.addArguments("--headless=new");
          }
          chromeOptions.setCapability("selenoid:options", Map.of(
                  "enableVNC", true,
                  "enableVideo", true
          ));
          capabilities.merge(chromeOptions);
        }
        case "firefox" -> {
          FirefoxOptions firefoxOptions = new FirefoxOptions();
          if (Boolean.parseBoolean(ConstantsClass.HEADLESS)) {
            firefoxOptions.addArguments("--headless");
          }
          firefoxOptions.setCapability("selenoid:options", Map.of(
                  "enableVNC", true,
                  "enableVideo", true
          ));
          capabilities.merge(firefoxOptions);
        }
        default -> throw new IllegalArgumentException("Unsupported remote browser: " + browser);
      }
      driver.set(new RemoteWebDriver(
              new URL(ConstantsClass.SELENOID_URL), capabilities));

    } catch (MalformedURLException e) {
      throw new RuntimeException("Invalid Selenoid URL", e);
    }
  }

  public static void driverTearDown() {
    driver.get().quit();
    //driver = null;
    driver.remove();
  }
}
