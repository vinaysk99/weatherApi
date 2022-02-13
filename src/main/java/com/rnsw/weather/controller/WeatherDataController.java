package com.rnsw.weather.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.rnsw.weather.service.WeatherDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherDataController {

    @Autowired
    private WeatherDataService weatherDataService;

    @GetMapping("/weather")
    public JsonNode weatherData(
            @RequestParam("lat") String lat,
            @RequestParam("lon") String lon,
            @RequestParam("exclude") String exclude) {
        return weatherDataService.getWeatherData(lat, lon, exclude);
    }
}
