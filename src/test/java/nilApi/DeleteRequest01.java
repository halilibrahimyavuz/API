package nilApi;

import Utilities.nilApi.Dummy;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testdata.DummyTestData;

import java.lang.module.ResolutionException;

import static io.restassured.RestAssured.given;

public class DeleteRequest01 extends Dummy {

    @Test
    public void delete(){
        //ssadece expected data ya ıhtıyac var bır body gondermıyoruz cunku
        //http://dummy.restapiexample.com/api/v1/delete/2

        DummyTestData testData=new DummyTestData();
        JSONObject expectedData=testData.setupExpectedDeleteData();

        Response response= given()   //body gondereırlmez cunku delete ıslemınde body gondeırlmez
                          .spec(spec02)
                          .contentType(ContentType.JSON)
                          .auth()
                          .basic("admin","passwor123")
                          .when()
                          .delete("/delete/6");

        response.prettyPrint();

        //MATCHER class ıle
        response.then().assertThat().statusCode(200)
                .body("status", Matchers.equalTo(expectedData.getString("status")));



        //JsonPatch ile

        System.out.println("************ JSON ------------------------->");
        JsonPath json=response.jsonPath();
        System.out.println(" json = " + json.prettyPrint());

        Assert.assertEquals(expectedData.getString("status"),json.getString("status"));
        Assert.assertEquals(expectedData.getString("data"),json.getString("data"));
        Assert.assertEquals(expectedData.getString("message"),json.getString("message"));


    }
}
