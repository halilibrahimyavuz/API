package Utilities.nilApi;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class PlaceHolder {

    protected RequestSpecification spec01;



    @Before
    public void setup(){
        spec01=new RequestSpecBuilder()
                .setBaseUri("https://jsonplaceholder.typicode.com")
                .build();

            //spec01  -> olusturdum buna uri i tanımladım ve ınsa ettım artık prtected olan spec01 ı her yeren kullanabılırım

    }

}
