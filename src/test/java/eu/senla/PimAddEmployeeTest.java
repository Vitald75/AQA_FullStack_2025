package eu.senla;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.github.javafaker.Faker;
import eu.senla.client.AuthApi;
import eu.senla.core.Driver;
import eu.senla.data.Employee;
import eu.senla.pages.DashBoardPage;
import eu.senla.pages.LoginPage;
import eu.senla.pages.PIMPage;
import lombok.Getter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;


public class PimAddEmployeeTest extends BaseTest {

  private Employee employee;

  @BeforeEach
  final void generateTestData() {
    Faker faker = new Faker();
    employee =
        Employee.builder()
            .firstName(faker.name().firstName())
            .middleName(faker.name().firstName())
            .lastName(faker.name().lastName())
            .build();
    }

  @DisplayName("Успешное добавление PIM employee")
  @Test
  @Tag("smoke")
  public void testPimAddEmployee() {
      String directPimUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList";
//    DashBoardPage dashBoardPage =
//        new LoginPage()
//            .loadPage("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")
//            .loginAsValidUser("Admin", "admin123");

//--------------------------------------------------------------------------------
    //----authenticate(api, directPimUrl);
//    Cookie cookie = new Cookie.Builder("orangehrm", AuthApi.getCookie())
//            .domain("opensource-demo.orangehrmlive.com")
//            .path("/web")
//            .isHttpOnly(true)
//            .sameSite("Lax")
//            .build();
//
//    Driver.getInstance().manage().deleteCookieNamed("orangehrm");
//    Driver.getInstance().manage().addCookie(cookie);
//    Driver.getInstance().get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");

 //--------------------------------------
    //----authenticate(UI);
    DashBoardPage dashBoardPage =
        new LoginPage()
            .loginAsValidUser("Admin", "admin123");
// ------------------------------------------------------------------

        PIMPage pimPage = dashBoardPage
            .getSidePanel()
            .openPIMPage()
            .clickAddEmployeeButton()
            .fillNewEmployeeForm(employee)
            .clickSubmit()
            .isConfirmed()
            .isPersonalInformationPage();

    String currentUrl = pimPage.getUrl();

    assertTrue(
        currentUrl.contains(
            "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewPersonalDetails/empNumber"),
        "Unexpected Url");
  }
}
