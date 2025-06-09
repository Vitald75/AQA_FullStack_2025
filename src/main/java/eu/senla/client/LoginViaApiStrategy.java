package eu.senla.client;

import eu.senla.core.Driver;
import org.openqa.selenium.Cookie;

public class LoginViaApiStrategy implements LoginStrategy {
  private String targetUrl;

  public LoginViaApiStrategy(String url) {
    this.targetUrl = url;
  }

  @Override
  public final void accessPage() throws Exception {
    Cookie cookie =
        new Cookie.Builder("orangehrm", AuthApi.getCookie())
            .domain("opensource-demo.orangehrmlive.com")
            .path("/web")
            .isHttpOnly(true)
            .sameSite("Lax")
            .build();

    Driver.getInstance().manage().deleteCookieNamed("orangehrm");
    Driver.getInstance().manage().addCookie(cookie);
    Driver.getInstance().get(this.targetUrl);
  }
}
