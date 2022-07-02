package testdata;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class PlaceHolderTestData {

    public Map<String,Object> setupTestData(){


        HashMap<String,Object> expectedData=new HashMap<String ,Object>();

        expectedData.put("statusCode",200);
        expectedData.put("via","1.1 vegur");
        expectedData.put("title","quis ut nam facilis et officia qui");
        expectedData.put("userId",1);
        expectedData.put("completed",false);

        return expectedData;

    }

     public JSONObject postRequestData(){

         JSONObject expectedData=new JSONObject();

         expectedData.put("code",201);
        expectedData.put("userId",55);
        expectedData.put("title","abikee cankee senikee yerimkee");
        expectedData.put("completed",true);

        return expectedData;

    }

    public JSONObject setupPatchRequestData(){  //PatchRequest01 clası ıcın

        JSONObject requestData=new JSONObject();
        requestData.put("title","API ÇALISMALIYIM");

        return requestData;

    }

    public JSONObject setupPatchExpextedDATA(){    //PatchRequest01 clası ıcın
        JSONObject expectedData=new JSONObject();
        expectedData.put("userID",10);
        expectedData.put("title","API ÇALISMALIYIM");
        expectedData.put("completed",true);
        expectedData.put("id",198);  //sadece yenı olusturmada sıstem kendı ıd atıyor degıstımelerde sabıt

        return expectedData;
    }



}
