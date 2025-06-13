package eu.senla.pages.leave;

import org.openqa.selenium.By;


public class AssignLeavePage {

    private final By employeeNameInput = By.xpath("//div[@class='oxd-autocomplete-text-input--before']/following::input[1]");

    private final By leaveTypeDropdownButton = By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']");
    private final By leaveTypeDropdownListBox = By.xpath("//div[@role='listbox']");
    //Select select = new Select(dropdownElement);
    private final By leaveTypeFromList = By.xpath("//div[@role='listbox']/div/span[text()='US - Vacation']");


    private final By fromDateInput = By.xpath("//div[@class='oxd-autocomplete-text-input--before']/following::input[2]");
    private final By toDateInput = By.xpath("//div[@class='oxd-autocomplete-text-input--before']/following::input[3]");
    private final By commentsInput = By.xpath("//textarea");
    private final By assingButton = By.xpath("//button[@type='submit']");





}
