package eu.senla.pages;

import eu.senla.core.ReadPropertiesFile;
import eu.senla.core.Wait;
import eu.senla.elements.SidePanel;
import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class DashBoardPage extends BasePage { // extends BasePage {

  private String dashboardUrl = ReadPropertiesFile.getProperty("DASHBOARD_URL");
  private SidePanel sidePanel;
  private final By sidePanelBody = By.cssSelector(".oxd-sidepanel-body");

  private final By userDropDownMenu = By.cssSelector("span.oxd-userdropdown-tab");
  private final By logoutMenu = By.cssSelector("a[href='/web/index.php/auth/logout']");

  public DashBoardPage() {
    Wait.waitVisibilityOfElementLocated(sidePanelBody);
    this.sidePanel = new SidePanel();
  }

  public final DashBoardPage openUserDropDownMenu() {
    Wait.waitVisibilityOfElementLocated(userDropDownMenu).click();
    return this;
  }

  public final LoginPage clickLogout() {
    Wait.waitVisibilityOfElementLocated(logoutMenu).click();
    return new LoginPage();
  }
}
