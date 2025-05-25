package eu.senla;

// import org.junit.jupiter.api;
import eu.senla.core.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BaseTest {
  // protected static WebDriver driver;
  // protected static Wait<WebDriver> wait;

  @BeforeEach
  final void init() {
    Driver.getInstance().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    // final int waitingTime = 6;
    // driver = new ChromeDriver();
    // wait = new WebDriverWait(driver, Duration.ofSeconds(waitingTime));
  }

  @AfterEach
  final void tearDown() {
    Driver.quit();
  }

  //  public final void successfulLogin() {
  //    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
  //
  //    wait.until(d -> driver.findElement(By.name("username")).isDisplayed());
  //
  //    //driver.findElement(By.name("username")).sendKeys("Admin");
  //    //driver.findElement(By.name("password")).sendKeys("admin123");
  //    //driver.findElement(By.cssSelector("button[type='submit']")).click();
  //    wait.until(d -> driver.findElement(By.xpath("//h6[text()='Dashboard']")).isDisplayed());
  //    //driver.manage().window().maximize();
  //  }
}
