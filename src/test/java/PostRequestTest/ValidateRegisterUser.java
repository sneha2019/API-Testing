package PostRequestTest;

import groovy.json.JsonException;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidateRegisterUser {

    @Test
    public void validateRegistrationOfUserTest() {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "Application/json");
        JSONObject requestJson = new JSONObject();
        try {
            requestJson.put("email", "sydney@fife");
            requestJson.put("password", "pistol");
        } catch (JsonException e) {
            e.printStackTrace();

        }

        request.body(requestJson.toString());
        Response responseRegister = request.post("https://reqres.in/api/register");
        System.out.println("Body:" + responseRegister.getBody().toString());
        Assert.assertEquals(responseRegister.getStatusCode(), 201);
    }

    @Test
    public void validateRegistrationUserForInvalidData() {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "Application/json");
        JSONObject requestJson = new JSONObject();
        try {
            requestJson.put("email", "sydney@fife");
            //requestJson.put("password", "pistXX");
        } catch (JsonException e) {
            e.printStackTrace();

        }
        request.body(requestJson.toString());
        Response responseRegister = request.post("https://reqres.in/api/register");
        System.out.println("Body:" + responseRegister.getBody().toString());
        Assert.assertEquals(responseRegister.getStatusCode(), 400);

    }

}
