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
public class AuthHelper {

  private static String[] getInitialCookie() {
    String[] arrayOfValues = new String[2];
    String token = "";
    // first get request /login
    String ss = eu.senla.core.ReadPropertiesFile.getProperty("BASE_URL") + "/auth/login";

    Response firstResponse =
            RestAssured.given()
                    .when()
                    .get(eu.senla.core.ReadPropertiesFile.getProperty("BASE_URL") + "/auth/login");

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
    arrayOfValues[0] = firstResponse.getDetailedCookie("orangehrm").getValue();
    arrayOfValues[1] = token;

    return arrayOfValues;
  }

  public static String getCookie() {

    final int responseCode = 302;
    final String[] arrayOfValues = getInitialCookie(); // [0] - cookie, [1] - token

    ValidatableResponse secondResponse =
        RestAssured.given()
            .cookie("orangehrm", arrayOfValues[0])
            .contentType("application/x-www-form-urlencoded; charset=UTF-8")
            .formParam("_token", arrayOfValues[1])
            .formParam("username", ReadPropertiesFile.getProperty("USERNAME"))
            .formParam("password", ReadPropertiesFile.getProperty("PASSWORD"))
            .log()
            .all()
            .when()
            .post(ReadPropertiesFile.getProperty("BASE_URL") + "/auth/validate")
            .then()
            .log()
            .all()
            .statusCode(responseCode);

    Cookie validateCookie = secondResponse.extract().detailedCookie("orangehrm");

    return validateCookie.getValue();
  }
}
