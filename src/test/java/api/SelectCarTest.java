package api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SelectCarTest {
    public static Logger logger = LoggerFactory.getLogger(SelectCarTest.class);
    @Test
    public void checkSelectingCarById() {
                String requestBode = "{\n" +
                "\"adId\": \"367152267\",\n" +
                "\"ref\": null,\n" +
                "\"refId\": null\n" +
                "}";
        int carId = 367152267;

        given().body(requestBode).header("User-Agent", "PostmanRuntime/7.33.0")
                .headers("content-type", "application/json; charset=utf-8")
                .header("x-mobile-vi", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjaWQiOiJmZDM5MWZjMS00YmI3LTRkZjQtYTUxMS04YWIxNTJkOTRiZDIiLCJpYXQiOjE2Nzg4OTg3OTh9.4i0QiqIXw9FZOhuJQNs38I2pUL99pQgmEaOjwkCO4NY")
                .when().post("https://suchen.mobile.de/fahrzeuge/svc/my/parkings/367152267")
                .then().statusCode(201)
                .assertThat().body("adId", equalTo(carId));
        logger.info("hello");
        }
}
