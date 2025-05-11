package eu.senla;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public final class AddRecruitmentCandidateTest extends BaseTest {

    @Test
    @DisplayName("Успешное добавление кандидата")
    @Tag("smoke")
    public void testPositiveAddRecruitmentCandidate() {
        final int waitingTime = 6;
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(waitingTime));
        successfulLogin();

        // open Recruitment page
        driver
                .findElement(By.xpath("//a[@href='/web/index.php/recruitment/viewRecruitmentModule']"))
                .click();
        driver.manage().window().maximize();
        wait.until(d -> driver.findElement(By.xpath("//h5[text()='Candidates']")).isDisplayed());

        // click Add button
        driver.findElement(By.xpath("//button[text()=' Add ']")).click();
        wait.until(d -> driver.findElement(By.cssSelector("button[type='submit']")).isDisplayed());

        // fill the new candidate form
        final int length = 10;
        boolean useLetters = true;
        boolean useNumbers = false;
        String name = RandomStringUtils.random(length, useLetters, useNumbers);

        driver.findElement(By.name("firstName")).sendKeys(name);
        driver.findElement(By.name("middleName")).sendKeys(name);
        driver.findElement(By.name("lastName")).sendKeys(name);

        driver.findElement(By.xpath("//label[text()='Vacancy']/../following::div/div/div")).click();

        // driver.findElement(By.xpath("//span[text()='Software Engineer']")).click();
        driver.findElement(By.cssSelector("div[role='listbox'] div:nth-of-type(2) span")).click();
        driver
                .findElement(By.xpath("//label[text()='Email']/../following::div[1]/input"))
                .sendKeys("test@mail.com");
        driver
                .findElement(By.xpath("//label[text()='Contact Number']/../following::div[1]/input"))
                .sendKeys("+375-29-555-44-33");

        // field keywords
        driver
                .findElement(By.xpath("//label[text()='Keywords']/../following-sibling::div/input"))
                .sendKeys("keyword, smart, social skilled");

        // text area
        driver.findElement(By.xpath("//textarea")).sendKeys("some notes about candidate");
        driver.findElement(By.xpath("//button[@type='submit' and text()=' Save ']")).click();

    }

    @DisplayName("Проверка формы добавления кандидата")
    @ParameterizedTest(name = "Проверка формы добавления кандидата с {0}")
    @MethodSource("provideParameters")
    @Tag("extended")
    public void testNegativeAddRecruitmentCandidate(String description, String firstName, String middleName, String lastName, String email,
                                                    String phoneNumber, String keywords, String notes, String flag) {
        final int waitingTime = 6;
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(waitingTime));
        successfulLogin();

        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/addCandidate");
        driver.navigate().refresh();
        wait.until(d -> driver.findElement(By.cssSelector("button[type='submit']")).isDisplayed());

        driver.findElement(By.name("firstName")).sendKeys(firstName);
        driver.findElement(By.name("middleName")).sendKeys(middleName);
        driver.findElement(By.name("lastName")).sendKeys(lastName);

        driver.findElement(By.xpath("//label[text()='Vacancy']/../following::div/div/div")).click();

        // driver.findElement(By.xpath("//span[text()='Software Engineer']")).click();
        driver.findElement(By.cssSelector("div[role='listbox'] div:nth-of-type(2) span")).click();
        driver
                .findElement(By.xpath("//label[text()='Email']/../following::div[1]/input"))
                .sendKeys(email);
        driver
                .findElement(By.xpath("//label[text()='Contact Number']/../following::div[1]/input"))
                .sendKeys(phoneNumber);

        // field keywords
        driver
                .findElement(By.xpath("//label[text()='Keywords']/../following-sibling::div/input"))
                .sendKeys(keywords);

        // text area
        driver.findElement(By.xpath("//textarea")).sendKeys(notes);
        driver.findElement(By.xpath("//button[@type='submit' and text()=' Save ']")).click();

        switch (flag) {
            case ("emptyFirstName") :
                wait.until(d -> driver
                        .findElement(By.xpath("//div/input[@name='firstName']/../following-sibling::span[text()='Required']"))
                        .isDisplayed());

                        assertTrue(driver
                                .findElement(By.xpath("//div/input[@name='firstName']/../following-sibling::span[text()='Required']"))
                                .isDisplayed(), "Field FirstName is not required");
                break;

            case ("emptyLastName") :
                wait.until(d -> driver
                        .findElement(By.xpath("//div/input[@name='lastName']/../following-sibling::span[text()='Required']"))
                        .isDisplayed());
                assertTrue(driver.findElement(By.xpath("//div/input[@name='lastName']/../following-sibling::span[text()='Required']"))
                        .isDisplayed(), "Field LastName is not required");
                break;

            case ("emptyEmail") :
                wait.until(d -> driver.
                        findElement(By.xpath("//div/label[text()='Email']/../following-sibling::span[text()='Required']"))
                        .isDisplayed());

                assertTrue(driver.findElement(By.xpath("//div/label[text()='Email']/../following-sibling::span[text()='Required']"))
                        .isDisplayed(), "Field LastName is not required");
                break;

            case ("incorrectEmail") :
                wait.until(d -> driver
                        .findElement(By.xpath("//div/label[text()='Email']/../following-sibling::span["
                                + "text()='Expected format: admin@example.com']"))
                        .isDisplayed());

                assertTrue(driver
                        .findElement(By.xpath("//div/label[text()='Email']/../following-sibling::span["
                                + "text()='Expected format: admin@example.com']"))
                        .isDisplayed(), "Field LastName is not required");
                break;

            default:
                assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/addCandidate",
                        driver.getCurrentUrl(), "URL doesn't match");
                break;
        }
    }

    private static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of("пустым FirstName", "", "Ilovich", "Frankenstain", "876@mail.com", "3453705123",
                        "qa,hr,pm", "some notes", "emptyFirstName"),
                Arguments.of("пустым LastName", "John", "Ilovich", "", "234@mail.com", "3453705123",
                        "qa,hr,pm", "some notes", "emptyLastName"),
                Arguments.of("пустым Email", "John", "Ilovich", "Frankenstain", "", "3453705123",
                        "qa,hr,pm", "some notes", "emptyEmail"),
                Arguments.of("невалидным Email", "John", "Ilovich", "Frankenstain", "@mail", "3453705123",
                        "qa,hr,pm", "some notes", "incorrectEmail")
        );
    }

}
