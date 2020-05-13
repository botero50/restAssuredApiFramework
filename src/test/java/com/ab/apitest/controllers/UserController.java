package com.ab.apitest.controllers;

import com.ab.apitest.DTOs.user.CreateUserDTO;
import com.ab.apitest.helpers.AuthenticationException;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.SneakyThrows;

public class UserController extends BaseController{

    private final String usertsUrl = this.gorestBaseUrl + "/users";

    @SneakyThrows
    public Response postCreateUser(CreateUserDTO userDTO) throws AuthenticationException{
        RequestSpecification spec = this.generateRequestSpecBuilder()
                .setBody(userDTO)
                .build();
        return this.httpClient.doPost(this.usertsUrl, spec);
    }
    

    @SneakyThrows
    public Response getUser() throws AuthenticationException{
        RequestSpecification spec = this.generateRequestSpecBuilder()
                .build();
        return this.httpClient.doGet(this.usertsUrl, spec);
    }
}
