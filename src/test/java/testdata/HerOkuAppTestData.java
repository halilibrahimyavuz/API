package testdata;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class HerOkuAppTestData {


    public HashMap<String , Object> setupTestData() {

        HashMap<String ,Object> bookingTestData =new HashMap<String ,Object>();

        bookingTestData.put("checkin","2022-03-01");
        bookingTestData.put("checkout","2022-03-11");


        HashMap<String,Object> expectedTestData=new HashMap<String,Object>();
        expectedTestData.put("firstname","Ali");
        expectedTestData.put("lastname","Can");
        expectedTestData.put("totalprice",500);
        expectedTestData.put("depositpaid",true);
        expectedTestData.put("bookingdates",bookingTestData);
        expectedTestData.put("additionalneeds","Breakfast");



        return expectedTestData  ;
    }



    public JSONObject setupTestRequestData(){

        JSONObject bookingData=new JSONObject();
        bookingData.put("checkin","2021-01-05");
        bookingData.put("checkout","2021-01-10");

        JSONObject expectedRequest=new JSONObject();
        expectedRequest.put("lastname","halooo");
        expectedRequest.put("firstname","salih-sare");
        expectedRequest.put("totalprice",1000);
        expectedRequest.put("depositpaid",false);
        expectedRequest.put("bookingdates",bookingData);

        return expectedRequest;

    }
}
