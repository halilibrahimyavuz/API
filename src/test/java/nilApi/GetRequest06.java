package nilApi;

import Utilities.nilApi.Dummy;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest06 extends Dummy {



///api/v1/employees
    @Test
    public void GEtReq(){


        spec02.pathParam("param1","employees");

        Response response=given()
                          .spec(spec02)
                          .when()
                          .get("/{param1}");

        response.prettyPrint();


        JsonPath jsonPath=response.jsonPath();

        System.out.println(jsonPath.getList("data.employee_name"));


    }



}
