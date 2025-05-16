package stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
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

            url=url+"/"+pathParams;
    }

    @Then("kullanici query parametresi olark il degerine {string} ilce degerine {string} girer")
    public void kullaniciQueryParametresiOlarkIlDegerineIlceDegerineGirer(String il, String ilce) {
        url=url+"?il="+il+"&ilce="+ilce;
    }

    @Then("kullanici gereki header degerleri ile bir GET request yapar")
    public void kullaniciGerekiHeaderDegerleriIleBirGETRequestYapar() {
        response= RestAssured.given().header("authorization","apikey 2ecC1yGMUbcPi9V1YuXKJ5:2TLu6uoUy3ZDCvIS2xIsOu").when().get(url);
    }

    @Then("kullanici donen response degerini yazdrir")
    public void kullaniciDonenResponseDegeriniYazdrir() {
        response.prettyPrint();
    }
}
