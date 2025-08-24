package eu.senla;

import eu.senla.core.ConstantsClass;
import eu.senla.core.Driver;
import eu.senla.core.ReadPropertiesFile;
import eu.senla.listeners.ScreenshotHandler;
import eu.senla.pages.DashBoardPage;
import eu.senla.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

//@Tag("login")
public final class LoginTest {



  @DataProvider(name = "loginCredentials")
  public Object[][] provideLoginData() {
    return new Object[][]{
            {"Admin", "1234564"},
            {"WrongName", "admin123"},
            {"AnyName", "43211"},
            {"", ""}
    };
  }

  @Test (testName = "Проверка успешного логина", groups = {"smoke"})
  public void testPositiveLoginPage() {

    DashBoardPage dashBoardPage =
        new LoginPage()
            .loginAsValidUser(
                ReadPropertiesFile.getProperty("USERNAME"),
                ReadPropertiesFile.getProperty("PASSWORD"));

    Assert.assertEquals(dashBoardPage.getCurrentUrl(), dashBoardPage.getOwnPageUrl(),
            "Unexpected Url");
  }

  @Test (testName = "Проверка неуспешного логина", groups = {"extended"}, dataProvider = "loginCredentials")
  public void testNegativeLoginPage(String userName, String password) throws IOException {

    LoginPage loginPage = new LoginPage().loginAsInvalidUser(userName, password);

    ScreenshotHandler.getScreenshot(Driver.getInstance());
    Assert.assertEquals(
        ConstantsClass.MAIN_URL + ConstantsClass.WEB_EP + ConstantsClass.AUTH_LOGIN_URL,
        loginPage.getCurrentUrl(),
        "Unexpected Successful login");

  }

  @AfterTest
  void tearDown() {
    if (Driver.getInstance() != null) {
      Driver.getInstance().quit();
    }
  }


}
