package eu.senla.pages;

import eu.senla.core.Wait;
import eu.senla.data.Employee;
import org.openqa.selenium.By;

public class PIMPage extends BasePage {
  private final By addEmployeeButton =
      By.cssSelector("button.oxd-button.oxd-button--medium.oxd-button--secondary[type='button']");
  private final By firstNameField = By.name("firstName");
  private final By middleNameField = By.name("middleName");
  private final By lastNameField = By.name("lastName");
  private final By submitButton = By.xpath("//button[@type='submit']");
  private final By personalDetailLabel = By.xpath("//h6[text()='Personal Details']");
  private final By confirmationMessage = By.id("oxd-toaster_1");

  public final PIMPage clickAddEmployeeButton() {
    Wait.waitVisibilityOfElementLocated(addEmployeeButton).click();
    return this;
  }

  public final PIMPage inputFistName(String firstName) {
    Wait.waitVisibilityOfElementLocated(firstNameField).sendKeys(firstName);
    return this;
  }

  public final PIMPage inputMiddleName(String middleName) {
    Wait.waitVisibilityOfElementLocated(middleNameField).sendKeys(middleName);
    return this;
  }

  public final PIMPage inputLastName(String lastName) {
    Wait.waitVisibilityOfElementLocated(lastNameField).sendKeys(lastName);
    return this;
  }

  public final PIMPage clickSubmit() {
    Wait.waitVisibilityOfElementLocated(submitButton).click();
    return this;
  }

  public final PIMPage isPersonalInformationPage() {
    Wait.waitVisibilityOfElementLocated(personalDetailLabel).isDisplayed();
    return this;
  }

  public final PIMPage fillNewEmployeeForm(Employee employee) {
    inputFistName(employee.getFirstName())
        .inputMiddleName(employee.getMiddleName())
        .inputLastName(employee.getLastName());
    return this;
  }

  public final PIMPage isConfirmed() {
    Wait.waitVisibilityOfElementLocated(confirmationMessage).isDisplayed();
    return this;
  }
}
