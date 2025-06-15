package eu.senla.pages.recruitment;

import eu.senla.core.Wait;
import eu.senla.data.RecruitmentCandidate;
import eu.senla.pages.BasePage;
import lombok.Getter;
import org.openqa.selenium.By;

public class AddCandidatePage extends BasePage {

    @Getter
    private String ownPageUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/addCandidate";

    private final By firstNameInput = By.name("firstName");
    private final By isRequiredFirstName = By.xpath("//input[@name='firstName']/ancestor"
            + "::div[@class='oxd-input-group oxd-input-field-bottom-space']/span[text()='Required']");
    private final By middleNameInput = By.name("middleName");
    private final By lastNameInput = By.name("lastName");
    private final By isRequiredLastName = By.xpath("//input[@name='lastName']/ancestor"
            + "::div[@class='oxd-input-group oxd-input-field-bottom-space']/span[text()='Required']");

    private final By vacancyDropDown = By.xpath("//label[text()='Vacancy']/ancestor::div[2]//i");
    private final By listOfVacancies = By.cssSelector("div[role='listbox'] div:nth-of-type(2) span");
    private final By emailInput = By.xpath("//label[text()='Email']/ancestor::div[2]/div/input");
    private final By isRequiredEmail = By.xpath("//label[text()='Email']/ancestor::div[2]//span");

    private final By contactNumberInput = By.xpath("//label[text()='Contact Number']/ancestor::div[2]//input");
    private final By keywordsInput = By.xpath("//label[text()='Keywords']/ancestor::div[2]//input");
    private final By notesInput = By.cssSelector("textarea");
    private final By saveButton = By.xpath("//button[@type='submit']");
    private final By cancelButton = By.xpath("//button[text()=' Cancel ']");

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

    public final AddCandidatePage isRequiredLastName() {
        Wait.waitVisibilityOfElementLocated(isRequiredLastName).isDisplayed();
        return this;
    }

    public final AddCandidatePage isRequiredFirstName() {
        Wait.waitVisibilityOfElementLocated(isRequiredFirstName).isDisplayed();
        return this;
    }

    public final AddCandidatePage isRequiredEmail() {
        Wait.waitVisibilityOfElementLocated(isRequiredEmail).isDisplayed();
        return this;
    }

    public final RecruitmentPage clickCancelButton() {
        Wait.waitVisibilityOfElementLocated(cancelButton).click();
        return new RecruitmentPage();
    }

}
