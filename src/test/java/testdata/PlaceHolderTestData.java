package testdata;

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







}
