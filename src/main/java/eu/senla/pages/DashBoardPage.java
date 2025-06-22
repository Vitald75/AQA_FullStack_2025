package eu.senla.pages;

import eu.senla.core.Wait;
import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class DashBoardPage extends BasePage {

  @Getter
  private String ownPageUrl =
      "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";

  private final By sidePanelBody = By.cssSelector(".oxd-sidepanel-body");
  private final By userDropDownMenu = By.cssSelector("span.oxd-userdropdown-tab");
  private final By logoutMenu = By.cssSelector("a[href='/web/index.php/auth/logout']");
  private final By tileTimeAtWork = By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters orangehrm-dashboard-widget']"
          + "//p[text()='Time at Work']");
  private final By tileMyActions = By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters orangehrm-dashboard-widget']"
          + "//p[text()='Time at Work']");
  private final By tileQuickLaunch = By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters orangehrm-dashboard-widget']"
          + "//p[text()='Quick Launch']");
  private final By tileBuzzLatestPosts = By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters orangehrm-dashboard-widget']"
          + "//p[text()='Buzz Latest Posts']");
  private final By tileEmployeesOnLeave = By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters orangehrm-dashboard-widget']"
          + "//p[text()='Employees on Leave Today']");
  private final By tileEmployeeBySubUnit = By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters orangehrm-dashboard-widget']"
          + "//p[text()='Employee Distribution by Sub Unit1']");
  private final By tileEmployeeByLocation = By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters orangehrm-dashboard-widget']"
          + "//p[text()='Employee Distribution by Location']");


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

  public final Boolean isTimeAtWorkDisplayed() {
    return isElementDisplayed(tileTimeAtWork);
  }

  public final Boolean isMyActionDisplayed() {
    return isElementDisplayed(tileMyActions);
  }

  public final Boolean isQuickLaunchDisplayed() {
    return isElementDisplayed(tileQuickLaunch);
  }

  public final Boolean isBuzzLatestPostsDisplayed() {
    return isElementDisplayed(tileBuzzLatestPosts);
  }

  public final Boolean isEmployeesOnLeaveDisplayed() {
    return isElementDisplayed(tileEmployeesOnLeave);
  }

  public final Boolean isEmployeeBySubUnitDisplayed() {
    return isElementDisplayed(tileEmployeeBySubUnit);
  }

  public final Boolean isEmployeeByLocationDisplayed() {
    return isElementDisplayed(tileEmployeeByLocation);
  }

}
