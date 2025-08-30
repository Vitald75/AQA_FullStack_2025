package eu.senla.pages;

import eu.senla.core.ConstantsClass;
import eu.senla.core.Driver;
import eu.senla.core.Wait;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginPage extends BasePage { // extends BasePage{

  private final By userNameField = By.name("username");
  private final By passwordField = By.name("password");
  private final By submitButton = By.cssSelector("button[type='submit']");
  private final By invalidCredentialsAlert = By.xpath("//p[text()='Invalid credentials']");
  private final By userNameRequired =
      By.xpath("//label[text()='Username']/ancestor::div[2]/span[text()='Required']");
  private final By passwordRequired =
      By.xpath("//label[text()='Password']/ancestor::div[2]/span[text()='Required']");

  public LoginPage() {
    Driver.getInstance().manage().deleteAllCookies();
    Driver.getInstance().get(ConstantsClass.MAIN_URL + ConstantsClass.WEB_EP + ConstantsClass.AUTH_LOGIN_URL);
  }

  public final LoginPage enterUserName(String userName) {
    Wait.waitVisibilityOfElementLocated(userNameField).sendKeys(userName);
    return this;
  }

  @Step("Enter password")
  public final LoginPage enterPassword(String password) {
    Wait.waitVisibilityOfElementLocated(passwordField).sendKeys(password);
    return this;
  }

  @Step("Click submit button")
  public final LoginPage clickSubmitButton() {
    Wait.waitVisibilityOfElementLocated(submitButton).click();
    return this;
  }

  @Step("Login as valid user")
  @Severity(SeverityLevel.CRITICAL)
  public final DashBoardPage loginAsValidUser(String userName, String password) {
    enterUserName(userName)
            .enterPassword(password)
            .clickSubmitButton();
    return new DashBoardPage();
  }

  @Step("Login with invalid credentials")
  public final LoginPage loginAsInvalidUser(String userName, String password) {
    enterUserName(userName)
            .enterPassword(password)
            .clickSubmitButton();

    if (userName.isEmpty()) {
      Wait.waitVisibilityOfElementLocated(userNameRequired);
    }

    if (password.length() == 0) {
      Wait.waitVisibilityOfElementLocated(passwordRequired);
    }

    if ((userName.length() > 0) && (password.length() > 0)) {
      Wait.waitVisibilityOfElementLocated(invalidCredentialsAlert);
    }
    return this;
  }
}
