package eu.senla;

import static org.junit.jupiter.api.Assertions.assertEquals;

import eu.senla.pages.DashBoardPage;
import eu.senla.pages.LoginPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class LogoutTest extends BaseTest {
  //
  @DisplayName("Проверка успешного выхода из учетной записи")
  @Tag("smoke")
  @Test
  public void testLogout() {

    // DashBoardPage loginPage = new
    // LoginPage().loadPage("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")
    //      .loginAsValidUser("Admin", "admin123");
    DashBoardPage dashBoardPage =
        new LoginPage()
            .loadPage("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")
            .loginAsValidUser("Admin", "admin123");
    LoginPage loginPage = dashBoardPage.openUserDropDownMenu().clickLogout();

    assertEquals(
        "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login",
        loginPage.getUrl(),
        "Unsuccessful logout. Url doesn't match");

    //                driver.findElement(By.xpath("//button[text()=' Login ']")).isDisplayed(),
    //                "Unsuccessful logout"),

  }
}
