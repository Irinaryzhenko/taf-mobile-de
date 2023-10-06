package api;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SelectCarTest {
    @Test
    public void checkSelectingCarById() {
        String requestBode = "{\n" +
                "\"adId\": \"367152267\",\n" +
                "\"ref\": null,\n" +
                "\"refId\": null\n" +
                "}";
        given().body(requestBode).header("x-mobile-vi", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjaWQiOiJmZDM5MWZjMS00YmI3LTRkZjQt\n" +
                "YTUxMS04YWIxNTJkOTRiZDIiLCJpYXQiOjE2Nzg4OTg3OTh9.4i0QiqIXw9FZOhuJQNs38\n" +
                "I2pUL99pQgmEaOjwkCO4NY")
                .when().post("https://suchen.mobile.de/fahrzeuge/svc/my/parkings/367152267")
                .then().statusCode(201)
                .assertThat().body("adId", equalTo(367152267));
    }
}
