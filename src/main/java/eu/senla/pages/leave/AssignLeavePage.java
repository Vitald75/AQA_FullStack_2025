package eu.senla.pages.leave;

import eu.senla.core.Driver;
import eu.senla.core.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;


public class AssignLeavePage {

    private final By employeeNameInput = By.xpath("//div[@class='oxd-autocomplete-text-input--before']/following::input[1]");
    private final By employeeNameListBox = By.xpath("//div[@role='listbox']");

    private final By leaveTypeDropdownButton = By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']");
    private final By leaveTypeDropdownListBox = By.xpath("//div[@role='listbox']");
    //private final Select select = new Select(Driver.getInstance().findElement(leaveTypeDropdownListBox));

    private final By leaveTypeFromList = By.xpath("//div[@role='listbox']/div/span[text()='US - Vacation']");


    private final By fromDateInput = By.xpath("//div[@class='oxd-autocomplete-text-input--before']/following::input[2]");
    private final By toDateInput = By.xpath("//div[@class='oxd-autocomplete-text-input--before']/following::input[3]");
    private final By commentsInput = By.xpath("//textarea");
    private final By assingButton = By.xpath("//button[@type='submit']");


    public AssignLeavePage inputEmployeeName (String employeeName) {
        Wait.waitVisibilityOfElementLocated(employeeNameInput).sendKeys(employeeName);
        return this;
    }

    public AssignLeavePage clickLeaveTypeDropbox () {
        Wait.waitVisibilityOfElementLocated(leaveTypeDropdownButton).click();
        return new AssignLeavePage();
    }

    public AssignLeavePage chooseLeaveTypeFromDropbox (String typeOfLeave) {
        //select.selectByValue("US - Vacation");
        //Wait.waitVisibilityOfElementLocated(select.selectByValue("")).click();
        Select listBox = new Select(Driver.getInstance().findElement(leaveTypeDropdownListBox));
        listBox.selectByIndex(1);

        //Wait.waitVisibilityOfElementLocated(leaveTypeDropdownListBox).click();
        return new AssignLeavePage();
    }

    public AssignLeavePage selectUserName () {
        //select.selectByValue("US - Vacation");
        //Wait.waitVisibilityOfElementLocated(select.selectByValue("")).click();

        Select listBox = new Select(Driver.getInstance().findElement(leaveTypeDropdownListBox));
        listBox.selectByIndex(1);

        //Wait.waitVisibilityOfElementLocated(leaveTypeDropdownListBox).click();
        return new AssignLeavePage();
    }

}
