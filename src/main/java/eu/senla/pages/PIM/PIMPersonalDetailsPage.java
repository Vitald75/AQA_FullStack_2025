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
            By.xpath("//label[text()='License Expiry Date']/parent::div/following-sibling::div//input");
    private final By nationalityDropDown =
            By.xpath("//label[text()='Nationality']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']");
    private final By maritalStatus =
            By.xpath("//label[text()='Marital Status']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']");
    private final By dateOfBirth =
            By.xpath("//label[text()='Date of Birth']/parent::div/following-sibling::div//input");
    private final By maleGender =
            By.xpath("//input[@type='radio' and @value='1']/following-sibling::span");
    private final By femaleGender =
            By.xpath("//label[text()='Female']");

    private final By bloodTypeDropDown =
            By.xpath("//label[text()='Blood Type']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']");

    private final By personalDetailsSaveButton1 =
            By.xpath("//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//button[@type='submit']");

    private final By personalDetailsSaveButton2 =
            By.xpath("//div[@class='orangehrm-custom-fields']//button[@type='submit']");

    private final By confirmationMessage = By.id("oxd-toaster_1");

    public final String getEmployeeId() {
        return Wait.waitVisibilityOfElementLocated(employeeId).getAttribute("value");
    }



    public final PIMPersonalDetailsPage inputOtherId(String otherIdStr) {
        Wait.waitVisibilityOfElementLocated(otherId).sendKeys(otherIdStr);
        return this;
    }

    public final PIMPersonalDetailsPage inputDriversLicenseId(String driversLicenseIdStr) {
        Wait.waitVisibilityOfElementLocated(driversLicenseId).sendKeys(driversLicenseIdStr);
        return this;
    }

    public final PIMPersonalDetailsPage inputDriversLicenseExpDate(String licenseExpDate) {
        Wait.waitVisibilityOfElementLocated(licenseExpiryDate).sendKeys(licenseExpDate);
        return this;
    }

    public final PIMPersonalDetailsPage inputDateOfBirth(String birthDate) {
        Wait.waitVisibilityOfElementLocated(dateOfBirth).sendKeys(birthDate);
        return this;
    }

    public final PIMPersonalDetailsPage chooseGender(Integer gender) {
        switch (gender) {
            case 1:
                Wait.waitVisibilityOfElementLocated(maleGender).click();
                break;
            case 2:
                Wait.waitVisibilityOfElementLocated(femaleGender).click();
                break;
            default:
                break;
        }
        return this;
    }

    public final PIMPersonalDetailsPage chooseNationality(String nationality) {
        By nationalityListBox =
                By.xpath("//div[@role='listbox']//span[text()='" + nationality + "']");
        Wait.waitVisibilityOfElementLocated(nationalityDropDown).click();
        Wait.waitVisibilityOfElementLocated(nationalityListBox).click();
        return this;
    }

    public final PIMPersonalDetailsPage chooseMaritalStatus(String status) {
        By maritalStatusListBox =
                By.xpath("//div[@role='listbox']//span[text()='" + status + "']");

        Wait.waitVisibilityOfElementLocated(maritalStatus).click();
        Wait.waitVisibilityOfElementLocated(maritalStatusListBox).click();
        return this;
    }

    public final PIMPersonalDetailsPage chooseBloodType(String type) {
        By bloodTypeListBox =
                By.xpath("//div[@role='listbox']//span[text()='" + type + "']");
        Wait.waitVisibilityOfElementLocated(bloodTypeDropDown).click();
        Wait.waitVisibilityOfElementLocated(bloodTypeListBox).click();
        return this;
    }

    public final PIMPersonalDetailsPage saveFirstBlock() {
        Wait.waitVisibilityOfElementLocated(personalDetailsSaveButton1).click();
        return this;
    }

    public final PIMPersonalDetailsPage saveSecondBlock() {
        Wait.waitVisibilityOfElementLocated(personalDetailsSaveButton2).click();
        return this;
    }

    public final PIMPersonalDetailsPage isConfirmed() {
        Wait.waitVisibilityOfElementLocated(confirmationMessage).isDisplayed();
        return this;
    }

    public final boolean isPersonalDetailsDisplayed(String expectedFirstName) {
        return Wait.waitTextToBePresentInElement(employeeFirstName, expectedFirstName);
    }

}
