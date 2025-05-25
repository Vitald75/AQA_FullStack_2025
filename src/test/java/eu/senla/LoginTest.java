package eu.senla;

import static org.junit.jupiter.api.Assertions.assertEquals;

import eu.senla.core.ReadPropertiesFile;
import eu.senla.pages.DashBoardPage;
import eu.senla.pages.LoginPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public final class LoginTest extends BaseTest {

  @Test
  @Order(0)
  @DisplayName("Проверка успешного логина")
  @Tag("smoke")
  public void testPositiveLoginPage() {

    DashBoardPage loginPage =
        new LoginPage()
            .loadPage("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")
            .loginAsValidUser(
                ReadPropertiesFile.getProperty("USERNAME"),
                ReadPropertiesFile.getProperty("PASSWORD"));

    assertEquals(loginPage.getDashboardUrl(), loginPage.getUrl(), "Login failed");
  }

  @ParameterizedTest()
  @Order(1)
  @DisplayName("Проверка неуспешного логина")
  @Tag("extended")
  @CsvSource({"Admin, 1234564", "WrongName, admin123", "AnyName, 43211", "'',''"})
  public void testNegativeLoginPage(String userName, String password) {
    //
    // driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    LoginPage loginPage =
        new LoginPage()
            .loadPage("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")
            .loginAsInvalidUser(userName, password);

    assertEquals(
        "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login",
        loginPage.getUrl(),
        "Unexpected Successful login");
  }
}
