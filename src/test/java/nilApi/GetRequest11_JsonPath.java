package nilApi;

import Utilities.nilApi.Dummy;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequest11_JsonPath extends Dummy {

    @Test
    public void dummy() {

        Dummy expectedObje = new Dummy();
        HashMap<String, Object> expectedDataMap = expectedObje.setupTestData();

        System.out.println("EXPECTED DATA  : " + expectedDataMap);


        Response response = given()
                .spec(spec02)
                .when()
                .get("/employees");

        response.prettyPrint();

        JsonPath json=response.jsonPath();    //jsonpath den json objesı olusturuyoruz

        //statuscode 200 mu dogrula
        Assert.assertEquals(expectedDataMap.get("statusCode"),response.getStatusCode());
        System.out.println("ststusCode : "+response.getStatusCode());


        //5. calısanı dogrula
        Assert.assertEquals(expectedDataMap.get("besinciClaisan"),json.getString("data[4].employee_name"));
        System.out.println("5. calısanın adı :"+json.getString("data[4].employee_name"));

        //çalısan sayısının 24 oldugunu dogrula
        Assert.assertEquals(expectedDataMap.get("calisanSayisi"),json.getList("data.id").size());
        System.out.println("calısan sayısı : "+json.getList("data.id").size());

        //sondan 2. calısanın maası
        Assert.assertEquals(expectedDataMap.get("sondanIkınciCalisanmaasi"),json.getInt("data[-2].employee_salary"));
        System.out.println("sandan2. calısan maası : "+json.getInt("data[-2].employee_salary"));


        //40-19-21 yaslarının olgıhını dogrula
        Assert.assertTrue(json.getList("data.employee_age").containsAll((List) expectedDataMap.get("arananYaslar")) );
        System.out.println("40-12-21 varmı : "+json.getList("data.employee_age").containsAll((List) expectedDataMap.get("arananYaslar")) );

        //11. ıd yı dogrula
        Assert.assertEquals(((Map)expectedDataMap.get("onbirinciCalisan")).get("employee_name"),json.getString("data[10].employee_name"));

        Assert.assertEquals(((Map)expectedDataMap.get("onbirinciCalisan")).get("employee_salary"),json.getInt("data[10].employee_salary"));






    }
}
