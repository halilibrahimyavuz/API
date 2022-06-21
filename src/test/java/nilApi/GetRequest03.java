package nilApi;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class GetRequest03 {


        Response response;

        @Test
        public void GetRequest(){

            String endPoint="https://dummy.restapiexample.com/api/v1/employees";

            response=given().when().get(endPoint);
            response.prettyPrint();


            //employee sayısı 24?
            // employeelerden bırı "xxx" mi
            // gelen yaslar ıcınde 21-61 and 23 oldugunu dogrula

            response
                    .then()
                    .assertThat()
                    .statusCode(200)
                    .contentType(ContentType.JSON)
                    .body("data.id",Matchers.hasSize(24),
                            "data.employee_name",Matchers.hasItem("Doris Wilder"),
                            "data.employee_age",Matchers.hasItems(21,61,23));



}

}
