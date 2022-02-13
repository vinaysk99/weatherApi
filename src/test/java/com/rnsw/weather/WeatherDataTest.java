package com.rnsw.weather;

import com.fasterxml.jackson.databind.JsonNode;
import com.rnsw.weather.exception.BadRequestException;
import com.rnsw.weather.service.WeatherDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherDataTest {

    @Autowired
    private WeatherDataService weatherDataService;

    @Test
    public void shouldGetWeatherDataSuccess() {
        JsonNode weatherData = weatherDataService.getWeatherData("33.44", "-94.04", "minutely");
        assertNotNull(weatherData);
    }

    @Test
    public void shouldGetWeatherDataError() {
        try {
            weatherDataService.getWeatherData("df", "-94.04", "minutely");
        } catch (BadRequestException ex) {
            assertNotNull(ex);
        }
    }
}
