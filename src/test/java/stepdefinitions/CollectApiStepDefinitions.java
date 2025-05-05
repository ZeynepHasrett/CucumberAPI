package stepdefinitions;

import io.cucumber.java.en.Given;
import io.restassured.response.Response;

public class CollectApiStepDefinitions {

    String url="";
    Response response;

    @Given("kullanici sorgu icin {string} adresine gider")
    public void kullaniciSorguIcinAdresineGider(String configBaseUrl) {
        url+= ConfigReader.getProperty(configBaseUrl);
    }

}
