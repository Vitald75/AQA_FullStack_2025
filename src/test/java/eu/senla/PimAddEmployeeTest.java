package eu.senla;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.github.javafaker.Faker;
import eu.senla.data.Employee;
import eu.senla.pages.DashBoardPage;
import eu.senla.pages.LoginPage;
import eu.senla.pages.PIMPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

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
  @Order(1)
  public void testPimAddEmployee() {

    DashBoardPage dashBoardPage =
        new LoginPage()
            .loadPage("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")
            .loginAsValidUser("Admin", "admin123");
    PIMPage pimPage =
        dashBoardPage
            .getSidePanel()
            .openPIMPage()
            .clickAddEmployeeButton()
            .fillNewEmployeeForm(employee)
            .clickSubmit()
            .isConfirmed()
            .isPersonalInformationPage();

    // pimPage.isConfirmed();
    // pimPage.isPersonalInformationPage();
    String currentUrl = pimPage.getUrl();

    assertTrue(
        currentUrl.contains(
            "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewPersonalDetails/empNumber"),
        "Unexpected Url");
  }
}
