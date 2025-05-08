package eu.senla;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class BaseTest {
  protected static WebDriver driver;

  @BeforeAll
  static void init() {
    driver = new ChromeDriver();
  }

  @AfterAll
  static void tearDown() {
    driver.quit();
  }
}
