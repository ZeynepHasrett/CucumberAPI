package stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import utilities.ConfigReader;

public class JPHStepDefinitions {

    String url="";
    Response response;
    JsonPath resJP;
    JSONObject reqBody;

    @Given("kullanici {string} adresine gider")
    public void kullanici_adresine_gider(String configBaseUrl) {

        url+= ConfigReader.getProperty(configBaseUrl);
    }

}
