package eu.senla.client;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import lombok.experimental.UtilityClass;
import static io.restassured.RestAssured.given;

@UtilityClass
public class OrangeHRMClient {

    public static Response getRequest(String url) {
        return given()
                .when()
                .get(url);
    }

    public static <T> T getRequest(RequestSpecification requestSpecification,
                                   ResponseSpecification responseSpecification,
                                   String path,
                                   Class<T> clazz) {

        return
                given()
                        .spec(requestSpecification)
                        .basePath(path)
                        .when()
                        .get()
                        .then()
                        .spec(responseSpecification)
                        .extract()
                        .as(clazz);

    }

    public static ValidatableResponse postRequest(RequestSpecification reqSpec, String url) {
        return   reqSpec
                .when()
                .post(url)
                .then()
                .log()
                .all();
    }

}

///**
// * Здесь описать сами рестовые вызовы
// * Что это даст
// * У тебя все было налеплено в один класс AuthApi
// * Но если ты разделишь обязанности и сделаешь класс который будет вызывать апи этого приложения
// * то ты сможешь и тестовые данные легко создать через апи (например для удаления чего-либо)
// * Пример: Через апи создал, через UI удалил
// */
