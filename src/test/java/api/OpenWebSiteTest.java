package api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;


public class OpenWebSiteTest {
    private static final Logger logger = LoggerFactory.getLogger(OpenWebSiteTest.class);
    @Test
    public void checkOpeningWebSite() {
        logger.info("Page opens");
        given().header("User-Agent", "PostmanRuntime/7.33.0").header("Content-Type", "text/html")
                .when().get("https://www.mobile.de/")
                .then().log().status()
                .assertThat().statusCode(200);
        }
}
