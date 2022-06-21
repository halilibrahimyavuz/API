import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest01 {

    Response response;

    //rest-assured kullanrak api testing yapacagız
   //given-->rest assured den gelen bır methottur.
   //when--> sonra http methodları yazılır get-post-put-patch-delete den bırısı
   //then--> dogrulaya yarar then den sonra dogurlama yanı asserthat kullanrız
   //assetThat-->dogrula şunu
   //statusCode(200)--> statuscode 200 mü dogrula




   //get ile endpointe gidip status code kontrolü yapılmak isteniyor
    @Test
    public void getMethod01(){
        //1- end poınt belırlenmelı  https://automationexercise.com/api/productsList
        //2- beklenenn sonuc expected result olusturulur.bu nu bı yerde tutmam lazım kı sonra karıslastırayım.
        //3-request gonderecegım -- get post
        //4- responce body ı actual result olarak olusturuyorz kı expected result ıle karsılastır.
        //ectual ve expected ı karsılastır dogrula a ssertion yap.


        String url="https://automationexercise.com/api/productsList";

        response = given().when().get(url);

        response.jsonPath().prettyPrint();

        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());
        System.out.println(response.getContentType());


        //   given().
     //   when().
     //        get("https://restful-booker.herokuapp.com/booking").
     //   then().
     //   assertThat().statusCode(200);


    }






    //get ile alınan datayi console da gormek istiyorum
    @Test
    public void getMethod02(){

  //    Response response=  given().
  //                        when().
  //                        get("https://restful-booker.herokuapp.com/booking/2");
//
  //      //response body i console yazdırmak için kullanılır
  //     response.prettyPrint();
  //      //statuscode u console da yazadırmak için
  //      System.out.println("Status Code : "+response.getStatusCode());
  //      //statusline ı console da gormek için
  //      System.out.println("Status line : "+response.getStatusLine());
  //      System.out.println("Status line : "+response.statusLine());
  //      //response body'deki datanin content type için
  //      System.out.println("Content Type : "+response.contentType());
  //      //Header'daki tüm bilgileri almak
  //      System.out.println(response.getHeaders());
  //      //Header'daki spesifik bilgileri almak
  //      System.out.println(response.getHeader("Date"));
  //      //Assertions yapalim
  //      //1
  //      response.then().assertThat().
  //              statusLine("HTTP/1.1 200 OK").
  //              contentType("application/json; charset=utf-8").
  //              statusCode(200);
//
    }

}
