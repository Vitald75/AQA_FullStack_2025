package eu.senla.elements;

import eu.senla.core.Wait;
import eu.senla.pages.admin.AdminMainPage;
import eu.senla.pages.PIMPage;
import eu.senla.pages.RecruitmentPage;
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




  public SidePanel() {
  }

  public final AdminMainPage openAdminPage() {
    Wait.waitVisibilityOfElementLocated(adminPage).click();
    return new AdminMainPage();
  }

  public final PIMPage openPIMPage() {
    Wait.waitVisibilityOfElementLocated(pimPage).click();
    return new PIMPage();
  }

  public final RecruitmentPage openRecruitmentPage() {
    Wait.waitVisibilityOfElementLocated(recruitmentPage).click();
    return new RecruitmentPage();
  }
}
