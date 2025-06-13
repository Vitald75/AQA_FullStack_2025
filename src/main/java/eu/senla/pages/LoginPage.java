package eu.senla.pages;

import eu.senla.core.Driver;
import eu.senla.core.ReadPropertiesFile;
import eu.senla.core.Wait;
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
    Driver.getInstance().get(ReadPropertiesFile.getProperty("LOGIN_URL"));
  }

  public final LoginPage enterUserName(String userName) {
    Wait.waitVisibilityOfElementLocated(userNameField).sendKeys(userName);
    return this;
  }

  public final LoginPage enterPassword(String password) {
    Wait.waitVisibilityOfElementLocated(passwordField).sendKeys(password);
    return this;
  }

  public final LoginPage clickSubmitButton() {
    Wait.waitVisibilityOfElementLocated(submitButton).click();
    return this;
  }

  public final DashBoardPage loginAsValidUser(String userName, String password) {
    enterUserName(userName).enterPassword(password).clickSubmitButton();
    return new DashBoardPage();
  }

  public final LoginPage loginAsInvalidUser(String userName, String password) {
    enterUserName(userName).enterPassword(password).clickSubmitButton();

    if (userName.isEmpty()) {
      Wait.waitVisibilityOfElementLocated(userNameRequired);
    }

    if (password.length() == 0) {
      Wait.waitVisibilityOfElementLocated(passwordRequired);
    }

    if ((userName.length() > 0) && (password.length() > 0)) {
      Wait.waitVisibilityOfElementLocated(invalidCredentialsAlert);
    }
    return new LoginPage();
  }
}
