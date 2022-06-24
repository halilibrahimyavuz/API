package nilApi;

import Utilities.nilApi.Dummy;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GetRequest07 extends Dummy {




    @Test
    public  void GR01(){

        spec02.pathParam("param1","employees");


        Response response=given()
                        .spec(spec02)
                        .when()
                        .get("/{param1}");

        response.prettyPrint();

       JsonPath jsonPath=response.jsonPath();
        SoftAssert softAssert=new SoftAssert();  //--> hemen son satıra --> *** softAssert.assertAll();******* KOYYYYY

        Assert.assertEquals(200,response.getStatusCode());

        //10 dan büyük tüm id leri yazdiriniz
        List<Integer> idListesi=jsonPath.getList("data.findAll{it.id>10}.id");
        System.out.println("idListesi = "+idListesi);
        softAssert.assertEquals(idListesi.size(),14);

        //30'dan kücük tüm yaslari consola yazdır
        List<Integer> yasListesi=jsonPath.getList("data.findAll{it.employee_age<30}.employee_age");
        System.out.println("yasListesi = " + yasListesi);
        Collections.sort(yasListesi);
        System.out.println("yasListesi sıraladıktan sonra  = " + yasListesi);
        softAssert.assertTrue(yasListesi.get(yasListesi.size()-1)==23);

        //maasi 350000'den cok olan iscilerin isimlerini yazdiriniz
        List<String> maasi350DenCokOlanlar=jsonPath.getList("data.findAll{it.employee_salary>350000}.employee_name");
        System.out.println("maasi350DenCokOlanlar = " + maasi350DenCokOlanlar);

        // Charde Marshall in maasinin 350000 den fazla oldugunu dogrulayınız(verify)
        softAssert.assertTrue(maasi350DenCokOlanlar.contains("Charde Marshall"));

        softAssert.assertAll();





    }
}
