package com.it.api;

import com.it.utils.ConfigLoader;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetWeatherData {
    private ConfigLoader configLoader;

    @BeforeClass
    public void init() {
        configLoader = new ConfigLoader("testdata/api/getweather.properties");
        RestAssured.baseURI = configLoader.get("baseUrl");
    }

    @Test
    public void GetWeatherData() {
        Response response = RestAssured.given()
                .when()
                .get(configLoader.get("path"))
                .then()
                .statusCode(Integer.valueOf(configLoader.get("status.code")))
                .extract().response();
        JsonPath jsonResponse = response.jsonPath();
        Integer target_day = Integer.valueOf(configLoader.get("target_day")) - 1;
        String weatherDataArray = "weatherForecast[" + target_day + "]";
        String dayAfterTomorrowForecast = jsonResponse
                .getString(weatherDataArray);
        String date = jsonResponse.getString(weatherDataArray + ".forecastDate");
        int forecastMaxrh = jsonResponse.getInt(weatherDataArray + ".forecastMaxrh.value");
        int forecastMinrh = jsonResponse.getInt(weatherDataArray + ".forecastMinrh.value");
        System.out.println("The forecast for " + date + ": Relative Humidity is " + forecastMinrh + "% - " + forecastMaxrh + "%");
    }
}
