package eu.senla.client;

import eu.senla.core.ReadPropertiesFile;
import io.restassured.RestAssured;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import lombok.experimental.UtilityClass;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

@UtilityClass
public class Auth {

    public static String getCookie() {
        String token = "";
        Response firstResponse = RestAssured.given()
                .when()
                .get(eu.senla.core.ReadPropertiesFile.getProperty("MAIN_AUTH_URI") + "/login");


        // Get the response body as String
        String htmlContent = firstResponse.asString();
        // Parse HTML with Jsoup
        Document doc = Jsoup.parse(htmlContent);

        // Find the <auth-login> element
        Element authLogin = doc.selectFirst("auth-login");
        if (authLogin != null) {
            // Extract the value of :token attribute
            token = authLogin.attr(":token");
            token = token.substring(1,token.length()-1);
            System.out.println("Token value: " + token);
        } else {
            System.out.println("<auth-login> element not found");
        }

        // Get value of cookie from first response
        String initialCookie = firstResponse.getDetailedCookie("orangehrm").getValue();

        //-----------------------
        //Cookie requestValidateCookies = new Cookie("", getFirstCookie());
        ValidatableResponse secondResponse = RestAssured.given()
                .cookie("orangehrm", initialCookie)
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .formParam("_token", token)
                .formParam("username", ReadPropertiesFile.getProperty("USERNAME"))
                .formParam("password",  ReadPropertiesFile.getProperty("PASSWORD"))
                .log().all()
                .when()
                .post(ReadPropertiesFile.getProperty("MAIN_AUTH_URI") + "/validate")
                .then().log().all().statusCode(302);

        Cookie validateCookie = secondResponse.extract().detailedCookie("orangehrm");

        String validateCookieString = validateCookie.getValue();
        System.out.println("----------------------------");
        System.out.println(validateCookie);

        return validateCookieString;
    }

}
