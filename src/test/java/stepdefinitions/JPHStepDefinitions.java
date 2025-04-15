package stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import utilities.ConfigReader;

import static io.restassured.RestAssured.given;

public class JPHStepDefinitions {

    String url="";
    Response response;
    JsonPath resJP;
    JSONObject reqBody;

    @Given("kullanici {string} adresine gider")
    public void kullanici_adresine_gider(String configBaseUrl) {

        url+= ConfigReader.getProperty(configBaseUrl);
    }

    @Then("kullanici path parametresi olarak {string} girer")
    public void kullanici_path_parametresi_olarak_girer(String pathParams) {
        url=url+"/"+pathParams;
    }

    @Then("kullanici bir GET request yapar ve response degerleri kaydedilir")
    public void kullanici_bir_get_request_yapar_ve_response_degerleri_kaydedilir() {
        response= given().when().get(url);
    }

}
