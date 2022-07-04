package nilApi;

import Utilities.nilApi.PlaceHolder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.TodosPojo;

import static io.restassured.RestAssured.given;

public class PostRequestWithPojo extends PlaceHolder {

@Test
    public void pojo(){

    TodosPojo requestExpected=new TodosPojo(21,201,"SareBetül-Salıh ",false); //parametrelı cosntructordakı dataları gır
    System.out.println("requestExpected = " + requestExpected);

    Response response=given()
            .contentType(ContentType.JSON)
            .spec(spec01)
            .auth().basic("admin","password123")
            .body(requestExpected) //toStrıng methoduyla geldıghı ıcın toStrıng e gerek yok
            .when()
            .post("/todos");


    response.prettyPrint();

    //De-serializatıon
    TodosPojo actualData=response.as(TodosPojo.class);  //map yerıne olsuturdugumuz kalıp uzerınden actual datayı kulandık

    Assert.assertEquals(201,response.getStatusCode());
    Assert.assertEquals(requestExpected.getUserId(),actualData.getUserId());
    Assert.assertEquals(requestExpected.getId(),actualData.getId());
    Assert.assertEquals(requestExpected.getTitle(),actualData.getTitle());
    Assert.assertEquals(requestExpected.isCompleted(),actualData.isCompleted()); //boolean oldugu ıcın isCompleted



}


}
