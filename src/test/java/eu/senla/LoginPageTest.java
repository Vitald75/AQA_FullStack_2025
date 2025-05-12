package eu.senla;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;

public final class LoginPageTest extends BaseTest {

  @Test
  @Order(0)
  @DisplayName("Проверка успешного логина")
  @Tag("smoke")
  public void testPositiveLoginPage() {
    // driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

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
  @CsvSource({"Admin, 1234564", "WrongName, admin123", "AnyName, 43211"})
  public void testNegativeLoginPage(String userName, String password) {
    driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

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
