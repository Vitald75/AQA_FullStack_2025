package eu.senla;

import com.github.javafaker.Faker;
import eu.senla.data.JobTitle;
import eu.senla.elements.SidePanel;
import eu.senla.pages.admin.AdminViewJobTitlesListPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class AddDeleteJobTitlesTest extends BaseTest {

    //private JobTitle jobTitle;

    //@BeforeEach
    JobTitle generateTestData() {
        Faker faker = new Faker();
        JobTitle jobTitle = JobTitle.builder()
                .jobTitle(faker.job().title())
                .jobDescription(faker.job().keySkills())
                .note(faker.lorem().paragraph(2))
                .build();
        return jobTitle;
    }

    public void addJobTitle(JobTitle jobTitle) {
        AdminViewJobTitlesListPage jobTitlesListPage =
                new SidePanel().openAdminPage()
                        .openJobMenu()
                        .clickJobTitlesMenuItem()
                        .openAddJobTitlePage()
                        .inputJobTitle(jobTitle.getJobTitle())
                        .inputJobDescription(jobTitle.getJobDescription())
                        .inputJobNote(jobTitle.getNote())
                        .clickSaveButton()
                        .isConfirmed();

        assertTrue(jobTitlesListPage.checkIfJobTitleExists(jobTitle.getJobTitle()), "Не добавлен в список");
    }

    public void deleteJobTitle(JobTitle jobTitle) {
        AdminViewJobTitlesListPage jobTitlesListPage =
                new SidePanel().openAdminPage()
                        .openJobMenu()
                        .clickJobTitlesMenuItem()
                        .deleteJobTitle(jobTitle.getJobTitle())
                        .confirmDelete()
                        .isConfirmed();

        assertFalse(jobTitlesListPage.checkIfJobTitleExists(jobTitle.getJobTitle()), "Не удален из списка");
    }


    //Добавление и удаление трех можно сделать через repeatedTest оставив BeforeEach для generateTestData, хотя смысла в этом не вижу
    @RepeatedTest(value = 1, name = "{displayName} - повтор {currentRepetition}/{totalRepetitions}")
    @DisplayName("Успешное добавление и удаление n Job Title")
    public void testPositiveAddJobTitle() {

        final int repetitions = 3;
        JobTitle[] jobTitles = new JobTitle[repetitions];
        for (int i = 0; i < repetitions; i++) {
            jobTitles[i] = generateTestData();
        }

        for (int i = 0; i < repetitions; i++) {
            addJobTitle(jobTitles[i]);
        }

        for (int i = 0; i < repetitions; i++) {
            deleteJobTitle(jobTitles[i]);
        }
    }
}
