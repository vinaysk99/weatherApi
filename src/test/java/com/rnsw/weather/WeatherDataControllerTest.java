package com.rnsw.weather;

import com.fasterxml.jackson.databind.JsonNode;
import com.rnsw.weather.controller.WeatherDataController;
import com.rnsw.weather.service.WeatherDataService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class WeatherDataControllerTest {

    @Mock
    private WeatherDataService weatherDataService;

    @InjectMocks
    private WeatherDataController weatherDataController;

    @Before
    public void setup() {
    }

    @Test
    public void shouldFetchWeatherData() {
        String lat = "33.44";
        String lon = "-94.04";
        String exclude = "minutely";

        JsonNode actualObj = mock(JsonNode.class);

        given(weatherDataService.getWeatherData(lat, lon, exclude))
                .willReturn(actualObj);

        JsonNode jsonNode = weatherDataController.weatherData(lat, lon, exclude);
        assertNotNull(jsonNode);
    }
}
