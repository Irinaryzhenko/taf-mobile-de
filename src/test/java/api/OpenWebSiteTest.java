package api;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;


public class OpenWebSiteTest {
     @Test
    public void checkOpeningWebSite() {

        given().header("User-Agent", "PostmanRuntime/7.33.0").header("Content-Type", "text/html")
                .when().get("https://www.mobile.de/")
                .then().log().status()
                .assertThat().statusCode(200);
        }
}
