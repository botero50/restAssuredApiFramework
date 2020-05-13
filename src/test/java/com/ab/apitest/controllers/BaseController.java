package com.ab.apitest.controllers;

import io.restassured.builder.RequestSpecBuilder;
import lombok.Data;
import org.springframework.stereotype.Component;

import com.ab.apitest.helpers.AuthenticationException;
import com.ab.apitest.helpers.HttpClient;

import static java.lang.String.format;

@Data
@Component
public class BaseController {
    protected HttpClient httpClient;
    protected final String gorestBaseUrl = format("https://gorest.co.in/public-api");

    public BaseController() {
        this.httpClient = new HttpClient();
    }

    public RequestSpecBuilder generateRequestSpecBuilder() throws AuthenticationException {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.addHeader("Authorization", "Bearer 9DuKEDL_7IqjAX6R2FVZNOtSNOcG2h_OPZAT");
        requestSpecBuilder.addHeader("Content-type", "application/json");
        return  requestSpecBuilder;
    }
}
