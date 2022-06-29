package Utilities.nilApi;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Dummy {

    protected RequestSpecification spec02;

    @Before
    public void setup(){
        spec02=new RequestSpecBuilder()
                .setBaseUri("http://dummy.restapiexample.com/api/v1")
                .build();

        //spec01  -> olusturdum buna uri i tanımladım ve ınsa ettım artık prtected olan spec01 ı her yeren kullanabılırım

    }


    public HashMap<String, Object> setupTestData(){

        List<Integer> yaslar= new ArrayList<Integer>();
        yaslar.add(40);
        yaslar.add(19);
        yaslar.add(21);

        HashMap<String,Object> onbirinci=new HashMap<String,Object>();
        onbirinci.put("id",11);
        onbirinci.put("employee_name","Jena Gaines");
        onbirinci.put("employee_salary",90560);
        onbirinci.put("employee_age",30);
        onbirinci.put("profile_image","");

        HashMap<String,Object> expectedData=new HashMap<String,Object>();
        expectedData.put("statusCode",200);
        expectedData.put("besinciClaisan","Airi Satou");
        expectedData.put("calisanSayisi",24);
        expectedData.put("sondanIkınciCalisanmaasi",106450);
        expectedData.put("arananYaslar",yaslar);
        expectedData.put("onbirinciCalisan",onbirinci);

        return expectedData;

    }

    public HashMap<String, Object> setupRequestBody(){
        //        {
        //            "employee_name": "halo",
        //            "employee_salary": 555555,
        //            "employee_age": 30,
        //       }

        HashMap<String,Object> requestData=new HashMap<String ,Object>();
        requestData.put("name","halo");
        requestData.put("maas","5555555");
        requestData.put("yas","30");

        return requestData;

            }

    public HashMap<String, Object> setupExpectedData(){
        //        {
        //            "employee_name": "halo",
        //            "employee_salary": 555555,
        //            "employee_age": 30,
        //       },


        HashMap<String,Object> data=new HashMap<String ,Object>();

        data.put("name","halo");
        data.put("salary","5555555");
        data.put("age","30");

        HashMap<String,Object> expectedData=new HashMap<String ,Object>();
        expectedData.put("statusCode","200");
        expectedData.put("status","success");
        expectedData.put("data",data); //yukardakı data ısımlı map ı ıdsardakı map e aktardım
        expectedData.put("mesaj","Successfully! Record has been added.");


        return expectedData;

    }


}
