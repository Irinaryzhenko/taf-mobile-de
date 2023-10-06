package api;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;

public class OpenWebSiteTest {
    @Test
    public void checkOpeningWebSite() {
        when().get("https://www.mobile.de/")
                .then().log().status()
                .assertThat().statusCode(200);
    }
}
