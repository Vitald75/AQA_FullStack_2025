package eu.senla;

import com.github.javafaker.Faker;
import eu.senla.data.RecruitmentCandidate;
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
    @DisplayName("Проверка формы добавления кандидата")
    @Tag("extended")
    @Test
    public void testNegativeAddRecruitmentCandidate() {

        new SidePanel().openRecruitmentPage();

        AddCandidatePage addCandidatePage = new RecruitmentPage()
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
                        "https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/addCandidate"),
                "Unexpected Url");
    }

}
