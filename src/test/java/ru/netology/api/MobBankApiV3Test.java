package ru.netology.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class MobBankApiV3Test {
    private final RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setBaseUri("http://localhost")
            .setBasePath("api/v1")
            .setPort(9999)
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    @Test
    public void shouldMakeRequest() {
        given()
                .spec(requestSpecification)
                .when()
                .get("/demo/accounts")
                .then()
                .statusCode(200);
    }

    @Test
    public void shouldMakeRequestBody() {
        given()
                .spec(requestSpecification)
                .when()
                .get("/demo/accounts")
                .then()
                .body("[0].name", equalTo("Текущий счёт"))
                .body("[1].balance", equalTo(2877210))
                .body("[2].id", equalTo(3));
    }
}
