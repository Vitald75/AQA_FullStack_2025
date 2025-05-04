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
  public void testAddUser() {
    final int pause = 4;
    WebDriver driver = new ChromeDriver();
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(pause));
    wait.until(d -> driver.findElement(By.name("username"))
            .isDisplayed());

    //wait.until(visibilityOf(driver.findElement(By.name("username"))));

    driver.findElement(By.name("username")).sendKeys("Admin");
    driver.findElement(By.name("password")).sendKeys("admin123");
    driver.findElement(By.cssSelector("button[type='submit']")).click();

    // open admin page
    //Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(pause));
    wait.until(d -> driver.findElement(By.xpath("//h6[text()='Dashboard']"))
            .isDisplayed());
    driver.findElement(By.cssSelector("a[href$='viewPimModule']")).click();
    driver.manage().window().maximize();

    // button Add
    wait.until(d -> driver.findElement(By.cssSelector("button.oxd-button.oxd-button--medium.oxd-button--secondary[type='button']"))
            .isDisplayed());
    driver.findElement(By.cssSelector("button.oxd-button.oxd-button--medium.oxd-button--secondary[type='button']")).click();

    //

    wait.until(d -> driver.findElement(By.xpath("//h6[text()='Add Employee']"))
            .isDisplayed());


    driver.findElement(By.name("firstName")).sendKeys("Alexandr");
    driver.findElement(By.name("middleName")).sendKeys("Sergeevich");
    driver.findElement(By.name("lastName")).sendKeys("PushyKin");
    driver.findElement(By.xpath("//button[@type='submit']")).click();

    wait.until(d -> driver.findElement(By.xpath("//h6[text()='Alexandr PushyKin']")))
            .isDisplayed();

    //
    // username by CSS
    //driver.findElement(By.cssSelector("input.oxd-input.oxd-input--active:first-child")).sendKeys("AdminCypress");

    // username by Xpath
    //driver.findElement(By.xpath("//div[@class=\"oxd-form-row\"]//input[@class=\"oxd-input oxd-input--active\"]"))
    //.sendKeys("New username XPath");

    // drop-down user role - Admin  by CSS
    //driver.findElement(By.cssSelector("div.oxd-grid-item.oxd-grid-item--gutters:nth-child(2) div.oxd-select-text--after")).click();
    //driver.findElement(By.cssSelector("div[role='listbox'] div:nth-of-type(2)")).click();

    // drop-down user role - Admin bt Xpath
    //driver.findElement(By.xpath("//label[contains(text(),'User Role')]/../..//div[@class='oxd-select-wrapper']")).click();
    //driver.findElement(By.xpath("//div[@role='option']/span[text()='Admin']/parent::*")).click();


    // button Search by CSS
    //driver.findElement(By.cssSelector("button[type='submit']")).click();

    // button Search by Xpath
    //driver.findElement(By.xpath("//button[@type='submit']")).click();


    // button Add by CSS
    //driver.findElement(By.cssSelector("button.oxd-button.oxd-button--medium.oxd-button--secondary[type='button']")).click();

    // button Add by Xpath
    //driver.findElement(By.xpath("//div[@class='orangehrm-header-container']/button")).click();
    driver.quit();
  }
}
