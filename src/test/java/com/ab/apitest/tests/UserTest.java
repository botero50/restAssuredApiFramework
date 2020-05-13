package com.ab.apitest.tests;

import com.ab.apitest.DTOs.user.CreateUserDTO;
import com.ab.apitest.controllers.UserController;
import com.ab.apitest.helpers.AuthenticationException;
import com.ab.apitest.helpers.DTOHelper;
import com.ab.apitest.utils.Utils;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.testng.annotations.Test;


public class UserTest {

    @Test( description = "User can get the users")
    public void getUser() throws AuthenticationException, Exception{
        UserController userController = new UserController();
        Response getUser = userController.getUser();

        Assert.assertEquals(HttpStatus.SC_OK, getUser.getStatusCode());
        System.out.println(getUser.getBody());
    }
    
    @Test( description = "User can create a user")
    public void createUser() throws AuthenticationException, Exception{
        CreateUserDTO userDTO =  DTOHelper.createDtoFromJsonFile(CreateUserDTO.class, "createUser.json");
        userDTO.email = Utils.generateRandomAlphanumericString(10) + "@test.com";
        
        UserController userController = new UserController();
        Response getUser = userController.postCreateUser(userDTO);

        Assert.assertEquals(HttpStatus.SC_CREATED, getUser.getStatusCode());
        System.out.println(getUser.getBody());
    }
}
