package eu.senla.pages;

import eu.senla.client.AuthApi;
import eu.senla.core.Driver;
import eu.senla.core.Wait;
import eu.senla.data.Employee;
import eu.senla.elements.SidePanel;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;

public class PIMPage {
  public String getPimPageUrl() {
    return pimPageUrl;
  }

  private final String pimPageUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList";
  private final SidePanel sidePanel;
  private final By addEmployeeButton =
      By.cssSelector("button.oxd-button.oxd-button--medium.oxd-button--secondary[type='button']");
  private final By firstNameField = By.name("firstName");
  private final By middleNameField = By.name("middleName");
  private final By lastNameField = By.name("lastName");
  private final By submitButton = By.xpath("//button[@type='submit']");
  private final By personalDetailLabel = By.xpath("//h6[text()='Personal Details']");
  private final By confirmationMessage = By.id("oxd-toaster_1");

  public PIMPage() {
//    Cookie cookie = new Cookie.Builder("orangehrm", AuthApi.getCookie())
//            .domain("opensource-demo.orangehrmlive.com")
//            .path("/web")
//            .isHttpOnly(true)
//            .sameSite("Lax")
//            .build();
//
//    // Add the cookie to the current domain
//    Driver.getInstance().get(pimPageUrl);
//    Driver.getInstance().manage().deleteCookieNamed("orangehrm");
//    Driver.getInstance().manage().addCookie(cookie);
//    Driver.getInstance().get(pimPageUrl);
    //Driver.getInstance().navigate().to(pimPageUrl); //get(pimPageUrl);

    Wait.waitVisibilityOfElementLocated(addEmployeeButton);
    this.sidePanel = new SidePanel();
  }

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

  public final String getUrl() {
    return Driver.getInstance().getCurrentUrl();
  }
}
