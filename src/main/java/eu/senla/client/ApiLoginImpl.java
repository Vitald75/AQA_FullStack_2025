package eu.senla.client;

import eu.senla.core.Driver;
import org.openqa.selenium.Cookie;

public class ApiLoginImpl implements LoginStrategy {
  private String targetUrl;

  public ApiLoginImpl(String url) {
    this.targetUrl = url;
  }

  @Override
  public final void login() {
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
