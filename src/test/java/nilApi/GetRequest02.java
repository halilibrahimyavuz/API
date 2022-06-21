package nilApi;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class GetRequest02 {

Response response;

    @Test
    public void getRequest002(){

        String url="https://restful-booker.herokuapp.com/booking";

        response = given().when().get(url);


     //   response.jsonPath().prettyPrint();

       response
               .then()
               .assertThat()
               .statusCode(200)
               .body("bookingid[0]",Matchers.equalTo(629));


    }
}
