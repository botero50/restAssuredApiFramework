package com.ab.apitest.helpers;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;
import org.testng.Reporter;
import static io.restassured.RestAssured.given;
import static io.restassured.http.Method.*;

@Component
public class HttpClient {

    final private static Map<String, String> ACCEPT_JSON_HEADER = Collections.singletonMap("Accept", "application/json");

    public HttpClient() {
        RestAssured.defaultParser = Parser.JSON;
    }

    public Response doPost(String url, RequestSpecification reqSpec) {
        Response ResponseData = doRequest(prepareRequest(reqSpec), POST, url);
        Reporter.log(ResponseData.prettyPrint());
        return ResponseData;
    }

    public Response doPut(String url, RequestSpecification reqSpec) {
        return doRequest(prepareRequest(reqSpec), PUT, url);
    }

    public Response doPatch(String url, RequestSpecification reqSpec) {
        return doRequest(prepareRequest(reqSpec), PATCH, url);
    }

    public Response doGet(String url, RequestSpecification reqSpec) {
        return doRequest(prepareRequest(reqSpec), GET, url);
    }

    public Response doDelete(String url, RequestSpecification reqSpec) {
        return doRequest(prepareRequest(reqSpec), DELETE, url);
    }

    private RequestSpecification prepareRequest() {
        return given().headers(ACCEPT_JSON_HEADER);
    }

    private RequestSpecification prepareRequest(RequestSpecification reqSpec) {
        return prepareRequest().spec(reqSpec);
    }

    private Response doRequest(RequestSpecification requestSpecification,
                               Method method, String url) {
        return requestSpecification.when().request(method, url);
    }
}
