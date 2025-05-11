package eu.senla;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class LoginPageTest extends BaseTest {

  @Test
  @Order(0)
  @DisplayName("Проверка успешного логина")
  @Tag("smoke")
  public void testPositiveLoginPage() {
    // driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    wait.until(d -> driver.findElement(By.name("username")).isDisplayed());

    driver.findElement(By.name("username")).sendKeys("Admin");
    driver.findElement(By.name("password")).sendKeys("admin123");
    driver.findElement(By.cssSelector("button[type='submit']")).click();

    // open admin page
    wait.until(d -> driver.findElement(By.xpath("//h6[text()='Dashboard']")).isDisplayed());

    assertTrue(
        driver.findElement(By.xpath("//h6[text()='Dashboard']")).isDisplayed(), "Login failed");
  }

  @ParameterizedTest()
  @Order(1)
  @DisplayName("Проверка неуспешного логина")
  @Tag("extended")
  @CsvSource({"Admin, 1234564",
          "WrongName, admin123",
          "AnyName, 43211"})
  public void testNegativeLoginPage(String userName, String password) {
    driver.manage().deleteAllCookies();
    driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    driver.navigate().refresh();

    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    wait.until(d -> driver.findElement(By.name("username")).isDisplayed());

    driver.findElement(By.name("username")).sendKeys(userName);
    driver.findElement(By.name("password")).sendKeys(password);
    driver.findElement(By.cssSelector("button[type='submit']")).click();

    wait.until(
        d -> driver.findElement(By.xpath("//p[text()='Invalid credentials']")).isDisplayed());

    assertTrue(
        driver.findElement(By.xpath("//p[text()='Invalid credentials']")).isDisplayed(),
        "No popup message Invalid Credentials");
    assertEquals(
            "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login",
            driver.getCurrentUrl(),
        "Unexpected Successful login");
  }
}
