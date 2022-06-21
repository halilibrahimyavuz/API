package nilApi;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest01 {

    Response response;

    @Test
    public void getRequest01(){

        //1- end poınt belırlenmelı  https://automationexercise.com/api/productsList
        //2- beklenenn sonuc expected result olusturulur.bu nu bı yerde tutmam lazım kı sonra karıslastırayım.
        //3-request gonderecegım -- get post
        //4- responce body ı actual result olarak olusturuyorz kı expected result ıle karsılastır.
        //ectual ve expected ı karsılastır dogrula a ssertion yap.


        String url="https://automationexercise.com/api/productsList";

        response = given().when().get(url);

        //  response.jsonPath().prettyPrint();

        System.out.println("statuscode :"+response.getStatusCode());    //--->200
        System.out.println("statuslıne : "+response.getStatusLine());      //--->HTTP/1.1 200 OK
        System.out.println("contentType : "+response.getContentType());    //--->text/html; charset=utf-8

        Assert.assertEquals(200,response.getStatusCode());
        Assert.assertEquals("HTTP/1.1 200 OK",response.getStatusLine());
        Assert.assertEquals("text/html; charset=utf-8",response.getContentType());

       // System.out.println("response.getHeaders() = " + response.getHeaders());  // --> tum headersları yazdırır


        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("text/html; charset=utf-8")
                .statusLine("HTTP/1.1 200 OK");

    }
}
