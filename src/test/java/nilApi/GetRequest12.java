package nilApi;

import Utilities.nilApi.Dummy;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static io.restassured.RestAssured.*;

public class GetRequest12 extends Dummy {

   @Test
    public void dummyGetReq(){

       Response response=given()
                          .spec(spec02)
                          .when()
                          .get("/employees");

      response.prettyPrint();

     //  response.then().assertThat().statusCode(200);

       HashMap<String, Object> actualData=response.as(HashMap.class);

       System.out.println("actualData = " + actualData);

       //status code 200?
       Assert.assertEquals(200,response.getStatusCode());

       //en yuksek maasın 725000 oldugunu dogrula
       List<Integer> maasListesi=new ArrayList<Integer>();

       int dataSize=((List)actualData.get("data")).size();

       for (int i = 0; i <dataSize ; i++) {

           maasListesi.add((Integer) ((Map)((List)actualData.get("data")).get(i)).get("employee_salary"));
       }

       Collections.sort(maasListesi);  //maas listesini kuckten buyuge sıralar en buyuk ıcın sonuncuyu almam lazım
      Assert.assertTrue(maasListesi.get(dataSize-1).equals(725000));
       System.out.println("en yuksek maas ---> "+maasListesi.get(dataSize-1));


        //ikinci en yuksek maasın 675000
       Assert.assertTrue(maasListesi.get(dataSize-2).equals(675000));
       System.out.println("en yuksek 2. maas ---> "+maasListesi.get(dataSize-2));

       //en kuuk yasın 19 oldugunu dogrula
       List<Integer> yasListesi=new ArrayList<Integer>();

       for (int i = 0; i <dataSize ; i++) {
           yasListesi.add((Integer) ((Map)((List) actualData.get("data")).get(i)).get("employee_age"));

       }
       Collections.sort(yasListesi);
       Assert.assertTrue(yasListesi.get(0).equals(19));
       System.out.println("yas lıstesı en kuuck elemanı : -->"+yasListesi.get(0));



       //************JsonPAth ıle cozum ******************
       JsonPath json=response.jsonPath();    //jsonpath den gelen getLıst methodunu kullanırım for loop yapmama gerek kalmaz


       //en yuksek maaas 725000 dogrulama
       List<Integer> maasListesiJson=json.getList("data.employee_salary");  //tum employee salarylerı alıp lıste attı
       Collections.sort(maasListesiJson);
       Assert.assertTrue(maasListesiJson.get(maasListesiJson.size()-1).equals(725000));

       //ikinci en yuksek maasın 675000
       Assert.assertTrue(maasListesiJson.get(maasListesiJson.size()-2).equals(675000));

       //en kuuk yasın 19 oldugunu dogrula
       List<Integer> yasListesiJson=json.get("data.employee_age");
       Collections.sort(yasListesiJson);
       Assert.assertTrue(yasListesiJson.get(0).equals(19));





}

}
