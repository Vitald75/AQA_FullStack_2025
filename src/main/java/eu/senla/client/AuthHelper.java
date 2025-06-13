package eu.senla.client;

import eu.senla.core.ReadPropertiesFile;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import static io.restassured.RestAssured.given;


//@UtilityClass
public class AuthHelper {

  private static String[] getInitialCookie() {
    String[] arrayOfValues = new String[2];
    String token = "";
    // first get request /login

    Response firstResponse = OrangeHRMClient.getRequest(eu.senla.core.ReadPropertiesFile.getProperty("BASE_URL")
            + "/auth/login");

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
    // Get value of cookie from the first response
    arrayOfValues[0] = firstResponse.getDetailedCookie("orangehrm").getValue();
    arrayOfValues[1] = token;

    return arrayOfValues;
  }

  public static String getCookie() {

    final int responseCode = 302;
    final String[] arrayOfValues = getInitialCookie(); // [0] - cookie, [1] - token

    RequestSpecification requestPostSpecification = given()
            .cookie("orangehrm", arrayOfValues[0])
            .contentType("application/x-www-form-urlencoded; charset=UTF-8")
            .formParam("_token", arrayOfValues[1])
            .formParam("username", ReadPropertiesFile.getProperty("USERNAME"))
            .formParam("password", ReadPropertiesFile.getProperty("PASSWORD"))
            .log()
            .all();

    ValidatableResponse secondResponse = OrangeHRMClient.postRequest(requestPostSpecification,
            ReadPropertiesFile.getProperty("BASE_URL") + "/auth/validate");
    secondResponse.statusCode(responseCode);

    Cookie validateCookie = secondResponse.extract().detailedCookie("orangehrm");

    return validateCookie.getValue();
  }
}
