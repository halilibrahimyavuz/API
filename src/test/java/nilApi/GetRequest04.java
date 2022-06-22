package nilApi;

import Utilities.nilApi.PlaceHolder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class GetRequest04 extends PlaceHolder {

//{
//    "userId": 7,
//    "id": 123,
//    "title": "esse et quis iste est earum aut impedit",
//    "completed": false
//}

         @Test
         public void GetReq(){

            // artık specd01 var --> String url="https://jsonplaceholder.typicode.com-----
             // param1 --->todos
             // param2---->123

             spec01.pathParams("param1","todos",
                                "param2",12 );

             Response response=given()
                     .spec(spec01)
                     .when()
                     .get("/{param1}/{param2}");


             response.prettyPeek();

                response
                        .then()
                        .assertThat()
                        .statusCode(200)
                        .contentType(ContentType.JSON)
                        .header("Server", Matchers.equalTo("cloudflare"))
                        .body("userId",Matchers.equalTo(7),
                                "title",Matchers.equalTo("esse et quis iste est earum aut impedit"),
                                "completed",Matchers.equalTo(false));

    }


}
