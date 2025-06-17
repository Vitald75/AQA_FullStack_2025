package eu.senla.elements;

import eu.senla.core.Wait;
import eu.senla.pages.DashBoardPage;
import eu.senla.pages.PIM.PIMViewEmployeeList;
import eu.senla.pages.admin.AdminMainPage;
import eu.senla.pages.PIM.PIMAddEmployeePage;
import eu.senla.pages.leave.ViewListLeavePage;
import eu.senla.pages.recruitment.RecruitmentPage;
import org.openqa.selenium.By;

public class SidePanel {

  private final By pimPage =
        By.cssSelector("a[href$='viewPimModule']");
  private final By recruitmentPage =
        By.xpath("//a[@href='/web/index.php/recruitment/viewRecruitmentModule']");
  private final By adminPage =
        By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']");
  private final By dashBoardPage =
          By.xpath("//a[@href='/web/index.php/dashboard/index']");
  private final By leavePage =
          By.xpath("//a[@href='/web/index.php/leave/viewLeaveModule']");

  public final AdminMainPage openAdminPage() {
    Wait.waitVisibilityOfElementLocated(adminPage).click();
    return new AdminMainPage();
  }

  public final PIMViewEmployeeList openPIMPage() {
    Wait.waitVisibilityOfElementLocated(pimPage).click();
    return new PIMViewEmployeeList();
  }

  public final RecruitmentPage openRecruitmentPage() {
    Wait.waitVisibilityOfElementLocated(recruitmentPage).click();
    return new RecruitmentPage();
  }

  public final ViewListLeavePage openLeavePage() {
    Wait.waitVisibilityOfElementLocated(leavePage).click();
    return new ViewListLeavePage();
  }

  public final DashBoardPage openDashBoardPage() {
    Wait.waitVisibilityOfElementLocated(dashBoardPage).click();
    return new DashBoardPage();
  }

}
