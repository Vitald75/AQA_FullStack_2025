package eu.senla.pages.leave;

import eu.senla.core.ConstantsClass;
import eu.senla.core.ReadPropertiesFile;
import eu.senla.core.Wait;
import eu.senla.pages.BasePage;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class AssignLeavePage extends BasePage {

    @Getter
    private String ownPageUrl = ReadPropertiesFile.getProperty("MAIN_URL") + ConstantsClass.WEB_EP + ConstantsClass.ASSIGN_LEAVE_URL;

    private final By employeeNameInput = By.xpath("//div[@class='oxd-autocomplete-text-input--before']/following::input[1]");
    private final By leaveTypeDropdown = By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']");
    private final By fromDateInput = By.xpath("//div[@class='oxd-autocomplete-text-input--before']/following::input[2]");
    private final By toDateInput = By.xpath("//div[@class='oxd-autocomplete-text-input--before']/following::input[3]");
    private final By commentsInput = By.xpath("//textarea");
    private final By assingButton = By.xpath("//button[@type='submit']");
    private final By confirmationMessage = By.id("oxd-toaster_1");
    private final By notEnoughBalance = By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-leave-balance-text --error']");
    private final By wrongDatesAlert = By.xpath("//span[text()='To date should be after from date']");

    private final By employeeNameRequired = By.xpath("//label[text()='Employee Name']/parent::div/following-sibling::span[text()='Required']");
    private final By leaveTypeRequired = By.xpath("//label[text()='Leave Type']/parent::div/following-sibling::span[text()='Required']");
    private final By dateFromRequired = By.xpath("//label[text()='From Date']/parent::div/following-sibling::span[text()='Required']");
    private final By dateToRequired = By.xpath("//label[text()='To Date']/parent::div/following-sibling::span[text()='Required']");

    //div[role='document'] //button[text()=' Ok ']
    ////p[@class='oxd-text oxd-text--p orangehrm-leave-balance-text --error']
    ///

    public final AssignLeavePage inputEmployeeName(String employeeName) {
        Wait.waitVisibilityOfElementLocated(employeeNameInput).sendKeys(employeeName);
        return this;
    }

    public final AssignLeavePage inputDateFrom(String date) {
        Wait.waitVisibilityOfElementLocated(fromDateInput).sendKeys(date);
        return this;
    }

    public final AssignLeavePage inputDateTo(String date) {
        Wait.waitVisibilityOfElementLocated(toDateInput).sendKeys(Keys.CONTROL + "a");
        Wait.waitVisibilityOfElementLocated(toDateInput).sendKeys(Keys.DELETE);
        Wait.waitVisibilityOfElementLocated(toDateInput).sendKeys(date);
        return this;
    }

    public final AssignLeavePage inputComments(String comments) {
        Wait.waitVisibilityOfElementLocated(commentsInput).sendKeys(comments);
        return this;
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

    public final boolean isAssignButtonDisabled() {
        return !(Wait.waitVisibilityOfElementLocated(assingButton).isEnabled());
    }


    public final AssignLeavePage clickAssignButton() {
        Wait.waitVisibilityOfElementLocated(assingButton).click();
        return this;
    }

    public final Boolean isConfirmed() {
        return Wait.waitVisibilityOfElementLocated(confirmationMessage).isDisplayed();
    }

    public final AssignLeavePage isNotEnoughBalance() {
        Wait.waitVisibilityOfElementLocated(notEnoughBalance).isDisplayed();
        return this;
    }

    public final boolean isWrongDates() {
        return Wait.waitVisibilityOfElementLocated(wrongDatesAlert).isDisplayed();
    }

    public final AssignLeavePage isEmployeeNameRequired() {
        Wait.waitVisibilityOfElementLocated(employeeNameRequired).isDisplayed();
        return this;
    }

    public final AssignLeavePage isLeaveTypeRequired() {
        Wait.waitVisibilityOfElementLocated(leaveTypeRequired).isDisplayed();
        return this;
    }

    public final AssignLeavePage isFromDateRequired() {
        Wait.waitVisibilityOfElementLocated(dateFromRequired).isDisplayed();
        return this;
    }

    public final AssignLeavePage isToDateRequired() {
        Wait.waitVisibilityOfElementLocated(dateToRequired).isDisplayed();
        return this;
    }



}
