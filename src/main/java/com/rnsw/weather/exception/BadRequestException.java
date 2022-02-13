package com.rnsw.weather.exception;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.HttpStatus;

public class BadRequestException extends RuntimeException {

    private HttpStatus httpStatus;

    private JsonNode errorBody;

    public BadRequestException(JsonNode errorBody, HttpStatus httpStatus) {
        this.errorBody = errorBody;
        this.httpStatus = httpStatus;
    }

    public JsonNode getErrorBody() {
        return errorBody;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
