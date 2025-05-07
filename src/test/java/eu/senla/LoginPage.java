package eu.senla;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPage extends BaseTest{

    @DisplayName("Проверка успешного логина")
    @Tag("Smoke")
    @Test
    public void testPositiveLoginPage() {
        //WebDriver driver = new ChromeDriver();
        //driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(d -> driver.findElement(By.name("username"))
                .isDisplayed());

        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // open admin page
        wait.until(d -> driver.findElement(By.xpath("//h6[text()='Dashboard']"))
                .isDisplayed());

        assertTrue(driver.findElement(By.xpath("//h6[text()='Dashboard']"))
                .isDisplayed(), "Login failed");


    }

    @Test
    @DisplayName("Проверка неуспешного логина")
    @Tag("Negative")
    public void testNegativeLoginPage() {
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(d -> driver.findElement(By.name("username"))
                .isDisplayed());

        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // open admin page
        wait.until(d -> driver.findElement(By.xpath("//h6[text()='Dashboard']"))
                .isDisplayed());

        assertTrue(driver.findElement(By.xpath("//h6[text()='Dashboard']"))
                .isDisplayed(), "Login failed");

    }


}
