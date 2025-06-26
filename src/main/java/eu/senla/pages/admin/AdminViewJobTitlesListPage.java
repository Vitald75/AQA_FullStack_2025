package eu.senla.pages.admin;

import eu.senla.core.Wait;
import eu.senla.pages.BasePage;
import org.openqa.selenium.By;

public class AdminViewJobTitlesListPage extends BasePage {

    private final By addJobTitleButton = By.xpath("//button[text()=' Add ']");
    private final By labelJobTitles = By.xpath("//h6[text()='Job Titles']");
    private final By deleteConfirmationYes = By.xpath("//button[text()=' Yes, Delete ']");
    private final By confirmationMessage = By.xpath("//div[@id='oxd-toaster_1']//p[text()='Success']");


    public final AddJobTitlePage openAddJobTitlePage() {
        Wait.waitVisibilityOfElementLocated(addJobTitleButton).click();
        return new AddJobTitlePage();
    }

    public final boolean checkIfJobTitleExists(String jobTitle) {
        By jobTitleExists = By.xpath("//div[contains(text(),'" + jobTitle + "')]");
        return isElementDisplayed(jobTitleExists);
    }

    public final AdminViewJobTitlesListPage deleteJobTitle(String jobTitle) {
        By deleteActionButton = By.xpath("//div[contains(text(),'" + jobTitle + "')]"
                + "/parent::*//following-sibling::div//i[@class='oxd-icon bi-trash']");
        Wait.waitVisibilityOfElementLocated(deleteActionButton).click();
        return this;
    }

    public final AdminViewJobTitlesListPage confirmDelete() {
        Wait.waitVisibilityOfElementLocated(deleteConfirmationYes).click();
        return new AdminViewJobTitlesListPage();
    }

    public final AdminViewJobTitlesListPage isConfirmed() {
        Wait.waitVisibilityOfElementLocated(confirmationMessage).isDisplayed();
        return this;
    }

}
