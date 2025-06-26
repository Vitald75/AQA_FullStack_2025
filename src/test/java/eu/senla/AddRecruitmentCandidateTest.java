package eu.senla;

import com.github.javafaker.Faker;
import eu.senla.dataUi.RecruitmentCandidate;
import eu.senla.elements.SidePanel;
import eu.senla.pages.recruitment.AddCandidatePage;
import eu.senla.pages.recruitment.RecruitmentPage;
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
    @DisplayName("Успешное добавление кандидата все поля заполнены")
    @Tag("smoke")
    public void testPositiveAddRecruitmentCandidate() {

        AddCandidatePage addCandidatePage =
                new SidePanel()
                        .openRecruitmentPage()
                        .clickAddRecruitmentButton()
                        .fillNewCandidateForm(candidate)
                        .clickSaveButton()
                        .isConfirmed();

        assertTrue(
                addCandidatePage.getCurrentUrl().contains(
                        addCandidatePage.getOwnPageUrl()),
                "Unexpected Url");
    }


    @DisplayName("Проверка формы добавления кандидата с незаполненными обязательными полями")
    @Tag("extended")
    @Test
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

        assertTrue(
                addCandidatePage.getCurrentUrl().contains(
                        addCandidatePage.getOwnPageUrl()),
                "Unexpected Url");

    }


    @DisplayName("Проверка формы добавления кандидата с невалидным Email")
    @Tag("extended")
    @Test
    public void testNegativeEmailAddRecruitmentCandidate() {

        AddCandidatePage addCandidatePage = new SidePanel()
                .openRecruitmentPage()
                .clickAddRecruitmentButton()
                .fillNewCandidateForm(candidate)
                .inputEmail("@hdg")
                .clickSaveButton()
                .isValidEmail();


        assertTrue(
                addCandidatePage.getCurrentUrl().contains(
                        addCandidatePage.getOwnPageUrl()),
                "Unexpected Url");

    }

    @DisplayName("Проверка формы добавления кандидата только c заполненными обязательными полями")
    @Tag("extended")
    @Test
    public void testAddRecruitmentCandidateOnlyRequiredFields() {
        AddCandidatePage addCandidatePage = new SidePanel()
                .openRecruitmentPage()
                .clickAddRecruitmentButton()
                .inputFistName(candidate.getFirstName())
                .inputLastName(candidate.getFirstName())
                .inputEmail(candidate.getEmail())
                .clickSaveButton()
                .isConfirmed();

        assertTrue(
                addCandidatePage.getCurrentUrl().contains(
                        addCandidatePage.getOwnPageUrl()),
                "Unexpected Url");

    }

    @DisplayName("Проверка отмены добавления кандидата")
    @Tag("extended")
    @Test
    public void testCancelAddRecruitmentCandidate() {

        RecruitmentPage viewCandidatesPage = new SidePanel()
                .openRecruitmentPage()
                .clickAddRecruitmentButton()
                .fillNewCandidateForm(candidate)
                .clickCancelButton();

        assertTrue(
                viewCandidatesPage.getCurrentUrl().contains(
                        viewCandidatesPage.getOwnPageUrl()),
                "Unexpected Url");


    }

}
