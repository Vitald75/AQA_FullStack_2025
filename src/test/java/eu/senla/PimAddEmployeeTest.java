package eu.senla;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.github.javafaker.Faker;
import eu.senla.client.OrangeHRMClient;
import eu.senla.client.SpecConfig;
import eu.senla.core.ConstantsClass;
import eu.senla.dataApi.EmployeeApi;
import eu.senla.dataApi.GetEmployeeResponse;
import eu.senla.elements.SidePanel;
import eu.senla.dataUi.Employee;
import eu.senla.pages.PIM.PIMAddEmployeePage;
import eu.senla.pages.PIM.PIMPersonalDetailsPage;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("employee")
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
            .birthday("2000-01-02")
            .maritalStatus("Single")
            .gender(1)
            .otherId(faker.number().digits(8))
            .drivingLicenseNo("N " + faker.number().digits(6))
            .drivingLicenseExpiredDate("2025-02-03")
            .nationality("American")
            .build();
  }

  final String convertDateFormat(String inputDate) {
    String[] parts = inputDate.split("-");
    return parts[0] + "-" + parts[2] + "-" + parts[1];
  }

  final boolean compareUiAndApiEmployee(Employee employeeUi, EmployeeApi employeeApi) {
    return employeeApi.getFirstName().equals(employeeUi.getFirstName())
            && employeeApi.getLastName().equals(employeeUi.getLastName())
            && employeeApi.getEmpNumber().equals(employeeUi.getEmpNumber())
            && employeeApi.getNationality().getName().equals(employeeUi.getNationality())
            && (employeeApi.getGender() == employeeUi.getGender())
            && employeeApi.getBirthday().equals(convertDateFormat(employeeUi.getBirthday()))
            && employeeApi.getDrivingLicenseNo().equals(employeeUi.getDrivingLicenseNo())
            && employeeApi.getDrivingLicenseExpiredDate().equals(convertDateFormat(employeeUi.getDrivingLicenseExpiredDate()))
            && employeeApi.getMaritalStatus().equals(employeeUi.getMaritalStatus());
  }

  @SneakyThrows
  @DisplayName("Успешное добавление PIM employee, проверка формы Employee Details, сравнение данных c API")
  @Test
  @Tag("smoke")
  public void testPimAddEmployee() {

    //добавление нового PIM Employee
    PIMAddEmployeePage pimAddEmployeePage = new SidePanel()
            .openPIMPage()
            .clickAddEmployeeButton()
            .fillNewEmployeeForm(employee)
            .clickSubmit()
            .isConfirmed()
            .isPersonalInformationPage();

    assertTrue(pimAddEmployeePage.getCurrentUrl().contains(ConstantsClass.PIM_DETAILS_URL), "Unexpected Url");

    //заполнение Personal Details
    PIMPersonalDetailsPage pimPersonalDetailsPage = new PIMPersonalDetailsPage();
    assertTrue(pimPersonalDetailsPage.isPersonalDetailsDisplayed(employee.getFirstName()));

    pimPersonalDetailsPage
            .inputDriversLicenseId(employee.getDrivingLicenseNo())
            .inputOtherId(employee.getOtherId())
            .inputDriversLicenseExpDate(employee.getDrivingLicenseExpiredDate())
            .inputDateOfBirth(employee.getBirthday())
            .chooseMaritalStatus(employee.getMaritalStatus())
            .chooseNationality(employee.getNationality())
            .chooseGender(employee.getGender())
            .saveFirstBlock()
            .isConfirmed()
            .chooseBloodType("AB+")
            .saveSecondBlock()
            .isConfirmed();

    String currentUrl = pimPersonalDetailsPage.getCurrentUrl();
    assertTrue(currentUrl.contains(ConstantsClass.PIM_DETAILS_URL), "Unexpected Url");

    String empNumber = currentUrl.substring(currentUrl.lastIndexOf("/") + 1);

    employee.setEmployeeId(pimPersonalDetailsPage.getEmployeeId());
    employee.setEmpNumber(Integer.parseInt(empNumber));

    // запрос из API для текущего Employee
    String employeeDetailsPath = ConstantsClass.API_EP + ConstantsClass.PIM_EMPLOYEE_API_URL + empNumber + "/personal-details";
    GetEmployeeResponse response = OrangeHRMClient
            .getRequest(SpecConfig.requestSpecification(),
                    SpecConfig.responseSpecification(),
                    employeeDetailsPath,
                    GetEmployeeResponse.class);

    // сравнение исходного Employee с полученным через API
    assertTrue(compareUiAndApiEmployee(employee, response.getData()));

  }
}
