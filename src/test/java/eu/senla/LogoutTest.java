package eu.senla;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class LogoutTest extends BaseTest {

    @DisplayName("Проверка успешного выхода из учетной записи")
    @Tag("smoke")
    @Test
    public void testLogout() {
        final int waitingTime = 6;
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(waitingTime));
        successfulLogin();

        driver.findElement(By.cssSelector("span.oxd-userdropdown-tab")).click();
        driver.findElement(By.cssSelector("a[href='/web/index.php/auth/logout']")).click();

        wait.until(d -> driver.findElement(By.xpath("//button[text()=' Login ']")).isDisplayed());

        assertAll(
                () -> assertTrue(
                driver.findElement(By.xpath("//button[text()=' Login ']")).isDisplayed(),
                "Unsuccessful logout"),
                () -> assertTrue(
                        driver.findElement(By.xpath("//button[text()=' Login ']")).isDisplayed(),
                        "Unsuccessful logout"),
                () -> assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login",
                        driver.getCurrentUrl(), "URL doesn't match")
        );
    }
}
