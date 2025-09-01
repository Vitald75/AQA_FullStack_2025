package eu.senla;

import eu.senla.core.ConstantsClass;
import eu.senla.core.DataProviderClass;
import eu.senla.core.Driver;
import eu.senla.core.ReadPropertiesFile;
import eu.senla.pages.DashBoardPage;
import eu.senla.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;


public final class LoginTest {

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

  @Test (testName = "Проверка неуспешного логина", groups = {"extended"}, dataProvider = "loginCredentials",
          dataProviderClass = DataProviderClass.class)
  public void testNegativeLoginPage(String userName, String password) throws IOException {

    LoginPage loginPage = new LoginPage().loginAsInvalidUser(userName, password);

    Assert.assertEquals(
        ConstantsClass.MAIN_URL + ConstantsClass.WEB_EP + ConstantsClass.AUTH_LOGIN_URL,
        loginPage.getCurrentUrl(),
        "Unexpected Successful login");

  }

  @AfterClass
  void tearDown() {
    if (Driver.getInstance() != null) {
      Driver.getInstance().quit();
    }
  }


}
