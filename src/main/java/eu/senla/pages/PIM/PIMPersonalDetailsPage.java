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
            By.xpath("//input[@type='radio' and @value='2']");  ///following-sibling::span

    private final By personalDetailsSaveButton =
            By.xpath("//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//button[@type='submit']");

    private final By headerPersonalDetails = By.xpath("//h6[text()='Personal Details']");

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
        return Wait.waitVisibilityOfElementLocated(nationality).getAttribute("value");
    }

    public Integer getGender() {
        Integer value = 0;
        if (Wait.waitVisibilityOfElementLocated(maleGender).getAttribute("checked") == "true")
            value = 1;
        if (Wait.waitVisibilityOfElementLocated(femaleGender).getAttribute("checked") == "true")
            value = 2;
        return value;
    }

    public PIMPersonalDetailsPage isPersonalDetailsDisplayed(String expectedEmployeeId) {
        //Wait.waitVisibilityOfElementLocated(headerPersonalDetails).isDisplayed();

        WebDriverWait waitt = new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(2));
               boolean b = waitt.until(ExpectedConditions
                //.textToBePresentInElementValue(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input"), employeeId));
                       .textToBePresentInElementValue(employeeId, expectedEmployeeId));
        return this;
    }

}
