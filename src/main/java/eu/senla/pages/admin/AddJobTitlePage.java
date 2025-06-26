package eu.senla.pages.admin;

import eu.senla.core.Wait;
import eu.senla.pages.BasePage;
import org.openqa.selenium.By;

public class AddJobTitlePage extends BasePage {

    private final By jobTitleField = By.cssSelector("div.oxd-form-row input.oxd-input.oxd-input--active");
    private final By jobDescriptionField = By.xpath("//textarea[@placeholder='Type description here']");
    private final By jobNoteField = By.xpath("//textarea[@placeholder='Add note']");
    private final By confirmationMessage = By.xpath("//div[@id='oxd-toaster_1']//p[text()='Success']");
    private final By saveButton = By.cssSelector("button[type='submit']");

    public final AddJobTitlePage inputJobTitle(String jobTitle) {
        Wait.waitVisibilityOfElementLocated(jobTitleField).sendKeys(jobTitle);
        return this;
    }

    public final AddJobTitlePage inputJobDescription(String jobDescription) {
        Wait.waitVisibilityOfElementLocated(jobDescriptionField).sendKeys(jobDescription);
        return this;
    }

    public final AddJobTitlePage inputJobNote(String jobNote) {
        Wait.waitVisibilityOfElementLocated(jobNoteField).sendKeys(jobNote);
        return this;
    }

    public final AddJobTitlePage clickSaveButton() {
        Wait.waitVisibilityOfElementLocated(saveButton).click();
        return this;
    }

    public final AdminViewJobTitlesListPage isConfirmed() {
        Wait.waitVisibilityOfElementLocated(confirmationMessage).isDisplayed();
        return new AdminViewJobTitlesListPage();
    }

}
