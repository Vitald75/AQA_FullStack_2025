package eu.senla.client;

import eu.senla.core.ReadPropertiesFile;
import io.restassured.RestAssured;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

//@UtilityClass
public class AuthApi {
  public static String getCookie() {
    String token = "";
    // first get request /login
    Response firstResponse =
        RestAssured.given()
            .when()
            .get(eu.senla.core.ReadPropertiesFile.getProperty("MAIN_AUTH_URI") + "/login");

    String htmlContent = firstResponse.asString();
    Document doc = Jsoup.parse(htmlContent);

    // Find the <auth-login> element
    Element authLogin = doc.selectFirst("auth-login");
    if (authLogin != null) {
      token = authLogin.attr(":token");
      token = token.substring(1, token.length() - 1);
      System.out.println("Token value: " + token);
    } else {
      System.out.println("<auth-login> element not found");
    }
    // Get value of cookie from first response
    String initialCookie = firstResponse.getDetailedCookie("orangehrm").getValue();

    // second post request /validate
    final int responseCode = 302;
    ValidatableResponse secondResponse =
        RestAssured.given()
            .cookie("orangehrm", initialCookie)
            .contentType("application/x-www-form-urlencoded; charset=UTF-8")
            .formParam("_token", token)
            .formParam("username", ReadPropertiesFile.getProperty("USERNAME"))
            .formParam("password", ReadPropertiesFile.getProperty("PASSWORD"))
            .log()
            .all()
            .when()
            .post(ReadPropertiesFile.getProperty("MAIN_AUTH_URI") + "/validate")
            .then()
            .log()
            .all()
            .statusCode(responseCode);

    Cookie validateCookie = secondResponse.extract().detailedCookie("orangehrm");

    return validateCookie.getValue();
  }
}
