package nilApi;

import Utilities.nilApi.PlaceHolder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testdata.PlaceHolderTestData;

import static io.restassured.RestAssured.given;

public class PostRequest03 extends PlaceHolder {

    //{
    //        "userId": 55,
    //        "title": "abikee cankee senikee yerimkee",
    //        "completed": true
    //    }


   // https://jsonplaceholder.typicode.com/todos

    @Test
    public void postReq03(){
        PlaceHolderTestData testData=new PlaceHolderTestData();
        JSONObject expectedData=testData.postRequestData(); //

        System.out.println("expectedData = " + expectedData);


        Response response=given()
                .contentType(ContentType.JSON)
                .spec(spec01)
                .body(expectedData.toString())  //toString yazmayınca dataları tam vermıyor
                .when()
                .post("/todos");

        System.out.println("response "+response.prettyPrint());


        //Matcher class ile .............
        response.then().assertThat()
                .statusCode((Integer) expectedData.getInt("code"))
                .body("completed", Matchers.equalTo(expectedData.getBoolean("completed"))
                        ,"title",Matchers.equalTo(expectedData.getString("title"))
                        ,"userId",Matchers.equalTo(expectedData.getInt("userId")));

            //JSonPaTH İLE

         JsonPath json=response.jsonPath();
         System.out.println("json = " + json.prettyPrint());

        Assert.assertEquals(expectedData.getInt("userId"),json.getInt("userId"));
        Assert.assertEquals(expectedData.getString("title"),json.getString("title"));
        Assert.assertEquals(expectedData.getBoolean("completed"),json.getBoolean("completed"));








    }




}
