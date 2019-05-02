
package reqres;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidateResponseCodeTest {

    @Test
    public void ValidateResponseTest()
    {

        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        Assert.assertEquals(response.getStatusCode(),200);
        System.out.println(response.getBody().prettyPrint());

        Response body = (Response) response.getBody();

        List<Map<String,?>> ExpectedResult = new ArrayList<>();
        List<Map<String,?>> actualData = response.jsonPath().getList("data");

        Map<String,String> map1 =new HashMap<>();
        Map<String,String> map2 =new HashMap<>();
        Map<String,String> map3 =new HashMap<>();

        map1.put("id","4");
        map1.put("first_name","Eve");
        map1.put("last_name","Holt");

        map2.put("id","5");
        map2.put("first_name","Charles");
        map2.put("last_name","Morris");

        map3.put("id","6");
        map3.put("first_name","Tracey");
        map3.put("last_name","Ramos");

        ExpectedResult.add(map1);
        ExpectedResult.add(map2);
        ExpectedResult.add(map3);

        int datasize = actualData.size();

        System.out.println(datasize);

        for(int i=0;i<datasize;i++)
        {
            System.out.println("Id :"+actualData.get(i).get("id").toString());
            System.out.println("First Name :"+actualData.get(i).get("first_name").toString());
            Assert.assertEquals(ExpectedResult.get(i).get("id").toString(),actualData.get(i).get("id").toString());
            Assert.assertEquals(ExpectedResult.get(i).get("first_name").toString(),actualData.get(i).get("first_name").toString());
            Assert.assertEquals(ExpectedResult.get(i).get("last_name").toString(),actualData.get(i).get("last_name").toString());
        }

        Assert.assertEquals("Eve",actualData.get(0).get("first_name").toString());


        /*String usernames = response.jsonPath().getString("first_name");
        JsonPath jsonPathEvaluator = response.jsonPath();
         Get specific element from JSON document
        String firstName = response.jsonPath().getList();//.get("first_name");

        System.out.println(response.header("content-type"));
        System.out.println(firstName);
        System.out.println("response code for asString: "+response.asString());
        System.out.println("response code for getBody:  "+response.getBody());
        System.out.println("response code for xmlPath :  "+response.xmlPath());
        System.out.println("response code for prettyPrint :  "+response.prettyPrint());
        System.out.println("response code for jsonPrint :  "+response.jsonPath());
        System.out.println("response code for contentType :  "+response.contentType());
        System.out.println("response code for sessionId :  "+response.getSessionId());
    }*/



    }



}