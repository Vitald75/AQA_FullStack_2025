package eu.senla;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class AppTest extends BaseTest{

  private void loginPage() {
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    final int waitingTime = 6;
    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(waitingTime));
    wait.until(d -> driver.findElement(By.name("username"))
            .isDisplayed());

    driver.findElement(By.name("username")).sendKeys("Admin");
    driver.findElement(By.name("password")).sendKeys("admin123");
    driver.findElement(By.cssSelector("button[type='submit']")).click();
    wait.until(d -> driver.findElement(By.xpath("//h6[text()='Dashboard']"))
            .isDisplayed());
  }

  @Test
  public void testAddRecruitmentCandidate() {
   // init and login
    //WebDriver driver = new ChromeDriver();
//    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//
    final int waitingTime = 6;
    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(waitingTime));
//    wait.until(d -> driver.findElement(By.name("username"))
//            .isDisplayed());
//
//    driver.findElement(By.name("username")).sendKeys("Admin");
//    driver.findElement(By.name("password")).sendKeys("admin123");
//    driver.findElement(By.cssSelector("button[type='submit']")).click();
//    wait.until(d -> driver.findElement(By.xpath("//h6[text()='Dashboard']"))
//            .isDisplayed());

    loginPage();
    // open Recruitment page
    driver.findElement(By.xpath("//a[@href='/web/index.php/recruitment/viewRecruitmentModule']")).click();
    driver.manage().window().maximize();
    wait.until(d -> driver.findElement(By.xpath("//h5[text()='Candidates']"))
            .isDisplayed());

    // click Add button
    driver.findElement(By.xpath("//button[text()=' Add ']")).click();
    wait.until(d -> driver.findElement(By.cssSelector("button[type='submit']"))
            .isDisplayed());

    // fill the new candidate form
    driver.findElement(By.name("firstName")).sendKeys("Twain");
    driver.findElement(By.name("middleName")).sendKeys("Ivanovich");
    driver.findElement(By.name("lastName")).sendKeys("Mark");

    driver.findElement(By.xpath("//label[text()='Vacancy']/../following::div/div/div")).click();

    //driver.findElement(By.xpath("//span[text()='Software Engineer']")).click();
    driver.findElement(By.cssSelector("div[role='listbox'] div:nth-of-type(2) span")).click();
    driver.findElement(By.xpath("//label[text()='Email']/../following::div[1]/input")).sendKeys("test@mail.com");
    driver.findElement(By.xpath("//label[text()='Contact Number']/../following::div[1]/input")).sendKeys("+375-29-555-44-33");

    // field keywords
    driver.findElement(By.xpath("//label[text()='Keywords']/../following-sibling::div/input")).sendKeys("keyword, smart, social skilled");

    // text area
    driver.findElement(By.xpath("//textarea")).sendKeys("some notes about candidate");
    //driver.findElement(By.xpath("button[@type='submit' and text()=' Save ']")).clear();


  }

  @Test
  public void testAddJobTitles() {
    //init and login
    //WebDriver driver = new ChromeDriver();
    //driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    loginPage();
    final int waitingTime = 6;
    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(waitingTime));
//    wait.until(d -> driver.findElement(By.name("username"))
//            .isDisplayed());
//
//    driver.findElement(By.name("username")).sendKeys("Admin");
//    driver.findElement(By.name("password")).sendKeys("admin123");
//    driver.findElement(By.cssSelector("button[type='submit']")).click();
//    wait.until(d -> driver.findElement(By.xpath("//h6[text()='Dashboard']"))
//            .isDisplayed());

    // open Admin page
    driver.findElement(By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']")).click();
    driver.manage().window().maximize();
    wait.until(d -> driver.findElement(By.xpath("//h6[text()='Admin']"))
            .isDisplayed());

    //select dropdown menu Job - Job titles -
    driver.findElement(By.xpath("//span[text()='Job ']")).click();
    wait.until(d -> driver.findElement(By.xpath("//a[text()='Job Titles' and @role='menuitem']"))
            .isDisplayed());
    driver.findElement(By.xpath("//a[text()='Job Titles' and @role='menuitem']")).click();


    // add 3 jobs
    final int jobsCount = 3;
    for (int i = 1; i <= jobsCount; i++) {
      wait.until(d -> driver.findElement(By.xpath("//button[text()=' Add ']"))
              .isDisplayed());
      driver.findElement(By.xpath("//button[text()=' Add ']")).click();
      wait.until(d -> driver.findElement(By.cssSelector("input.oxd-input.oxd-input--active"))
              .isDisplayed());
      driver.findElement(By.cssSelector("div.oxd-form-row input.oxd-input.oxd-input--active")).sendKeys("Track Driver " + i);

      driver.findElement(By.cssSelector("button[type='submit']")).click();
    }

    // delete 3 jobs
    for (int i = 1; i <= jobsCount; i++) {
      wait.until(d -> driver.findElement(By.xpath("//div[contains(text(),'Track Driver')]/../..//i[@class='oxd-icon bi-trash']"))
              .isDisplayed());
      driver.findElement(By.xpath("//div[contains(text(),'Track Driver')]/../..//i[@class='oxd-icon bi-trash']")).click();

      wait.until(d -> driver.findElement(By.xpath("//button[text()=' Yes, Delete ']"))
              .isDisplayed());
      driver.findElement(By.xpath("//button[text()=' Yes, Delete ']")).click();
    }

    //driver.quit();
  }

  @Test
  public void testPimAddEmployee() {
    final int pause = 4;
    //WebDriver driver = new ChromeDriver();
    //driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

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

    //driver.quit();
  }
}
