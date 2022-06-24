package nilApi;

import Utilities.nilApi.Herokuapp;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.client.protocol.ResponseContentEncoding;
import org.junit.Test;
import org.testng.Assert;
import testdata.HerOkuAppTestData;

import java.awt.geom.RectangularShape;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequest10 extends Herokuapp {


    @Test
    public void GetReq(){

        // https://restful-booker.herokuapp.com/booking/2

        //1-- deserialization -----

        HerOkuAppTestData expectedData=new HerOkuAppTestData();  //HerokappTestData clasından obje uretıp oradakı methodları kullanmam lazm

        HashMap<String ,Object> expectedMapData =expectedData.setupTestData();  //herokuappTestData clasındakı setupTestdata methodunu kullandım ve onu mapData mapıne attım

        System.out.println("mapData = " + expectedMapData);  //hasmap ozellıgı olarak verıler karısık gelıyor


        Response response=given()
                .spec(spec03)
                .when()
                .get("/booking/2");

        response.prettyPrint();

        HashMap<String,Object> actualDataMap=response.as(HashMap.class);

        System.out.println("actualDataMap = " + actualDataMap);


        Assert.assertEquals(expectedMapData.get("firstname"),actualDataMap.get("firstname"));
        Assert.assertEquals(expectedMapData.get("totalprice"),actualDataMap.get("totalprice"));

        Assert.assertEquals(((Map)expectedMapData.get("bookingdates")).get("checkin"),((Map)actualDataMap.get("bookingdates")).get("checkin"));
        System.out.println("Bookıng-checkın : "+((Map) expectedMapData.get("bookingdates")).get("checkin"));

        Assert.assertEquals(((Map)expectedMapData.get("bookingdates")).get("checkout"),((Map)actualDataMap.get("bookingdates")).get("checkout"));
        System.out.println("Bookıng-checkout : "+((Map) expectedMapData.get("bookingdates")).get("checkout"));


        //----------2.Yol JsonPath ıle
        JsonPath jsonPath=response.jsonPath();

        Assert.assertEquals(expectedMapData.get("firstname"),jsonPath.getString("firstname"));
        Assert.assertEquals(expectedMapData.get("totalprice"),jsonPath.getInt("totalprice"));

        Assert.assertEquals(((Map)expectedMapData.get("bookingdates")).get("checkout"),jsonPath.getString("bookingdates.checkout"));



    }



}

