import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

public class ApiTestPostman {
    @Test
    void shouldSendPostRequest() {
        given()
                .baseUri("https://postman-echo.com")
                .contentType("application/json; charset=UTF-8")
                .body("Hello, world!")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo("Hello, world!"))
                .contentType(ContentType.JSON)
                ;
    }
}
