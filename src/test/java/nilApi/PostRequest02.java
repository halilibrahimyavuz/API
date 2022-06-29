package nilApi;

import Utilities.nilApi.Herokuapp;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testdata.HerOkuAppTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PostRequest02 extends Herokuapp {

//JSONObject post yaparken java collectıonsaarını kullanmak yerıne kullanaıyoruz.
// type belırmeyız bu yuzde castıng ıslermı yapmayız
//bunun ıcın json kutuphanesını eklememmeız gerekır

    @Test
    public void post02(){
//     {
//    "bookingid": 1364,
//    "booking": {
//        "firstname": "salih-sare",
//        "lastname": "halooo",
//        "totalprice": 1000,
//        "depositpaid": false,
//        "bookingdates": {
//            "checkin": "2021-01-05",
//            "checkout": "2021-01-10"
//        }
//    }
//}


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

       //   response.prettyPrint();

        //de-serialization
        System.out.println(" ************   DE-SERİALİZATİON    ***************");
        HashMap<String ,Object> actualDataMap=response.as(HashMap.class);

        System.out.println("actualDataMap = " + actualDataMap);

        //*********************************************************************
        Assert.assertEquals(expectedAndRequestData.getString("firstname"),
                           ((Map)actualDataMap.get("booking")).get("firstname"));

        System.out.println(((Map)actualDataMap.get("booking")).get("firstname"));
        System.out.println(expectedAndRequestData.getString("firstname"));

        //*********************************************************************

        Assert.assertEquals(expectedAndRequestData.getString("lastname"),
                ((Map)actualDataMap.get("booking")).get("lastname"));

        System.out.println(((Map)actualDataMap.get("booking")).get("lastname"));
        System.out.println(expectedAndRequestData.getString("lastname"));

        //*********************************************************************

        Assert.assertEquals(expectedAndRequestData.getInt("totalprice"),
                ((Map)actualDataMap.get("booking")).get("totalprice"));

        System.out.println(((Map)actualDataMap.get("booking")).get("totalprice"));
        System.out.println(expectedAndRequestData.getInt("totalprice"));

        //*********************************************************************

        Assert.assertEquals(expectedAndRequestData.getJSONObject("bookingdates").getString("checkin"),
                ((Map)((Map)actualDataMap.get("booking")).get("bookingdates")).get("checkin"));

        System.out.println(expectedAndRequestData.getJSONObject("bookingdates").getString("checkin"));
        System.out.println(((Map)((Map)actualDataMap.get("booking")).get("bookingdates")).get("checkin"));


        //*********************************************************************

        Assert.assertEquals(expectedAndRequestData.getJSONObject("bookingdates").getString("checkout"),
                ((Map)((Map)actualDataMap.get("booking")).get("bookingdates")).get("checkout"));

        System.out.println(expectedAndRequestData.getJSONObject("bookingdates").getString("checkout"));
        System.out.println(((Map)((Map)actualDataMap.get("booking")).get("bookingdates")).get("checkout"));



        //JSONPATH ıle
        System.out.println(" ************JSONPATH ***************");

        JsonPath jsonPath=response.jsonPath();

        //*********************************************************************
        Assert.assertEquals(expectedAndRequestData.getString("lastname"),
                          jsonPath.get("booking.lastname"));
        System.out.println("lastname = " + jsonPath.get("booking.lastname"));
        System.out.println("lastname = " + expectedAndRequestData.getString("lastname"));

        //*********************************************************************
        Assert.assertEquals(expectedAndRequestData.getString("firstname"),
                             jsonPath.get("booking.firstname"));
        System.out.println("firstname = " +  jsonPath.get("booking.firstname"));
        System.out.println("firstname = " + expectedAndRequestData.getString("firstname"));

        //*********************************************************************
        Assert.assertEquals(expectedAndRequestData.getBoolean("depositpaid"),
                            jsonPath.getBoolean("booking.depositpaid"));
        System.out.println("depositpaid = " +  jsonPath.getBoolean("booking.depositpaid"));
        System.out.println("depositpaid = " + expectedAndRequestData.getBoolean("depositpaid"));

        //*********************************************************************
            Assert.assertEquals(expectedAndRequestData.getJSONObject("bookingdates").getString("checkin"),
                                jsonPath.getString("booking.bookingdates.checkin"));

        System.out.println("booking.bookingdates.checkin = " +  jsonPath.getString("booking.bookingdates.checkin"));
        System.out.println("booking.bookingdates.checkin = " + expectedAndRequestData.getJSONObject("bookingdates").getString("checkin"));







    }

}
