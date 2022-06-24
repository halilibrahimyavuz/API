package testdata;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

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
}
