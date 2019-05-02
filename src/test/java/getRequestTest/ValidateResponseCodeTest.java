package getRequestTest;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Map;

public class ValidateResponseCodeTest {

    @Test
    public void validateResponseCode() {
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        Assert.assertTrue(response.getStatusCode() == 200);
        validateData(response);
    }

    private void validateData(Response response) {
        List<Map<String, ?>> actualData = response.jsonPath().getList("data");
        int dataSize = actualData.size();
        for (int i = 0; i < dataSize; i++) {
            System.out.println("Id:" + actualData.get(i).get("id").toString());
        }
        for (int i = 0; i < dataSize; i++) {
            System.out.println("FirstName:" + actualData.get(i).get("first_name").toString());
            System.out.println("LastName:" + actualData.get(i).get("last_name").toString());
            System.out.println("Avatar:" + actualData.get(i).get("avatar").toString());
    }

            Assert.assertEquals("4", actualData.get(0).get("id").toString());
            Assert.assertEquals("4", actualData.get(1).get("Eve").toString());
            Assert.assertEquals("4", actualData.get(2).get("Holt").toString());

    }
}







        /*System.out.println("response code for asString: "+response.asString());
        //System.out.println("response code for getBody:  "+response.getBody());
        //System.out.println("response code for xmlPath :  "+response.xmlPath());
        System.out.println("response code for prettyPrint :  "+response.prettyPrint());
        //System.out.println("response code for jsonPrint :  "+response.jsonPath());
        //System.out.println("response code for contentType :  "+response.contentType());
        //System.out.println("response code for sessionId :  "+response.getSessionId());
    }*/

