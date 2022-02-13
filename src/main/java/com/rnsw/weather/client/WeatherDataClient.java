package com.rnsw.weather.client;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "openweathermap", url = "https://api.openweathermap.org/data/2.5/onecall")
public interface WeatherDataClient {

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    JsonNode getWeatherData(
            @RequestParam("lat") String lat,
            @RequestParam("lon") String lon,
            @RequestParam("exclude") String exclude,
            @RequestParam("appId") String appId);
}
