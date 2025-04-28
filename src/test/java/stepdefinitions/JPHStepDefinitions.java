package stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import utilities.ConfigReader;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JPHStepDefinitions {

    String url = "";
    Response response;
    JsonPath resJP;
    JSONObject reqBody;

    @Given("kullanici {string} adresine gider")
    public void kullanici_adresine_gider(String configBaseUrl) {

        url += ConfigReader.getProperty(configBaseUrl);
    }

    @Then("kullanici path parametresi olarak {string} girer")
    public void kullanici_path_parametresi_olarak_girer(String pathParams) {
        url = url + "/" + pathParams;
    }

    @Then("kullanici bir GET request yapar ve response degerleri kaydedilir")
    public void kullanici_bir_get_request_yapar_ve_response_degerleri_kaydedilir() {
        response = given().when().get(url);
    }

    @Then("kullanici response statusCode degerinin {int} oldugunu test eder")
    public void kullanici_response_status_code_degerinin_oldugunu_test_eder(int expStatusCode) {
        assertEquals(expStatusCode, response.getStatusCode());
    }

    @Then("kullanici response contentType degerinin {string} oldugunu test eder")
    public void kullanici_response_content_type_degerinin_oldugunu_test_eder(String expContentType) {
        assertEquals(expContentType, response.getContentType());
    }

    @Then("kullanici donen response degerini jsonPath formatinda kayit eder")
    public void kullanici_donen_response_degerini_json_path_formatinda_kayit_eder() {
        resJP = response.jsonPath();
    }

    @Then("kullanici donen response {string} degerinin {string} oldugunu test eder")
    public void kullanici_donen_response_degerinin_oldugunu_test_eder(String expKey, String expValue) {
        assertEquals(expValue, resJP.getString(expKey));
    }

    @Then("kullanici POST request yapmak icin {string},{string},{int} {int} degerleri ile reqBody hazirlar")
    public void kullanici_post_request_yapmak_icin_degerleri_ile_req_body_hazirlar(String title, String body, Integer userId, Integer id) {
        reqBody = new JSONObject();
        reqBody.put("title", title);
        reqBody.put("body", body);
        reqBody.put("userId", userId);
        reqBody.put("id", id);
    }

    @Then("kullanici POST request yaparak response degerini kaydeder")
    public void kullanici_post_request_yaparak_response_degerini_kaydeder() {

        response = RestAssured.given().contentType(ContentType.JSON).when().body(reqBody.toString()).put(url);
    }

    @Then("kullanici {string} header degerinin {string} oldugunu test eder")
    public void kullanici_header_degerinin_oldugunu_test_eder(String expHeaderkey, String expHeaderValue) {
        assertEquals(expHeaderValue,response.getHeader(expHeaderkey));
    }

    @Then("kullanici userid degerinin {int} oldugunu test eder")
    public void kullanici_userid_degerinin_oldugunu_test_eder(int expUserId) {
        assertEquals(expUserId,resJP.getInt("userId"));
    }

}
