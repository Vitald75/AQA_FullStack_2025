package eu.senla;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.github.javafaker.Faker;
import eu.senla.client.OrangeHRMClient;
import eu.senla.client.SpecConfig;
import eu.senla.data.EmployeeApi;
import eu.senla.data.GetEmployeeRequest;
import eu.senla.elements.SidePanel;
import eu.senla.data.Employee;
import eu.senla.pages.PIM.PIMAddEmployeePage;
import eu.senla.pages.PIM.PIMPersonalDetailsPage;
import eu.senla.pages.PIM.PIMViewEmployeeList;
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

  final boolean compareUiAndApiEmployee(Employee employeeUi, EmployeeApi employeeApi) {
    return employeeApi.getFirstName().equals(employeeUi.getFirstName())
            && employeeApi.getLastName().equals(employeeUi.getLastName())
            && employeeApi.getEmpNumber().equals(employeeUi.getEmpNumber())
            && employeeApi.getNationality().getName().equals(employeeUi.getNationality())
            && (employeeApi.getGender() == employeeUi.getGender())
            && employeeApi.getBirthday().equals(employeeUi.getBirthday());

  }

  @SneakyThrows
  @DisplayName("Успешное добавление PIM employee")
  @Test
  @Tag("smoke")
  public void testPimAddEmployee() {

    //new SidePanel().openPIMPage();

    PIMAddEmployeePage pimAddEmployeePage = new SidePanel()
            .openPIMPage()
            .clickAddEmployeeButton()
            .fillNewEmployeeForm(employee)
            .clickSubmit()
            .isConfirmed()
            .isPersonalInformationPage();

    String currentUrl = pimAddEmployeePage.getCurrentUrl();
    assertTrue(
        currentUrl.contains(
            "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewPersonalDetails/empNumber"),
        "Unexpected Url");
    //int position = currentUrl.lastIndexOf("/");

    PIMPersonalDetailsPage pimPersonalDetailsPage = new PIMPersonalDetailsPage()
            .inputDriversLicenseId("888888")
            .inputDriversLicenseExpDate("2025-01-01")
            .inputDateOfBirth("2000-01-01")
            .chooseMartialStatus("Single")
            .chooseNationality()
            //.clickFemaleGender()
            .saveFirstBlock()
            .isConfirmed() ;



    String emp_number = currentUrl.substring(currentUrl.lastIndexOf("/")+1);
    System.out.println(emp_number);




    //return emp_number;
  }

  @SneakyThrows
  @DisplayName("Проверка данных формы PIM employee details c API ответом")
  @Test
  @Tag("smoke")
  public void testPimEmployeeDetails() {

    PIMPersonalDetailsPage pimPersonalDetailsPage =
                    new SidePanel()
                    .openPIMPage()
                    .clickFoursEmployee();

    String currentUrl = pimPersonalDetailsPage.getCurrentUrl();

    assertTrue(
            currentUrl.contains(
                    "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewPersonalDetails/empNumber"),
            "Unexpected Url");

    String emp_number = currentUrl.substring(currentUrl.lastIndexOf("/")+1);
    System.out.println(emp_number);


    String employeeDetailsPath = "/web/index.php/api/v2/pim/employees/" + emp_number + "/personal-details";
    GetEmployeeRequest response = OrangeHRMClient
            .getRequest(SpecConfig.requestSpecification(),
                    SpecConfig.responseSpecification(),
                    employeeDetailsPath,
                    GetEmployeeRequest.class);

    pimPersonalDetailsPage.isPersonalDetailsDisplayed(response.getData().getEmployeeId());

    //build employee from UI
    Employee employeeUi =
            Employee.builder()
                    .firstName(pimPersonalDetailsPage.getEmployeeFirstName())
                    .middleName(pimPersonalDetailsPage.getEmployeeMiddleName())
                    .lastName(pimPersonalDetailsPage.getEmployeeLastName())
                    .employeeId(pimPersonalDetailsPage.getEmployeeId())
                    .empNumber(Integer.parseInt(emp_number))
                    .otherId(pimPersonalDetailsPage.getOtherId())
                    .birthday(pimPersonalDetailsPage.getBirthday())
                    .drivingLicenseNo(pimPersonalDetailsPage.getDriverLicenseNubmer())
                    .drivingLicenseExpiredDate(pimPersonalDetailsPage.getDriverLicenseExpDate())
                    .maritalStatus(pimPersonalDetailsPage.getMartialStatus())
                    .gender(pimPersonalDetailsPage.getGender())
                    .nationality(pimPersonalDetailsPage.getNationality())
                    .build();

    assertTrue(compareUiAndApiEmployee(employeeUi, response.getData()));

    System.out.println("-------------------------");
    System.out.println(employeeUi.getFirstName());
    System.out.println(employeeUi.getMiddleName());
    System.out.println(employeeUi.getLastName());
    System.out.println(employeeUi.getEmployeeId());
    System.out.println(employeeUi.getEmpNumber());
    System.out.println(employeeUi.getOtherId());
    System.out.println(employeeUi.getGender());
    System.out.println(employeeUi.getNationality());
    System.out.println("-------------------------");

    //return emp_number;

//    System.out.println("Data from UI: " + uiEmployeeId + " " + uiFirstName + " " + uiLastName);

    System.out.println(response.getData().getEmpNumber());
    System.out.println(response.getData().getFirstName());

  }


}
