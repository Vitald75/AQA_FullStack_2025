package eu.senla.pages;

import eu.senla.core.Wait;
import eu.senla.data.RecruitmentCandidate;
import org.openqa.selenium.By;

public class AddCandidatePage extends BasePage {

    private String directUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/addCandidate";

//    private final By addRecruitmentButton =
//            By.cssSelector("button.oxd-button.oxd-button--medium.oxd-button--secondary[type='button']");

    private final By firstNameInput = By.name("firstName");
    private final By middleNameInput = By.name("middleName");
    private final By lastNameInput = By.name("lastName");
    private final By vacancyDropDown = By.xpath("//label[text()='Vacancy']/../following::div/div/div");
    private final By listOfVacancies = By.cssSelector("div[role='listbox'] div:nth-of-type(2) span");
    private final By emailInput = By.xpath("//label[text()='Email']/../following::div[1]/input");
    private final By contactNumberInput = By.xpath("//label[text()='Contact Number']/../following::div[1]/input");
    private final By keywordsInput = By.xpath("//label[text()='Keywords']/../following-sibling::div/input");
    private final By notesInput = By.cssSelector("textarea");
    private final By saveButton = By.xpath("//button[@type='submit']");

    private final By confirmationMessage = By.xpath("//div[@id='oxd-toaster_1']//p[text()='Success']");

    public AddCandidatePage() {
        Wait.waitVisibilityOfElementLocated(saveButton);
    }

    public final AddCandidatePage inputFistName(String firstName) {
        Wait.waitVisibilityOfElementLocated(firstNameInput).sendKeys(firstName);
        return this;
    }

    public final AddCandidatePage inputMiddleName(String middleName) {
        Wait.waitVisibilityOfElementLocated(middleNameInput).sendKeys(middleName);
        return this;
    }

    public final AddCandidatePage inputLastName(String lastName) {
        Wait.waitVisibilityOfElementLocated(lastNameInput).sendKeys(lastName);
        return this;
    }

    public final AddCandidatePage chooseVacancy() {
        Wait.waitVisibilityOfElementLocated(vacancyDropDown).click();
        Wait.waitVisibilityOfElementLocated(listOfVacancies).click();
        return this;
    }

    public final AddCandidatePage inputEmail(String email) {
        Wait.waitVisibilityOfElementLocated(emailInput).sendKeys(email);
        return this;
    }

    public final AddCandidatePage inputContactNumber(String contactNumber) {
        Wait.waitVisibilityOfElementLocated(contactNumberInput).sendKeys(contactNumber);
        return this;
    }

    public final AddCandidatePage inputKeywords(String keywords) {
        Wait.waitVisibilityOfElementLocated(keywordsInput).sendKeys(keywords);
        return this;
    }

    public final AddCandidatePage inputNotes(String notes) {
        Wait.waitVisibilityOfElementLocated(notesInput).sendKeys(notes);
        return this;
    }

    public final AddCandidatePage fillNewCandidateForm(RecruitmentCandidate candidate) {
        inputFistName(candidate.getFirstName())
                .inputMiddleName(candidate.getMiddleName())
                .inputLastName(candidate.getLastName())
                .chooseVacancy()
                .inputEmail(candidate.getEmail())
                .inputContactNumber(candidate.getContactNumber())
                .inputKeywords(candidate.getKeywords())
                .inputNotes(candidate.getNotes());
        return this;
    }

    public final AddCandidatePage clickSaveButton() {
        Wait.waitVisibilityOfElementLocated(saveButton).click();
        return this;
    }

    public final AddCandidatePage isConfirmed() {
        Wait.waitVisibilityOfElementLocated(confirmationMessage).isDisplayed();
        return this;
    }


}
