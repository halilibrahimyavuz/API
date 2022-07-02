package nilApi;

import Utilities.nilApi.PlaceHolder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testdata.PlaceHolderTestData;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PatchRequest01 extends PlaceHolder {


    @Test
    public void patchreq01(){

        // sadece degısmesını ıstedıgımız bır data varsa onu degıstırmek ıcın patch kulanıyorum
        //https://jsonplaceholder.typicode.com/todos/198

        PlaceHolderTestData testData=new PlaceHolderTestData();    // PlaceHolderTestData clasında olusturdugfumuz methodları kullanmak ıcın obje olusturduk

        JSONObject requestData =testData.setupPatchRequestData();  //olsuturdgumuz testData objesınden gelen degerlerı JSONObjeckt e attık
        System.out.println("requestData = " + requestData);


        JSONObject expectedATA=testData.setupPatchExpextedDATA();  //olsuturdgumuz testData objesınden gelen degerlerı JSONObjeckt e attık
        System.out.println("expectedATA = " + expectedATA);


        //request gonder
        Response response=given()
                .contentType(ContentType.JSON)
                .spec(spec01)
                .auth().basic("admin","password123")
                .body(requestData.toString())
                .when()
                .patch("/todos/198");

        response.prettyPrint();


        //JsonPatch ile

        System.out.println("************ JSON ------------------------->");
        JsonPath json=response.jsonPath();
        System.out.println(" json = " + json.prettyPrint());

        Assert.assertEquals(expectedATA.getInt("userID"),json.getInt("userId"));
        Assert.assertEquals(expectedATA.getInt("id"),json.getInt("id"));
        Assert.assertEquals(expectedATA.getString("title"),json.getString("title"));
        Assert.assertEquals(expectedATA.getBoolean("completed"),json.getBoolean("completed"));


        //De-serialization ile
        System.out.println("************ DE-SERİALİZATİON ------------------------->");

        HashMap<String ,Object> actualDataMAP=response.as(HashMap.class);
        System.out.println("actualDataMAP = " + actualDataMAP);


        Assert.assertEquals(expectedATA.getInt("userID"),actualDataMAP.get("userId"));
        Assert.assertEquals(expectedATA.getInt("id"),actualDataMAP.get("id"));
        Assert.assertEquals(expectedATA.getString("title"),actualDataMAP.get("title"));
        Assert.assertEquals(expectedATA.getBoolean("completed"),actualDataMAP.get("completed"));



    }
}
