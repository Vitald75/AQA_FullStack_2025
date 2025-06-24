package eu.senla.client;

import eu.senla.core.ConstantsClass;
import eu.senla.core.ReadPropertiesFile;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import lombok.experimental.UtilityClass;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import static io.restassured.RestAssured.given;


@UtilityClass
public final class AuthHelper {

  private String[] getInitialCookie() {
    String[] arrayOfValues = new String[2];
    String token = "";
    // first step - get request /login

    Response firstResponse = OrangeHRMClient.getRequest(ConstantsClass.MAIN_URL
            + ConstantsClass.WEB_EP + ConstantsClass.AUTH_LOGIN_URL);

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

  public  String getCookie() {

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

    ValidatableResponse secondResponse = OrangeHRMClient.postValidateRequest(requestPostSpecification,
            ConstantsClass.MAIN_URL + ConstantsClass.WEB_EP + ConstantsClass.AUTH_VALIDATE_URL);
    secondResponse.statusCode(responseCode);

    Cookie validateCookie = secondResponse.extract().detailedCookie("orangehrm");

    return validateCookie.getValue();
  }
}
