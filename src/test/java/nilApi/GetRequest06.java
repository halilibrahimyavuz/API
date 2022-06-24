package nilApi;

import Utilities.nilApi.Dummy;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

   //     response.prettyPrint();


     //   JsonPath jsonPath=response.jsonPath();
//
     //   System.out.println(jsonPath.getList("data.employee_name"));
//
     //   System.out.println(jsonPath.getString("data[2].employee_name"));
//
     //   System.out.println(jsonPath.getString("data.employee_name[0,1,2,3,4,5]"));
//
     //   System.out.println(jsonPath.getString("data.employee_name[-1]"));


     //Assert.assertTrue(jsonPath.getList("data.employee_name").contains("Rhona Davidson"));

     // List<Integer> arananYaslar= Arrays.asList(21,23,61);

     // List<Integer> aranayaslar2=new ArrayList<Integer>();
     // aranayaslar2.add(21);
     // aranayaslar2.add(23);
     // aranayaslar2.add(61);

     // Assert.assertTrue(jsonPath.getList("data.employee_age").containsAll(aranayaslar2));
     //   Assert.assertTrue(jsonPath.getList("data.employee_age").containsAll(arananYaslar));


    }



}
