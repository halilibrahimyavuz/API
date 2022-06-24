package nilApi;

import Utilities.nilApi.PlaceHolder;
import io.restassured.internal.ResponseParserRegistrar;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class GetRequest08 extends PlaceHolder {


@Test
    public void PlaceHolderGet(){



    Response response=given().spec(spec01).when().get("/todos/2");

    response.prettyPrint();


 //  JsonPath jsonPath=response.jsonPath();
 //  softAssert.assertTrue(!jsonPath.getBoolean("completed"));
 //  softAssert.assertEquals(jsonPath.getString("title"),"quis ut nam facilis et officia qui");
 //  softAssert.assertEquals(jsonPath.getInt("userId"),1);
 //  softAssert.assertAll();


    HashMap<String,Object> expectedData=new HashMap<String ,Object>();

    expectedData.put("statusCode",200);
    expectedData.put("via","1.1 vegur");
    expectedData.put("title","quis ut nam facilis et officia qui");
    expectedData.put("userId",1);
    expectedData.put("completed",false);

    System.out.println("expectedData = " + expectedData);


    System.out.println("********* MAtcher class ıle assertıon yaptık  ******");

    response
            .then()
            .assertThat()
            .statusCode((Integer)expectedData.get("statusCode"))
            .header("via", Matchers.equalTo(expectedData.get("via")))
            .body("completed",Matchers.equalTo(expectedData.get("completed")))
            .body("title",Matchers.equalTo(expectedData.get("title")));


    System.out.println( "*********  JsonPath ıle aasssertıon yaptık   **************");

    JsonPath jsonPath=response.jsonPath();
    Assert.assertEquals(expectedData.get("statusCode"),response.getStatusCode());

    Assert.assertEquals(expectedData.get("via"),response.getHeader("via"));

    Assert.assertEquals(expectedData.get("title"),jsonPath.getString("title"));

    Assert.assertEquals(expectedData.get("userId"),jsonPath.getInt("userId"));

    Assert.assertEquals(expectedData.get("completed"),jsonPath.getBoolean("completed"));


    System.out.println("*********** DESERİALİZATİON  ***************");
     //object mapper kullan
    // pojo class ıle maplerı kullan







}




}





