package eu.senla;

import static org.junit.jupiter.api.Assertions.assertEquals;

import eu.senla.core.Driver;
import eu.senla.core.ReadPropertiesFile;
import eu.senla.pages.DashBoardPage;
import eu.senla.pages.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public final class LoginTest {

  @Test
  @DisplayName("Проверка успешного логина")
  @Tag("smoke")
  public void testPositiveLoginPage() {

    DashBoardPage dashBoardPage =
        new LoginPage()
            .loginAsValidUser(
                ReadPropertiesFile.getProperty("USERNAME"),
                ReadPropertiesFile.getProperty("PASSWORD"));

    assertEquals(dashBoardPage.getDashboardUrl(), dashBoardPage.getCurrentUrl(),
            "Login failed");
  }

  @ParameterizedTest()
  @DisplayName("Проверка неуспешного логина")
  @Tag("extended")
  @CsvSource({"Admin, 1234564", "WrongName, admin123", "AnyName, 43211", "'',''"})
  public void testNegativeLoginPage(String userName, String password) {

    LoginPage loginPage = new LoginPage().loginAsInvalidUser(userName, password);

    assertEquals(
        ReadPropertiesFile.getProperty("LOGIN_URL"),
        loginPage.getCurrentUrl(),
        "Unexpected Successful login");
  }

  @AfterEach
    void tearDown() {
      Driver.quit();
    }

}
