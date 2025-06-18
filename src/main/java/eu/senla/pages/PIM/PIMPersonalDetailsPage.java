package eu.senla.pages.PIM;

import eu.senla.core.Driver;
import eu.senla.core.Wait;
import eu.senla.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
    private final By nationality =
            By.xpath("//label[text()='Nationality']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']");
    private final By nationalityListBox =
            By.xpath("//div[@role='listbox']//span[text()='American']");
    private final By martialStatus =
            By.xpath("//label[text()='Marital Status']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']");
    private final By dateOfBirth =
            By.xpath("//label[text()='Date of Birth']/parent::div/following-sibling::div//input");
    private final By maleGender =
            By.xpath("//input[@type='radio' and @value='1']");
    private final By femaleGender =
            By.xpath("//input[@type='radio' and @value='2']");  ///following-sibling::span

    private final By personalDetailsSaveButton1 =
            By.xpath("//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//button[@type='submit']");

    private final By confirmationMessage = By.id("oxd-toaster_1");

    //private final By headerPersonalDetails = By.xpath("//h6[text()='Personal Details']");

    public String getEmployeeFirstName() {
            return Wait.waitVisibilityOfElementLocated(employeeFirstName).getAttribute("value");
    }

    public String getEmployeeMiddleName() {
        return Wait.waitVisibilityOfElementLocated(employeeMiddleName).getAttribute("value");
    }
    public String getEmployeeLastName() {
        return Wait.waitVisibilityOfElementLocated(employeeLastName).getAttribute("value");
    }
    public String getEmployeeId() {
        return Wait.waitVisibilityOfElementLocated(employeeId).getAttribute("value");
    }
    public String getOtherId() {
        return Wait.waitVisibilityOfElementLocated(otherId).getAttribute("value");
    }
    public String getDriverLicenseNubmer() {
        return Wait.waitVisibilityOfElementLocated(driversLicenseId).getAttribute("value");
    }
    public String getDriverLicenseExpDate() {
        return Wait.waitVisibilityOfElementLocated(licenseExpiryDate).getAttribute("value");
    }
    public String getMartialStatus() {
        return Wait.waitVisibilityOfElementLocated(martialStatus).getAttribute("value");
    }
    public String getBirthday() {
        return Wait.waitVisibilityOfElementLocated(dateOfBirth).getAttribute("value");
    }
    public String getNationality() {
        return Wait.waitVisibilityOfElementLocated(nationality).getText();
    }

    public Integer getGender() {
        Integer value = 0;
        String str1 = Driver.getInstance().findElement(By.xpath("//input[@type='radio' and @value='1']")).getAttribute("checked");
        String str2 = Driver.getInstance().findElement(By.xpath("//input[@type='radio' and @value='2']")).getAttribute("checked");

        if ((str1 == null) ? false : str1.equals("true"))
            value = 1;
        if ((str2 == null) ? false : str2.equals("true"))
            value = 2;
        return value;
    }

    public PIMPersonalDetailsPage inputEmployeeFirstName(String firstName) {
        Wait.waitVisibilityOfElementLocated(employeeFirstName).sendKeys(firstName);
        return this;
    }

    public PIMPersonalDetailsPage inputEmployeeLastName(String lastName) {
        Wait.waitVisibilityOfElementLocated(employeeLastName).sendKeys(lastName);
        return this;
    }

    public PIMPersonalDetailsPage inputEmployeeMiddleName(String middleName) {
        Wait.waitVisibilityOfElementLocated(employeeMiddleName).sendKeys(middleName);
        return this;
    }

    public PIMPersonalDetailsPage inputOtherId(String otherIdStr) {
        Wait.waitVisibilityOfElementLocated(otherId).sendKeys(otherIdStr);
        return this;
    }

    public PIMPersonalDetailsPage inputDriversLicenseId(String driversLicenseIdStr) {
        Wait.waitVisibilityOfElementLocated(driversLicenseId).sendKeys(driversLicenseIdStr);
        return this;
    }

    public PIMPersonalDetailsPage inputDriversLicenseExpDate(String licenseExpDate) {
        Wait.waitVisibilityOfElementLocated(licenseExpiryDate).sendKeys(licenseExpDate);
        return this;
    }

    public PIMPersonalDetailsPage inputDateOfBirth(String birthDate) {
        Wait.waitVisibilityOfElementLocated(dateOfBirth).sendKeys(birthDate);
        return this;
    }

    public PIMPersonalDetailsPage clickMaleGender() {
        Wait.waitVisibilityOfElementLocated(maleGender).click();
        return this;
    }

    public PIMPersonalDetailsPage clickFemaleGender() {
        Wait.waitVisibilityOfElementLocated(femaleGender).click();
        return this;
    }

    public PIMPersonalDetailsPage chooseNationality() {
        Wait.waitVisibilityOfElementLocated(nationality).click();
        Wait.waitVisibilityOfElementLocated(nationalityListBox).click();
        return this;
    }

    public PIMPersonalDetailsPage chooseMartialStatus(String status) {
        By martialStatusListBox =
                By.xpath("//div[@role='listbox']//span[text()='" + status + "']");

        Wait.waitVisibilityOfElementLocated(martialStatus).click();
        Wait.waitVisibilityOfElementLocated(martialStatusListBox).click();
        return this;
    }

    public PIMPersonalDetailsPage saveFirstBlock() {
        Wait.waitVisibilityOfElementLocated(personalDetailsSaveButton1).click();
        return this;
    }

    public PIMPersonalDetailsPage isConfirmed() {
        Wait.waitVisibilityOfElementLocated(confirmationMessage).isDisplayed();
        return this;
    }

    public PIMPersonalDetailsPage isPersonalDetailsDisplayed(String expectedEmployeeId) {
        WebDriverWait wait = new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(2));
               wait.until(ExpectedConditions.textToBePresentInElementValue(employeeId, expectedEmployeeId));
        return this;
    }

}
