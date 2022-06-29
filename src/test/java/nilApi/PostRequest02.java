package nilApi;

import Utilities.nilApi.Herokuapp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import testdata.HerOkuAppTestData;

import static io.restassured.RestAssured.given;

public class PostRequest02 extends Herokuapp {

//JSONObject post yaparken java collectıonsaarını kullanmak yerıne kullanaıyoruz.
// type belırmeyız bu yuzde castıng ıslermı yapmayız
//bunun ıcın json kutuphanesını eklememmeız gerekır

    @Test
    public void post02(){
//      {
//          "firstname": "Nafiz",
//          "lastname": "Han",
//          "totalprice": 1234,
//          "depositpaid": true,
//          "bookingdates": {
//              "checkin": "2019-06-22",
//              "checkout": "2020-05-07"
//          }
//      }

        HerOkuAppTestData testData=new HerOkuAppTestData();
        JSONObject expectedAndRequestData=testData.setupTestRequestData(); //JsonObject ın ıcıne testdatamızı attık
        //request ve expected data aynı moldugu ıcın tek dtestdata olsuturduk

        System.out.println("expectedAndRequestData = " + expectedAndRequestData);

        Response response=given()
                .contentType(ContentType.JSON)
                .spec(spec03)
                .auth().basic("admin","password123")
                .body(expectedAndRequestData.toString())   //jsonobject te ToStrıng olarak gondermemzı gereklı
                .when()
                .post("/booking");

        response.prettyPrint();


    }

}
