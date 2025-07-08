package eu.senla;

import com.github.javafaker.Faker;
import eu.senla.client.AuthHelper;
import eu.senla.client.OrangeHRMClient;
import eu.senla.core.ConstantsClass;
import eu.senla.dataUi.Employee;
import eu.senla.dataApi.LeaveEntitlementRequest;
import eu.senla.elements.SidePanel;
import eu.senla.pages.PIM.PIMAddEmployeePage;
import eu.senla.pages.leave.AssignLeavePage;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class AssignLeaveTest extends BaseTest {

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

    final void setLeaveBalance(String days) {

        LeaveEntitlementRequest leaveEntitlement = new LeaveEntitlementRequest(employee.getEmpNumber(),
                7, "2025-01-01", "2025-12-31", days);

        // начисляем Leave Balance
        RequestSpecification requestPostSpecification = given()
                .cookie("orangehrm", AuthHelper.getCookie())
                .contentType(ContentType.JSON)
                .body(leaveEntitlement)
                .log()
                .all();

        ValidatableResponse resp = OrangeHRMClient.postLeaveEntitlementRequest(
                requestPostSpecification, ConstantsClass.MAIN_URL + ConstantsClass.API_EP + ConstantsClass.LEAVE_API_URL);
    }

    @Test
    @DisplayName("Успешный Assign Leave")
    @Tag("smoke")
    @Tag("leave")
    public void testPositiveAssignLeave() {

        //добавление нового PIM Employee
        PIMAddEmployeePage pimAddEmployeePage = new PIMAddEmployeePage();
        pimAddEmployeePage.addPIMEmployeeSuccessful(employee);

        assertTrue(
                pimAddEmployeePage.getCurrentUrl().contains(ConstantsClass.MAIN_URL
                        + ConstantsClass.WEB_EP + ConstantsClass.PIM_DETAILS_URL),
                "Unexpected Url");

        setLeaveBalance("22");

        Boolean isAssignConfirmed =
                new SidePanel()
                        .openLeavePage()
                        .clickAssignLeaveMenu()
                        .selectEmployee(employee.getFirstName() + " " + employee.getMiddleName() + " " + employee.getLastName())
                        .selectLeaveType("CAN - FMLA")
                        .inputDateFrom("2025-01-06")
                        .inputDateTo("2025-07-06")
                        .clickAssignButton()
                        .isConfirmed();

        assertTrue(isAssignConfirmed, "Assing wasn't confirmed");
    }

    @Test
    @DisplayName("Проверка формы Assign Leave незаполненные Required fields")
    @Tag("extended")
    @Tag("leave")
    public void testNegativeAssignLeaveRequiredFields() {

        //добавление нового PIM Employee
        PIMAddEmployeePage pimAddEmployeePage = new PIMAddEmployeePage();
        pimAddEmployeePage.addPIMEmployeeSuccessful(employee);

        assertTrue(
                pimAddEmployeePage.getCurrentUrl().contains(ConstantsClass.MAIN_URL
                        + ConstantsClass.WEB_EP + ConstantsClass.PIM_DETAILS_URL),
                "Unexpected Url");

        setLeaveBalance("22");

        AssignLeavePage assignLeavePage =
                new SidePanel()
                        .openLeavePage()
                        .clickAssignLeaveMenu()
                        .clickAssignButton()
                        .isEmployeeNameRequired()
                        .isLeaveTypeRequired()
                        .isFromDateRequired()
                        .isToDateRequired();

        System.out.println(" ");

        assertTrue(assignLeavePage.getCurrentUrl().contains(assignLeavePage.getOwnPageUrl()), "Wrong Url");
    }

    @Test
    @DisplayName("Проверка формы Assign Leave Balance not sufficient")
    @Tag("extended")
    @Tag("leave")
    public void testNegativeAssignLeaveNotSufficientBalance() {

        //добавление нового PIM Employee
        PIMAddEmployeePage pimAddEmployeePage = new PIMAddEmployeePage();
        pimAddEmployeePage.addPIMEmployeeSuccessful(employee);

        assertTrue(
                pimAddEmployeePage.getCurrentUrl().contains(ConstantsClass.MAIN_URL
                        + ConstantsClass.WEB_EP + ConstantsClass.PIM_DETAILS_URL),
                "Unexpected Url");

        setLeaveBalance("7");

        Boolean isAssignButtonDisabled =
                new SidePanel()
                        .openLeavePage()
                        .clickAssignLeaveMenu()
                        .selectEmployee(employee.getFirstName() + " " + employee.getMiddleName() + " " + employee.getLastName())
                        .selectLeaveType("CAN - FMLA")
                        .inputDateFrom("2025-01-06")
                        .inputDateTo("2025-20-06")
                        .inputComments("some comments")
                        .isNotEnoughBalance()
                        .isAssignButtonDisabled();

        System.out.println(" ");

        assertTrue(isAssignButtonDisabled, "Assign button is enabled, though it shouldn't be");
    }

    @Test
    @DisplayName("Проверка формы Assign Leave FromDate more than ToDate")
    @Tag("extended")
    @Tag("leave")
    public void testNegativeAssignLeaveWrongDates() {

        //добавление нового PIM Employee
        PIMAddEmployeePage pimAddEmployeePage = new PIMAddEmployeePage();
        pimAddEmployeePage.addPIMEmployeeSuccessful(employee);

        assertTrue(
                pimAddEmployeePage.getCurrentUrl().contains(ConstantsClass.MAIN_URL
                        + ConstantsClass.WEB_EP + ConstantsClass.PIM_DETAILS_URL),
                "Unexpected Url");

        setLeaveBalance("22");

        Boolean isWrongDate =
                new SidePanel()
                        .openLeavePage()
                        .clickAssignLeaveMenu()
                        .selectEmployee(employee.getFirstName() + " " + employee.getMiddleName() + " " + employee.getLastName())
                        .selectLeaveType("CAN - FMLA")
                        .inputDateFrom("2025-01-06")
                        .inputDateTo("2025-20-05")
                        .inputComments("some comments")
                        .isWrongDates();


        assertTrue(isWrongDate, "Assign button is enabled, though it shouldn't be");
    }
}
