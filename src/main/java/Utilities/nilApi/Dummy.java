package Utilities.nilApi;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class Dummy {

    protected RequestSpecification spec02;

    @Before
    public void setup(){
        spec02=new RequestSpecBuilder()
                .setBaseUri("http://dummy.restapiexample.com/api/v1")
                .build();

        //spec01  -> olusturdum buna uri i tanımladım ve ınsa ettım artık prtected olan spec01 ı her yeren kullanabılırım

    }
}
