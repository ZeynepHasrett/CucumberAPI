package stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import utilities.ConfigReader;

public class CollectApiStepDefinitions {

    String url = "";
    Response response;

    @Given("kullanici sorgu icin {string} adresine gider")
    public void kullaniciSorguIcinAdresineGider(String configBaseUrl) {
        url += ConfigReader.getProperty(configBaseUrl);
    }

    @Then("kullanici sorgu icin pathparametresi olarak {string} girer")
    public void kullaniciSorguIcinPathparametresiOlarakGirer(String pathParams) {


    }

}
