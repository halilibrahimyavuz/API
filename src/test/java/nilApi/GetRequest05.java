package nilApi;

import Utilities.nilApi.PlaceHolder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest05 extends PlaceHolder {

    @Test
    public void GetR(){


        spec01.pathParams("param1","todos",
                "param2",12 );

        Response response=given()
                .spec(spec01)
                .when()
                .get("/{param1}/{param2}");

        response.prettyPrint();

        Assert.assertEquals(200,response.getStatusCode());

        JsonPath jsonPath=response.jsonPath();
        //responce degerımı jsonPath e veırıp objeye atadım

        Assert.assertEquals(12,jsonPath.getInt("id"));
        Assert.assertEquals("ipsa repellendus fugit nisi",jsonPath.getString("title"));
        Assert.assertTrue(jsonPath.getBoolean("completed"));







    }



}
