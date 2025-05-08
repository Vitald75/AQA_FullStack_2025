package eu.senla;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

  public final void successfulLogin() {
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    final int waitingTime = 6;
    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(waitingTime));
    wait.until(d -> driver.findElement(By.name("username")).isDisplayed());

    driver.findElement(By.name("username")).sendKeys("Admin");
    driver.findElement(By.name("password")).sendKeys("admin123");
    driver.findElement(By.cssSelector("button[type='submit']")).click();
    wait.until(d -> driver.findElement(By.xpath("//h6[text()='Dashboard']")).isDisplayed());
  }

}
