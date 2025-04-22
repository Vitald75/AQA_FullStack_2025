package eu.senla;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/** Unit test for simple App. */
public class AppTest {

  @Test
  public void firstTest() {

//    LoggingPreferences logs = new LoggingPreferences();
//    logs.enable(LogType.DRIVER, Level.ALL);
//
//    ChromeOptions options = new ChromeOptions();
//    options.setCapability( ChromeOptions.LOGGING_PREFS , logs);

    WebDriver driver = new ChromeDriver();
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

      try {
          WebElement usernameField = driver.findElement(By.name("username"));
          usernameField.sendKeys("Admin");
      } catch (Exception e) {
          System.out.println("Can't find Username element");
      }

    try {
      WebElement passwordField = driver.findElement(By.name("password"));
      passwordField.sendKeys("admin123");
    } catch (Exception e) {
      System.out.println("Can't find Password element");
    }

    // Locators for Login title
    // css    - "h5"
    // xpath  - "//h5"

    // Button Login
    // Xpath - "//button"
    try {
    WebElement loginButton = driver.findElement(By.cssSelector("button"));
    loginButton.click();
    } catch (Exception e) {
      System.out.println("Can't find Button element");
    }


    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    // open admin page
    driver.findElement(By.cssSelector("a[href$='viewAdminModule']")).click();
    driver.manage().window().maximize();

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    // username by CSS
    driver.findElement(By.cssSelector("input.oxd-input.oxd-input--active:first-child")).sendKeys("AdminCypress");

    // username by Xpath
    //driver.findElement(By.xpath("//div[@class=\"oxd-form-row\"]//input[@class=\"oxd-input oxd-input--active\"]")).sendKeys("New username XPath");


    // drop-down user role - Admin  by CSS
    driver.findElement(By.cssSelector("div.oxd-grid-item.oxd-grid-item--gutters:nth-child(2) div.oxd-select-text--after")).click();
    driver.findElement(By.cssSelector("div[role='listbox'] div:nth-of-type(2)")).click();

    // drop-down user role - Admin bt Xpath
    //driver.findElement(By.xpath("//label[contains(text(),'User Role')]/../..//div[@class='oxd-select-wrapper']")).click();
    //driver.findElement(By.xpath("//div[@role='option']/span[text()='Admin']/parent::*")).click();


    // button Search by CSS
    driver.findElement(By.cssSelector("button[type='submit']")).click();

    // button Search by Xpath
    //driver.findElement(By.xpath("//button[@type='submit']")).click();


    // button Add by CSS
    driver.findElement(By.cssSelector("button.oxd-button.oxd-button--medium.oxd-button--secondary[type='button']")).click();

    // button Add by Xpath
    //driver.findElement(By.xpath("//div[@class='orangehrm-header-container']/button")).click();

    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    driver.quit();
  }
}
