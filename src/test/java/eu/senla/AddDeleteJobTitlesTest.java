package eu.senla;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;


public class AddDeleteJobTitlesTest extends BaseTest {
    @DisplayName("Успешное добавление и удаление 3-х Job Titles")
    @Test
    @Tag("smoke")
    @Order(0)
    public void testAddDeleteJobTitles() {
        successfulLogin();
        final int waitingTime = 6;
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(waitingTime));

        // open Admin page
        driver.findElement(By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']")).click();
        driver.manage().window().maximize();
        wait.until(d -> driver.findElement(By.xpath("//h6[text()='Admin']")).isDisplayed());

        // select dropdown menu Job - Job titles -
        driver.findElement(By.xpath("//span[text()='Job ']")).click();
        wait.until(
                d ->
                        driver
                                .findElement(By.xpath("//a[text()='Job Titles' and @role='menuitem']"))
                                .isDisplayed());
        driver.findElement(By.xpath("//a[text()='Job Titles' and @role='menuitem']")).click();

        // add 3 jobs
        final int jobsCount = 3;
        for (int i = 1; i <= jobsCount; i++) {
            wait.until(d -> driver.findElement(By.xpath("//button[text()=' Add ']")).isDisplayed());
            driver.findElement(By.xpath("//button[text()=' Add ']")).click();
            wait.until(
                    d ->
                            driver
                                    .findElement(By.cssSelector("input.oxd-input.oxd-input--active"))
                                    .isDisplayed());
            driver
                    .findElement(By.cssSelector("div.oxd-form-row input.oxd-input.oxd-input--active"))
                    .sendKeys("Track Driver " + i);

            driver.findElement(By.cssSelector("button[type='submit']")).click();

            wait.until(
                    d ->
                            driver
                                    .findElement(By.xpath("//div[@id='oxd-toaster_1']//p[text()='Success']"))
                                    .isDisplayed());
            assertTrue(driver.findElement(By.xpath("//div[@id='oxd-toaster_1']//p[text()='Success']"))
                    .isDisplayed(), "Unsuccessful attempt");
        }

        // delete 3 jobs
        for (int i = 1; i <= jobsCount; i++) {
            wait.until(
                    d ->
                            driver
                                    .findElement(
                                            By.xpath(
                                                    "//div[contains(text(),'Track Driver')]/../..//i[@class='oxd-icon bi-trash']"))
                                    .isDisplayed());
            driver
                    .findElement(
                            By.xpath(
                                    "//div[contains(text(),'Track Driver')]/../..//i[@class='oxd-icon bi-trash']"))
                    .click();

            wait.until(
                    d -> driver.findElement(By.xpath("//button[text()=' Yes, Delete ']")).isDisplayed());
            driver.findElement(By.xpath("//button[text()=' Yes, Delete ']")).click();
        }

    }
}
