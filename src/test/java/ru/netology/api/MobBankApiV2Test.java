package ru.netology.api;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class MobBankApiV2Test {

    @Test
    public void shouldMatchResponseBody() {
        given()
                .baseUri("http://localhost:9999/api/v1")
                .when()
                .log()
                .all()
                .get("/demo/accounts")
                .then()
                .log()
                .all()
                .body("[0].id", equalTo(1))
                .body("[0].name", equalTo("Текущий счёт"))
                .body("[0].number", equalTo("•• 0668"))
                .body("[0].balance", equalTo(992821429))
                .body("[0].currency", equalTo("RUB"));
    }
}
