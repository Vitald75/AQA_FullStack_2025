package eu.senla.pages.PIM;

import eu.senla.core.Wait;
import eu.senla.pages.BasePage;
import org.openqa.selenium.By;

public class PIMPersonalDetailsPage extends BasePage {

    private final By employeeFirstName =
            By.cssSelector("input[name='firstName']");
    private final By employeeMiddleName =
            By.cssSelector("input[name='middleName']");
    private final By employeeLastName =
            By.cssSelector("input[name='lastName']");

    private final By employeeNickname =
            By.xpath("//label[text()='Nickname']/parent::div/following-sibling::div/input");
    private final By employeeId =
            By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input");
    private final By otherId =
            By.xpath("//label[text()='Other Id']/parent::div/following-sibling::div/input");
    private final By driversLicenseId =
            By.xpath("//label[contains(text(),'License Number')]/parent::div/following-sibling::div//input");
    private final By licenseExpiryDate =
            By.xpath("//label[text()='License Expiry Date']/parent::div/following-sibling::div/input");
    private final By nationality =
            By.xpath("//label[text()='Nationality']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']");
    private final By martialStatus =
            By.xpath("//label[text()='Marital Status']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']");
    private final By dateOfBirth =
            By.xpath("//label[text()='Date of Birth']/parent::div/following-sibling::div//input");
    private final By maleGender =
            By.xpath("//input[@type='radio' and @value='1']");
    private final By femaleGender =
            By.xpath("//input[@type='radio' and @value='2']");

    private final By personalDetailsSaveButton =
            By.xpath("//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//button[@type='submit']");


    public String getEmployeeFirstName() {
            return Wait.waitVisibilityOfElementLocated(employeeFirstName).getText();
    }
    public String getEmployeeMiddleName() {
        return Wait.waitVisibilityOfElementLocated(employeeMiddleName).getText();
    }
    public String getEmployeeLastName() {
        return Wait.waitVisibilityOfElementLocated(employeeLastName).getText();
    }

    public String getEmployeeId() {
        return Wait.waitVisibilityOfElementLocated(employeeId).getText();
    }

}
