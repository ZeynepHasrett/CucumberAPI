Feature: JPH API Test

  # https://jsonplaceholder.typicode.com/posts/44 endpointine
  # bir GET request gonderdigimizde donen response’un
  # status code’unun 200 olduğunu,
  # content type degerinin "application/json; charset=utf-8 " ve
  # “title” degerinin “optio dolor molestias sit” oldugunu test edin

  Scenario: JPH GET Request

    Given kullanici "JPHUrl" adresine gider
    Then kullanici path parametresi olarak "posts/44" girer
    Then kullanici bir GET request yapar ve response degerleri kaydedilir
    Then kullanici response statusCode degerinin 200 oldugunu test eder
    Then kullanici response contentType degerinin "application/json; charset=utf-8" oldugunu test eder
    Then kullanici donen response degerini jsonPath formatinda kayit eder
    Then kullanici donen response "title" degerinin "optio dolor molestias sit" oldugunu test eder



















    #    https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body'e sahip bir
    #    PUT request yolladigimizda donen response'un
    #    status kodunun 200, content type'inin "application/json; charset=utf-8",
    #    Connection header degerinin "keep-alive"
    #    ve response body'sinin asagida verilen ile ayni oldugunu test ediniz

    #   Request Body                      Expected Data :
    #   {                                     {
    #    "title": "Ahmet",                      "title": "Ahmet",
    #    "body": "Merhaba",                     "body": "Merhaba",
    #    "userId": 10,                          "userId": 10,
    #    "id": 70                               "id": 70
    #   }                                     }

  Scenario: PUT Request

