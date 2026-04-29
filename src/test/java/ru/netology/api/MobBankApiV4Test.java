package ru.netology.api;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class MobBankApiV4Test {

    @Test
    public void shouldMakeRequest() {
        given()
                .baseUri("http://localhost:9999/api/v1")
                .when()
                .log()
                .all()
                .get("/demo/accounts")
                .then()
                .log()
                .all()
                .header("Content-Length", "433")
                .contentType(ContentType.JSON);
    }
}
