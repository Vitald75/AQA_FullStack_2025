package eu.senla.pages;

import eu.senla.client.AuthApi;
import eu.senla.core.Driver;
import eu.senla.core.Wait;
import eu.senla.elements.SidePanel;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;

// import static eu.senla.core.Driver.driver;

@Getter
public class DashBoardPage { // extends BasePage {

  // private WebDriver driver;

  private String dashboardUrl =
      "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
  private SidePanel sidePanel;
  private final By sidePanelBody = By.cssSelector(".oxd-sidepanel-body");

  private final By userDropDownMenu = By.cssSelector("span.oxd-userdropdown-tab");
  private final By logoutMenu = By.cssSelector("a[href='/web/index.php/auth/logout']");

  public DashBoardPage() {
    // Create a cookie
//    Cookie cookie = new Cookie.Builder("orangehrm", AuthApi.getCookie())
//            .domain("opensource-demo.orangehrmlive.com")
//            .path("/")
//            .isHttpOnly(true)
//            .build();
//
//    // Add the cookie to the current domain
//    Driver.getInstance().manage().addCookie(cookie);
//    Driver.getInstance().get(dashboardUrl);
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

  public final String getUrl() {
    return Driver.getInstance().getCurrentUrl();
  }

  public final String getDashboardUrl() {
    return dashboardUrl;
  }
}
