package eu.senla;

import com.github.javafaker.Faker;
import eu.senla.dataUi.RecruitmentCandidate;
import eu.senla.elements.SidePanel;
import eu.senla.pages.recruitment.AddCandidatePage;
import eu.senla.pages.recruitment.RecruitmentPage;
import lombok.SneakyThrows;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


//@Tag("recruitment")
public final class AddRecruitmentCandidateTest extends BaseTest {
    private RecruitmentCandidate candidate;

    //@BeforeEach
    @BeforeTest
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
    @Test (testName = "Успешное добавление кандидата все поля заполнены", groups = {"smoke"})
    public void testPositiveAddRecruitmentCandidate() {

        AddCandidatePage addCandidatePage =
                new SidePanel()
                        .openRecruitmentPage()
                        .clickAddRecruitmentButton()
                        .fillNewCandidateForm(candidate)
                        .clickSaveButton()
                        .isConfirmed();

        Assert.assertTrue(
                addCandidatePage.getCurrentUrl().contains(
                        addCandidatePage.getOwnPageUrl()),
                "Unexpected Url");
    }


    @Test (testName = "Проверка формы добавления кандидата с незаполненными обязательными полями", groups = {"extended"})
    public void testNegativeAddRecruitmentCandidate() {

        AddCandidatePage addCandidatePage = new SidePanel()
                .openRecruitmentPage()
                .clickAddRecruitmentButton()
                .inputMiddleName(candidate.getMiddleName())
                .inputContactNumber(candidate.getContactNumber())
                .inputKeywords(candidate.getKeywords())
                .inputNotes(candidate.getNotes())
                .clickSaveButton()
                .isRequiredFirstName()
                .isRequiredLastName()
                .isRequiredEmail();

        Assert.assertTrue(
                addCandidatePage.getCurrentUrl().contains(
                        addCandidatePage.getOwnPageUrl()),
                "Unexpected Url");

    }


//    @DisplayName("Проверка формы добавления кандидата с невалидным Email")
//    @Tag("extended")
    @Test (testName = "Проверка формы добавления кандидата с невалидным Email", groups = {"extended"})
    public void testNegativeEmailAddRecruitmentCandidate() {

        AddCandidatePage addCandidatePage = new SidePanel()
                .openRecruitmentPage()
                .clickAddRecruitmentButton()
                .fillNewCandidateForm(candidate)
                .inputEmail("@hdg")
                .clickSaveButton()
                .isValidEmail();


        Assert.assertTrue(
                addCandidatePage.getCurrentUrl().contains(
                        addCandidatePage.getOwnPageUrl()),
                "Unexpected Url");

    }

//    @DisplayName("Проверка формы добавления кандидата только c заполненными обязательными полями")
//    @Tag("extended")
    @Test (testName = "Проверка формы добавления кандидата только c заполненными обязательными полями", groups = {"extended"})
    public void testAddRecruitmentCandidateOnlyRequiredFields() {
        AddCandidatePage addCandidatePage = new SidePanel()
                .openRecruitmentPage()
                .clickAddRecruitmentButton()
                .inputFistName(candidate.getFirstName())
                .inputLastName(candidate.getFirstName())
                .inputEmail(candidate.getEmail())
                .clickSaveButton()
                .isConfirmed();

        Assert.assertTrue(
                addCandidatePage.getCurrentUrl().contains(
                        addCandidatePage.getOwnPageUrl()),
                "Unexpected Url");

    }

//    @DisplayName("Проверка отмены добавления кандидата")
//    @Tag("extended")
    @Test (testName = "Проверка отмены добавления кандидата", groups = {"extended"})
    public void testCancelAddRecruitmentCandidate() {

        RecruitmentPage viewCandidatesPage = new SidePanel()
                .openRecruitmentPage()
                .clickAddRecruitmentButton()
                .fillNewCandidateForm(candidate)
                .clickCancelButton();

        Assert.assertTrue(
                viewCandidatesPage.getCurrentUrl().contains(
                        viewCandidatesPage.getOwnPageUrl()),
                "Unexpected Url");


    }

}
