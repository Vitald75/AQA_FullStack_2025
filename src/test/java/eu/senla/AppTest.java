package eu.senla;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/** Unit test for simple App. */
public class AppTest {

@Test
public void testLoginPage() {
  WebDriver driver = new ChromeDriver();
  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

  Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
  wait.until(d -> driver.findElement(By.name("username"))
          .isDisplayed());

  //wait.until(visibilityOf(driver.findElement(By.name("username"))));

  driver.findElement(By.name("username")).sendKeys("Admin");
  driver.findElement(By.name("password")).sendKeys("admin123");
  driver.findElement(By.cssSelector("button[type='submit']")).click();
}

  @Test
  public void testPimAddEmployee() {
    final int pause = 4;
    WebDriver driver = new ChromeDriver();
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(pause));
    wait.until(d -> driver.findElement(By.name("username"))
            .isDisplayed());

    // login
    driver.findElement(By.name("username")).sendKeys("Admin");
    driver.findElement(By.name("password")).sendKeys("admin123");
    driver.findElement(By.cssSelector("button[type='submit']")).click();

    // open admin page
    wait.until(d -> driver.findElement(By.xpath("//h6[text()='Dashboard']"))
            .isDisplayed());

    // open PIM page
    driver.findElement(By.cssSelector("a[href$='viewPimModule']")).click();
    driver.manage().window().maximize();
    wait.until(d -> driver.findElement(By.cssSelector("button.oxd-button.oxd-button--medium.oxd-button--secondary[type='button']"))
            .isDisplayed());

    // click button Add
    driver.findElement(By.cssSelector("button.oxd-button.oxd-button--medium.oxd-button--secondary[type='button']")).click();
    wait.until(d -> driver.findElement(By.xpath("//h6[text()='Add Employee']"))
            .isDisplayed());

    // fill form and click Save button
    driver.findElement(By.name("firstName")).sendKeys("Alexandr");
    driver.findElement(By.name("middleName")).sendKeys("Sergeevich");
    driver.findElement(By.name("lastName")).sendKeys("PushyKin");
    driver.findElement(By.xpath("//button[@type='submit']")).click();

    wait.until(d -> driver.findElement(By.xpath("//h6[text()='Alexandr PushyKin']")))
            .isDisplayed();

    driver.quit();
  }
}
