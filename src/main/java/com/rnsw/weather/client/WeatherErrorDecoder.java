package com.rnsw.weather.client;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rnsw.weather.exception.BadRequestException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class WeatherErrorDecoder implements ErrorDecoder {

    private ObjectMapper objectMapper;

    public WeatherErrorDecoder() {
        objectMapper = new ObjectMapper();
    }

    @Override
    public Exception decode(String s, Response response) {

        JsonNode actualObj = null;
        try {
            String text = IOUtils.toString(response.body().asInputStream(), StandardCharsets.UTF_8.name());

            actualObj = objectMapper.readTree(text);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (response.status() >= 400 && response.status() < 500) {
            return new BadRequestException(actualObj, HttpStatus.valueOf(response.status()));
        }

        if (response.status() >= 500) {
            return new Exception("Internal Server Error");
        }

        return new Exception("");
    }
}
