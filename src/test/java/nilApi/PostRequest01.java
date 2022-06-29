package nilApi;

import Utilities.nilApi.Dummy;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.given;

public class PostRequest01 extends Dummy {



    @Test
    public void postReq(){
        //post demek yenı data gondermek demek
        //request body olustur responce body ıle karsılastır

        //        {
        //            "employee_name": "halo",
        //            "employee_salary": 555555,
        //            "employee_age": 30,
        //       }

        Dummy obje=new Dummy();
        //post requesty yaparken body gondermek zorundayız Dummy calsındakı requestbody ı cagırıyorz
        HashMap<String,Object> requestBodyMap= obje.setupRequestBody();
        HashMap<String,Object> expectedDataMAp= obje.setupExpectedData();

        Response response=given()
                                 .spec(spec02)
                                 .auth().basic("admin","password123")    //autorizetıon bolumu username ve password kısmı
                                 .body(requestBodyMap)  //post ıcın body gondermem lazım
                                 .when()
                                 .post("/create");

        response.prettyPrint();

        //de-serialization
      // HashMap<String ,Object> actualDataMAp=response.as(HashMap.class);

      // Assert.assertEquals(expectedDataMAp.get("statusCode"),response.getStatusCode());
      // Assert.assertEquals(expectedDataMAp.get("status"),actualDataMAp.get("status"));
      // Assert.assertEquals(expectedDataMAp.get("mesaj"),actualDataMAp.get("message"));

        //JSONPATH
        JsonPath json=response.jsonPath();
        Assert.assertEquals(expectedDataMAp.get("status"),json.getString("status"));
        Assert.assertEquals(expectedDataMAp.get("mesaj"),json.getString("message"));







    }



}
