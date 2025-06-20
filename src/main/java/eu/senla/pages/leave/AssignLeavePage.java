package eu.senla.pages.leave;

import eu.senla.core.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class AssignLeavePage {

    private final By employeeNameInput = By.xpath("//div[@class='oxd-autocomplete-text-input--before']/following::input[1]");
    private final By leaveTypeDropdown = By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']");
    private final By fromDateInput = By.xpath("//div[@class='oxd-autocomplete-text-input--before']/following::input[2]");
    private final By toDateInput = By.xpath("//div[@class='oxd-autocomplete-text-input--before']/following::input[3]");
    private final By commentsInput = By.xpath("//textarea");
    private final By assingButton = By.xpath("//button[@type='submit']");
    private final By confirmationMessage = By.id("oxd-toaster_1");


    public final AssignLeavePage inputEmployeeName(String employeeName) {
        Wait.waitVisibilityOfElementLocated(employeeNameInput).sendKeys(employeeName);
        return this;
    }

    public final AssignLeavePage inputDateFrom(String date) {
        Wait.waitVisibilityOfElementLocated(fromDateInput).sendKeys(date);
        return new AssignLeavePage();
    }

    public final AssignLeavePage inputDateTo(String date) {
        Wait.waitVisibilityOfElementLocated(toDateInput).sendKeys(Keys.CONTROL + "a");
        Wait.waitVisibilityOfElementLocated(toDateInput).sendKeys(Keys.DELETE);
        Wait.waitVisibilityOfElementLocated(toDateInput).sendKeys(date);
        return new AssignLeavePage();
    }

    public final AssignLeavePage selectEmployee(String fullName) {
        By employeeItemFromListbox = By.xpath("//span[text()='" + fullName + "']");
        inputEmployeeName(fullName);
        Wait.waitVisibilityOfElementLocated(employeeItemFromListbox).click();
        return this;
    }

    public final AssignLeavePage selectLeaveType(String leaveType) {
        By leaveTypeFromListbox = By.xpath("//span[text()='" + leaveType + "']");
        Wait.waitVisibilityOfElementLocated(leaveTypeDropdown).click();
        Wait.waitVisibilityOfElementLocated(leaveTypeFromListbox).click();
        return this;
    }

    public final AssignLeavePage clickAssignButton() {
        Wait.waitVisibilityOfElementLocated(assingButton).click();
        return this;
    }

    public final AssignLeavePage isConfirmed() {
        Wait.waitVisibilityOfElementLocated(confirmationMessage).isDisplayed();
        return this;
    }
}
