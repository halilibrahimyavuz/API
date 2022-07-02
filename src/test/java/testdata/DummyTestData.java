package testdata;

import org.json.JSONObject;

public class DummyTestData {

    public JSONObject setupExpectedDeleteData(){

        JSONObject expectedData=new JSONObject();

        expectedData.put("status","success");
        expectedData.put("data","6");
        expectedData.put("message","Successfully! Record has been deleted");

        return expectedData;

    }
}
