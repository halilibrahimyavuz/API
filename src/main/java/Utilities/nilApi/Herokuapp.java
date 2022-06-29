package Utilities.nilApi;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.Before;

public class Herokuapp {
    protected RequestSpecification spec03;

    @Before
    public void setup(){
        spec03=new RequestSpecBuilder()
                .setBaseUri("https://restful-booker.herokuapp.com")
                .build();


    }

}
