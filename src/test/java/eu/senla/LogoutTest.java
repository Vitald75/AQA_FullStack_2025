package eu.senla;

import static org.junit.jupiter.api.Assertions.assertEquals;

import eu.senla.core.ConstantsClass;
import eu.senla.pages.DashBoardPage;
import eu.senla.pages.LoginPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class LogoutTest extends BaseTest {

  @DisplayName("Проверка успешного выхода из учетной записи")
  @Tag("smoke")
  @Test
  public void testLogout() {

    LoginPage loginPage = new DashBoardPage().openUserDropDownMenu().clickLogout();

    assertEquals(
            ConstantsClass.MAIN_URL + ConstantsClass.WEB_EP + ConstantsClass.AUTH_LOGIN_URL,
        loginPage.getCurrentUrl(),
        "Unsuccessful logout. Url doesn't match");
  }
}
