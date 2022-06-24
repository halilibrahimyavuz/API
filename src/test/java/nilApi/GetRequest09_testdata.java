package nilApi;

import Utilities.nilApi.PlaceHolder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import testdata.PlaceHolderTestData;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class GetRequest09_testdata extends PlaceHolder {


    @Test
    public void testdata(){

        System.out.println("*********** DESERİALİZATİON  ***************");
        //javada ousturdugumuz bır nesneyı veya sınıfı saklamak yada transfer etmek ıstedıgımız formata donusturme
        //işlemine serializatıon denır.
        //Bunun tam tersı duruma ıser De-seriazlization denır.
        //yanı apı de donen response u Map-List-List Of Map veya Set gibi java objelerıne cevırme ıslemıdır.
        // ozet olarak cevap olarak gelen json fortmatlı yada benzerı formatlı dataların java ya cevrılmesıdır.
        //bu yontemle verıfy yapabılırız
        //farklım kutuphaneler yuklememız lazım +dependency
        //++gson library    ++jackson-mapper-asl library

        //De-Serializaton:(Json formatındaki datayı Java Objectlerine dönüştürür(gson kullanarak))
        //object mapper kullanarak ve
        // pojo class ıle maplerı kullanarak yapılabılır





        PlaceHolderTestData testData=new PlaceHolderTestData();
        HashMap<String,Object> expectedData= (HashMap<String, Object>) testData.setupTestData();
        System.out.println("expectedData = " + expectedData);



        Response response=given().spec(spec01).when().get("/todos/2");

        response.prettyPrint();



        System.out.println("********* MAtcher class ıle assertıon yaptık  ******");

        response
                .then()
                .assertThat()
                .statusCode((Integer)expectedData.get("statusCode"))
                .header("via", Matchers.equalTo(expectedData.get("via")))
                .body("completed",Matchers.equalTo(expectedData.get("completed")))
                .body("title",Matchers.equalTo(expectedData.get("title")));


        System.out.println( "*********  JsonPath ıle aasssertıon yaptık   **************");

        JsonPath jsonPath=response.jsonPath();
        Assert.assertEquals(expectedData.get("statusCode"),response.getStatusCode());

        Assert.assertEquals(expectedData.get("via"),response.getHeader("via"));

        Assert.assertEquals(expectedData.get("title"),jsonPath.getString("title"));

        Assert.assertEquals(expectedData.get("userId"),jsonPath.getInt("userId"));

        Assert.assertEquals(expectedData.get("completed"),jsonPath.getBoolean("completed"));


        System.out.println("*********** DESERİALİZATİON  ***************");
        //object mapper kullan
        // pojo class ıle maplerı kullan


        HashMap<String,Object> actualData=response.as(HashMap.class);

        Assert.assertEquals(expectedData.get("userId"),actualData.get("userId"));

        Assert.assertEquals(expectedData.get("title"),actualData.get("title"));

        Assert.assertEquals(expectedData.get("completed"),actualData.get("completed"));








    }




}
