package eu.senla;

import com.github.javafaker.Faker;
import eu.senla.data.RecruitmentCandidate;
import eu.senla.elements.SidePanel;
import eu.senla.pages.AddCandidatePage;
import eu.senla.pages.RecruitmentPage;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public final class AddRecruitmentCandidateTest extends BaseTest {
    private RecruitmentCandidate candidate;

    @BeforeEach
    void generateTestData() {
        Faker faker = new Faker();
        candidate = RecruitmentCandidate.builder()
                        .firstName(faker.name().firstName())
                        .middleName(faker.name().firstName())
                        .lastName(faker.name().lastName())
                        .contactNumber(faker.phoneNumber().subscriberNumber())
                        .email(faker.internet().emailAddress())
                        .keywords(faker.hacker().adjective())
                        .notes(faker.lorem().paragraph(2))
                        .build();
    }


    @SneakyThrows
    @Test
    @DisplayName("Успешное добавление кандидата")
    @Tag("smoke")
    public void testPositiveAddRecruitmentCandidate() {
        String directRecruitmentUrl =
                "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList";

        new SidePanel().openRecruitmentPage();

        AddCandidatePage addCandidatePage =
                new RecruitmentPage()
                        .clickAddRecruitmentButton()
                        .fillNewCandidateForm(candidate)
                        .clickSaveButton()
                        .isConfirmed();
        assertTrue(
                addCandidatePage.getCurrentUrl().contains(
                        "https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/addCandidate"),
                "Unexpected Url");

    }

  //
  //  @DisplayName("Проверка формы добавления кандидата")
  //  @ParameterizedTest(name = "Проверка формы добавления кандидата с {0}")
  //  @MethodSource("provideParameters")
  //  @Tag("extended")
  //  public void testNegativeAddRecruitmentCandidate(
  //      String description,
  //      String firstName,
  //      String middleName,
  //      String lastName,
  //      String email,
  //      String phoneNumber,
  //      String keywords,
  //      String notes,
  //      String flag) {
  //
  //    successfulLogin();
  //
  //    driver
  //        .navigate()
  //        .to("https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/addCandidate");
  //    wait.until(d -> driver.findElement(By.cssSelector("button[type='submit']")).isDisplayed());
  //
  //    driver.findElement(By.name("firstName")).sendKeys(firstName);
  //    driver.findElement(By.name("middleName")).sendKeys(middleName);
  //    driver.findElement(By.name("lastName")).sendKeys(lastName);
  //
  //    driver.findElement(By.xpath("//label[text()='Vacancy']/../following::div/div/div")).click();
  //
  //    // driver.findElement(By.xpath("//span[text()='Software Engineer']")).click();
  //    driver.findElement(By.cssSelector("div[role='listbox'] div:nth-of-type(2) span")).click();
  //    driver
  //        .findElement(By.xpath("//label[text()='Email']/../following::div[1]/input"))
  //        .sendKeys(email);
  //    driver
  //        .findElement(By.xpath("//label[text()='Contact Number']/../following::div[1]/input"))
  //        .sendKeys(phoneNumber);
  //
  //    // field keywords
  //    driver
  //        .findElement(By.xpath("//label[text()='Keywords']/../following-sibling::div/input"))
  //        .sendKeys(keywords);
  //
  //    // text area
  //    driver.findElement(By.xpath("//textarea")).sendKeys(notes);
  //    driver.findElement(By.xpath("//button[@type='submit' and text()=' Save ']")).click();
  //
  //    switch (flag) {
  //      case ("emptyFirstName"):
  //        wait.until(
  //            d ->
  //                driver
  //                    .findElement(
  //                        By.xpath(
  //
  // "//div/input[@name='firstName']/../following-sibling::span[text()='Required']"))
  //                    .isDisplayed());
  //
  //        assertTrue(
  //            driver
  //                .findElement(
  //                    By.xpath(
  //
  // "//div/input[@name='firstName']/../following-sibling::span[text()='Required']"))
  //                .isDisplayed(),
  //            "Field FirstName is not required");
  //        break;
  //
  //      case ("emptyLastName"):
  //        wait.until(
  //            d ->
  //                driver
  //                    .findElement(
  //                        By.xpath(
  //
  // "//div/input[@name='lastName']/../following-sibling::span[text()='Required']"))
  //                    .isDisplayed());
  //        assertTrue(
  //            driver
  //                .findElement(
  //                    By.xpath(
  //
  // "//div/input[@name='lastName']/../following-sibling::span[text()='Required']"))
  //                .isDisplayed(),
  //            "Field LastName is not required");
  //        break;
  //
  //      case ("emptyEmail"):
  //        wait.until(
  //            d ->
  //                driver
  //                    .findElement(
  //                        By.xpath(
  //
  // "//div/label[text()='Email']/../following-sibling::span[text()='Required']"))
  //                    .isDisplayed());
  //
  //        assertTrue(
  //            driver
  //                .findElement(
  //                    By.xpath(
  //
  // "//div/label[text()='Email']/../following-sibling::span[text()='Required']"))
  //                .isDisplayed(),
  //            "Field LastName is not required");
  //        break;
  //
  //      case ("incorrectEmail"):
  //        wait.until(
  //            d ->
  //                driver
  //                    .findElement(
  //                        By.xpath(
  //                            "//div/label[text()='Email']/../following-sibling::span["
  //                                + "text()='Expected format: admin@example.com']"))
  //                    .isDisplayed());
  //
  //        assertTrue(
  //            driver
  //                .findElement(
  //                    By.xpath(
  //                        "//div/label[text()='Email']/../following-sibling::span["
  //                            + "text()='Expected format: admin@example.com']"))
  //                .isDisplayed(),
  //            "Field LastName is not required");
  //        break;
  //
  //      default:
  //        assertEquals(
  //            "https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/addCandidate",
  //            driver.getCurrentUrl(),
  //            "URL doesn't match");
  //        break;
  //    }
  //  }
  //
  //  private static Stream<Arguments> provideParameters() {
  //    return Stream.of(
  //        Arguments.of(
  //            "пустым FirstName",
  //            "",
  //            "Ilovich",
  //            "Frankenstain",
  //            "876@mail.com",
  //            "3453705123",
  //            "qa,hr,pm",
  //            "some notes",
  //            "emptyFirstName"),
  //        Arguments.of(
  //            "пустым LastName",
  //            "John",
  //            "Ilovich",
  //            "",
  //            "234@mail.com",
  //            "3453705123",
  //            "qa,hr,pm",
  //            "some notes",
  //            "emptyLastName"),
  //        Arguments.of(
  //            "пустым Email",
  //            "John",
  //            "Ilovich",
  //            "Frankenstain",
  //            "",
  //            "3453705123",
  //            "qa,hr,pm",
  //            "some notes",
  //            "emptyEmail"),
  //        Arguments.of(
  //            "невалидным Email",
  //            "John",
  //            "Ilovich",
  //            "Frankenstain",
  //            "@mail",
  //            "3453705123",
  //            "qa,hr,pm",
  //            "some notes",
  //            "incorrectEmail"));
  //  }
}
