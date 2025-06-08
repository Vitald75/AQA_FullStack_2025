package eu.senla.client;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import lombok.experimental.UtilityClass;
import io.restassured.*;



@UtilityClass
public class SpecConfig {
    public static RequestSpecification requestSpecification() {
        return new RequestSpecBuilder().setBaseUri(eu.senla.core.ReadPropertiesFile.getProperty("MAIN_AUTH_URI"))
                .setAuth(RestAssured.basic(eu.senla.core.ReadPropertiesFile.getProperty("USERNAME"),
                        eu.senla.core.ReadPropertiesFile.getProperty("PASSWORD")))
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }

    public static ResponseSpecification responseSpecification() {
        return new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .expectStatusCode(200)
                .build();
    }
}
