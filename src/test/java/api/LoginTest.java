package api;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class LoginTest {
    @Test
    public void checkloginWithInvalidCredentials() {
        String requestBode = "{\n" +
                "    \"email\": \"test@gmail.com\",\n" +
                "    \"password\": \"1q@W3e4r\",\n" +
                "    \"privacy\": true,\n" +
                "    \"generalTermsApproved\": true,\n" +
                "    \"privacySettings\": [\n" +
                "        \"ALLOW_MARKET_RESEARCH\",\n" +
                "        \"ALLOW_MARKETING_ACTIVITIES\"\n" +
                "    ]\n" +
                "}";
        given().body(requestBode).header("x-mobile-client", "de.mobile.cis")
                .when().post("https://www.mobile.de/api/my/account")
                .then().statusCode(400)
                .assertThat().body("field", equalTo("email"))
                .body("code", equalTo("account-exists"))
                .body("message", equalTo("Diese E-Mail-Adresse ist bereits registriert."));
    }

    @Test
    public void checkloginWithEmptyEmailAndEnyPassword() {
        String requestBode = "{\n" +
                "\"email\": \"\",\n" +
                "\"password\": \"1q@W3e4r\",\n" +
                "\"privacy\": true,\n" +
                "\"generalTermsApproved\": true,\n" +
                "\"privacySettings\": [\n" +
                "\"ALLOW_MARKET_RESEARCH\",\n" +
                "\"ALLOW_MARKETING_ACTIVITIES\"\n" +
                "]\n" +
                "}";
        given().body(requestBode).header("x-mobile-client", "de.mobile.cis")
                .when().post("https://www.mobile.de/api/my/account")
                .then().statusCode(400)
                .assertThat().body("[0].field", equalTo("email"))
                .body("[0].code", equalTo("email-empty"))
                .body("[0].message", equalTo("Bitte geben Sie eine E-Mail-Adresse ein."))
                .body("[1].field", equalTo("email"))
                .body("[1].code", equalTo("email-invalid"))
                .body("[1].message", equalTo("Die eingegebene E-Mail-Adresse ist ungültig."));
    }

    @Test
    public void checkloginWithEmptyPasswordAndAnyEmail() {
        String requestBode = "{\n" +
                "\"email\": \"test1234523434@gmail.com\",\n" +
                "\"password\": \"\",\n" +
                "\"privacy\": true,\n" +
                "\"generalTermsApproved\": true,\n" +
                "\"privacySettings\": [\n" +
                "\"ALLOW_MARKET_RESEARCH\",\n" +
                "\"ALLOW_MARKETING_ACTIVITIES\"\n" +
                "]\n" +
                "}";
        given().body(requestBode).header("x-mobile-client", "de.mobile.cis")
                .when().post("https://www.mobile.de/api/my/account")
                .then().statusCode(400)
                .assertThat().body("field", equalTo("password"))
                .body("code", equalTo("password-empty"))
                .body("message", equalTo("Bitte gib ein Passtwort ein."));
    }
}
