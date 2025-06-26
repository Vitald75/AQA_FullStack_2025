package eu.senla.pages.PIM;

import eu.senla.core.ConstantsClass;
import eu.senla.core.Wait;
import eu.senla.dataUi.Employee;
import eu.senla.elements.SidePanel;
import eu.senla.pages.BasePage;
import lombok.Getter;
import org.openqa.selenium.By;

public class PIMAddEmployeePage extends BasePage {
  @Getter
  private final String ownPageUrl = ConstantsClass.MAIN_URL + ConstantsClass.WEB_EP + ConstantsClass.PIM_URL;
      //"https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList";


  private final By firstNameField = By.name("firstName");
  private final By middleNameField = By.name("middleName");
  private final By lastNameField = By.name("lastName");
  private final By submitButton = By.xpath("//button[@type='submit']");
  private final By personalDetailLabel = By.xpath("//h6[text()='Personal Details']");
  private final By confirmationMessage = By.id("oxd-toaster_1");

  public final PIMAddEmployeePage inputFistName(String firstName) {
    Wait.waitVisibilityOfElementLocated(firstNameField).sendKeys(firstName);
    return this;
  }

  public final PIMAddEmployeePage inputMiddleName(String middleName) {
    Wait.waitVisibilityOfElementLocated(middleNameField).sendKeys(middleName);
    return this;
  }

  public final PIMAddEmployeePage inputLastName(String lastName) {
    Wait.waitVisibilityOfElementLocated(lastNameField).sendKeys(lastName);
    return this;
  }

  public final PIMAddEmployeePage clickSubmit() {
    Wait.waitVisibilityOfElementLocated(submitButton).click();
    return this;
  }

  public final PIMAddEmployeePage isPersonalInformationPage() {
    Wait.waitVisibilityOfElementLocated(personalDetailLabel).isDisplayed();
    return this;
  }

  public final PIMAddEmployeePage fillNewEmployeeForm(Employee employee) {
    inputFistName(employee.getFirstName())
        .inputMiddleName(employee.getMiddleName())
        .inputLastName(employee.getLastName());
    return this;
  }

  public final PIMAddEmployeePage isConfirmed() {
    Wait.waitVisibilityOfElementLocated(confirmationMessage).isDisplayed();
    return this;
  }


  public final PIMAddEmployeePage addPIMEmployeeSuccessful(Employee employee) {

    PIMAddEmployeePage pimAddEmployeePage = new SidePanel()
            .openPIMPage()
            .clickAddEmployeeButton()
            .fillNewEmployeeForm(employee)
            .clickSubmit()
            .isConfirmed()
            .isPersonalInformationPage();

    String currentUrl = pimAddEmployeePage.getCurrentUrl();
    employee.setEmpNumber(Integer.parseInt(currentUrl.substring(currentUrl.lastIndexOf("/") + 1)));

    return pimAddEmployeePage;
  }

}
