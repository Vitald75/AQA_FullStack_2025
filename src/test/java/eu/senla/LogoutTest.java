package eu.senla;

import eu.senla.core.ConstantsClass;
import eu.senla.pages.DashBoardPage;
import eu.senla.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LogoutTest extends BaseTest {

  @Test (testName = "Проверка успешного выхода из учетной записи", groups = {"smoke"})
  public void testLogout() {

    LoginPage loginPage = new DashBoardPage().openUserDropDownMenu().clickLogout();

    Assert.assertEquals(
            ConstantsClass.MAIN_URL + ConstantsClass.WEB_EP + ConstantsClass.AUTH_LOGIN_URL,
        loginPage.getCurrentUrl(),
        "Unsuccessful logout. Url doesn't match");
  }
}
