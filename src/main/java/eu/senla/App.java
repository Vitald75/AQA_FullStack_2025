package eu.senla;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/** Hello world! */
public class App {
  public static void main(String[] args) {
    WebDriver driver = new ChromeDriver();

    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    WebElement username = null;
    try {
      username = driver.findElement(By.name("username"));
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    username.sendKeys("Admin");

    try {
      Thread.sleep(200);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    driver.quit();
  }
}
