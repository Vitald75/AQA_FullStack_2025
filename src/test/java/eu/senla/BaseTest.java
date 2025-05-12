package eu.senla;

import java.time.Duration;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BaseTest {
  protected static WebDriver driver;
  protected static Wait<WebDriver> wait;

  @BeforeEach
  final void init() {
    final int waitingTime = 6;
    driver = new ChromeDriver();
    wait = new WebDriverWait(driver, Duration.ofSeconds(waitingTime));
  }

  @AfterEach
  final void tearDown() {
    driver.quit();
  }

  public final void successfulLogin() {
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    wait.until(d -> driver.findElement(By.name("username")).isDisplayed());

    driver.findElement(By.name("username")).sendKeys("Admin");
    driver.findElement(By.name("password")).sendKeys("admin123");
    driver.findElement(By.cssSelector("button[type='submit']")).click();
    wait.until(d -> driver.findElement(By.xpath("//h6[text()='Dashboard']")).isDisplayed());
    driver.manage().window().maximize();
  }
}
