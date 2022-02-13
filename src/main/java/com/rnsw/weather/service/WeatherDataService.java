package com.rnsw.weather.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.rnsw.weather.client.WeatherDataClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherDataService {

    private final String apiKey = "051229fd4adc5fefe9d754915cd1fd9a";

    @Autowired
    private WeatherDataClient weatherDataClient;

    public JsonNode getWeatherData(final String latitude, final String longitude, final String exclude) {
        return weatherDataClient.getWeatherData(latitude, longitude, exclude, apiKey);
    }
}
