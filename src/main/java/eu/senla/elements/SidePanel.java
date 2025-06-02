package eu.senla.elements;

import eu.senla.core.Wait;
import eu.senla.pages.PIMPage;
import eu.senla.pages.RecruitmentPage;
import org.openqa.selenium.By;

public class SidePanel {

  private final By pimPage = By.cssSelector("a[href$='viewPimModule']");
  private final By recruitmentPage =
      By.xpath("//a[@href='/web/index.php/recruitment/viewRecruitmentModule']");

  public SidePanel() {

  }

  public final PIMPage openPIMPage() {
    Wait.waitVisibilityOfElementLocated(pimPage).click();
    return new PIMPage();
  }

  public final RecruitmentPage openRecruitmentPage() {
    return new RecruitmentPage();
  }
}
