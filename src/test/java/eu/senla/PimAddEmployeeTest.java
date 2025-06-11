package eu.senla;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.github.javafaker.Faker;
import eu.senla.client.LoginStrategy;
//import eu.senla.client.LoginViaApiStrategy;
import eu.senla.client.FormLoginImpl;
import eu.senla.data.Employee;
import eu.senla.pages.PIMPage;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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

  @SneakyThrows
  @DisplayName("Успешное добавление PIM employee")
  @Test
  @Tag("smoke")
  public void testPimAddEmployee() {

    String directPimUrl =
        "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList";

    // Выбор стратегии аутентификации
    //LoginStrategy authenticate = new LoginViaApiStrategy(directPimUrl);
    LoginStrategy authenticate = new FormLoginImpl();

    authenticate.login();

    PIMPage pimPage =
        new PIMPage()
            .clickAddEmployeeButton()
            .fillNewEmployeeForm(employee)
            .clickSubmit()
            .isConfirmed()
            .isPersonalInformationPage();

    String currentUrl = pimPage.getCurrentUrl();

    assertTrue(
        currentUrl.contains(
            "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewPersonalDetails/empNumber"),
        "Unexpected Url");
  }
}
