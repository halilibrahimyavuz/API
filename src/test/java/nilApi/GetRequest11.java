package nilApi;

import Utilities.nilApi.Dummy;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static io.restassured.RestAssured.given;

public class GetRequest11 extends Dummy {

    @Test
    public void dummy() {

        Dummy expectedObje=new Dummy();
        HashMap<String,Object> expectedDataMap=expectedObje.setupTestData();

        System.out.println("EXPECTED DATA  : "+expectedDataMap);


        Response response=given()
                .spec(spec02)
                .when()
                .get("/employees");

   //     response.prettyPrint();

        JsonPath jsonPath=response.jsonPath();
        
        //dE-SERİALİZATİON İŞLEMİ
        
        HashMap<String ,Object> actualDataMap=response.as(HashMap.class);  //responcedekı verıyı hashmap e akatarıyoruz
        System.out.println("actualDataMap = " + actualDataMap);

        //status codun 200 oldugunu dogrula
        Assert.assertEquals(expectedDataMap.get("statusCode")
                                ,response.getStatusCode());

        //5. calısanın dogru kısı oldugunu dogrula
        Assert.assertEquals(expectedDataMap.get("besinciClaisan")
                            ,((Map)((List)actualDataMap.get("data")).get(4)).get("employee_name"));  //data turlerı degısıyor once map sonra lıst sonra tekrar map oluyor

        System.out.println("Actual data map--> 5. calısan kişi : "+((Map)((List)actualDataMap.get("data")).get(4)).get("employee_name"));


        //calısan sayısının 24 oldugunu dogrula

        Assert.assertEquals(expectedDataMap.get("calisanSayisi")
                            ,((List<?>) actualDataMap.get("data")).size());

        System.out.println("actualdataMAp -->calısan sayısı : "+((List)actualDataMap.get("data")).size());


        //sonran 2. calısanın maasını dogrula--> 106450
        //once actual data dan bıze donen listin size ını almalıyız
        int dataSize=((List<?>) actualDataMap.get("data")).size();
        int istenenKisiSize=(dataSize-2);

       Assert.assertEquals(expectedDataMap.get("sondanIkınciCalisanmaasi"),
                ((Map)((List<?>) actualDataMap.get("data")).get(istenenKisiSize)).get("employee_salary")    );

        System.out.println("sondan 2. adamın maası --> "+ ((Map)((List<?>) actualDataMap.get("data")).get(istenenKisiSize)).get("employee_salary")   );


        //40-21-19 yasların oldugunu dogrula
        //once actualdata dakı employee_age lerı bır lıste atıp o lıstede ıstenen yaslar varmı dıye bakalım
        List<Integer> actualYasListesi=new ArrayList<Integer>();

        for (int i = 0; i <dataSize ; i++) {
            actualYasListesi.add(((Integer)((Map)((List<?>) actualDataMap.get("data")).get(i)).get("employee_age")));
        }

        System.out.println("actualYasListesi = " + actualYasListesi);
        Assert.assertTrue(actualYasListesi.containsAll((List)expectedDataMap.get("arananYaslar")));

        //        11. calısanın bılgılerını kontrol et

        Assert.assertEquals(    ((Map)expectedDataMap.get("onbirinciCalisan")).get("employee_name") ,
                ((Map)((List<?>) actualDataMap.get("data")).get(10)).get("employee_name")   );
        System.out.println( "11.elemanın adı : "+ ((Map)((List<?>) actualDataMap.get("data")).get(10)).get("employee_name") );


        Assert.assertEquals(    ((Map)expectedDataMap.get("onbirinciCalisan")).get("employee_salary") ,
                ((Map)((List<?>) actualDataMap.get("data")).get(10)).get("employee_salary")   );
        System.out.println("11.elemanın maası :"+((Map)((List<?>) actualDataMap.get("data")).get(10)).get("employee_salary"));








    }



}
