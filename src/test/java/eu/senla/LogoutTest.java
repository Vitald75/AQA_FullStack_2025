package eu.senla;

import static org.junit.jupiter.api.Assertions.assertEquals;

import eu.senla.core.ReadPropertiesFile;
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

    DashBoardPage dashBoardPage =
        new LoginPage()
            // .loadPage(ReadPropertiesFile.getProperty("LOGIN_URL"))
            .loginAsValidUser(
                ReadPropertiesFile.getProperty("USERNAME"),
                ReadPropertiesFile.getProperty("PASSWORD"));
    LoginPage loginPage = dashBoardPage.openUserDropDownMenu().clickLogout();

    assertEquals(
        ReadPropertiesFile.getProperty("LOGIN_URL"),
        loginPage.getCurrentUrl(),
        "Unsuccessful logout. Url doesn't match");
  }
}
