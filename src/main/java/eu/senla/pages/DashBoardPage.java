package eu.senla.pages;

import eu.senla.core.Wait;
import lombok.Getter;
import org.openqa.selenium.By;


@Getter
public class DashBoardPage extends BasePage {

  private String dashboardUrl =
      "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";

  private final By sidePanelBody = By.cssSelector(".oxd-sidepanel-body");
  private final By userDropDownMenu = By.cssSelector("span.oxd-userdropdown-tab");
  private final By logoutMenu = By.cssSelector("a[href='/web/index.php/auth/logout']");
  private final By tile1 = By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters orangehrm-dashboard-widget'][1]//p[text()='Time at Work']");
  private final By tile2 = By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters orangehrm-dashboard-widget'][2]");
  //......
  private final By tile7 = By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters orangehrm-dashboard-widget'][7]");


  public DashBoardPage() {
    Wait.waitVisibilityOfElementLocated(sidePanelBody);
  }

  public final DashBoardPage openUserDropDownMenu() {
    Wait.waitVisibilityOfElementLocated(userDropDownMenu).click();
    return this;
  }

  public final LoginPage clickLogout() {
    Wait.waitVisibilityOfElementLocated(logoutMenu).click();
    return new LoginPage();
  }

//  public final String getDashboardUrl() {
//    return dashboardUrl;
//  }
}
