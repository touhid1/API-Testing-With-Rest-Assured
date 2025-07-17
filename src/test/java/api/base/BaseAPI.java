package api.base;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseAPI {
    protected static final String BASE_URI = "https://restful-booker.herokuapp.com";

    static {
        RestAssured.baseURI = BASE_URI; // Set base URI for all requests
    }

    protected RequestSpecification request() {
        return RestAssured.given().contentType("application/json");
    }

    protected RequestSpecification requestWithToken(String token) {
        return request().cookie("token", token);
    }

    protected Response get(String endpoint) {
        return request().get(endpoint);
    }

    protected Response post(String endpoint, Object body) {
        return request().body(body).post(endpoint);
    }

    protected Response put(String endpoint, Object body, String token) {
        return requestWithToken(token).body(body).put(endpoint);
    }

    protected Response delete(String endpoint, String token) {
        return requestWithToken(token).delete(endpoint);
    }
}