package nilApi;

import Utilities.nilApi.Dummy;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class GetRequest11_MatcherClass extends Dummy {

    @Test
    public void dummy() {

        Dummy expectedObje=new Dummy();
        HashMap<String,Object> expectedDataMap=expectedObje.setupTestData();

        System.out.println("EXPECTED DATA  : "+expectedDataMap);


        Response response=given()
                .spec(spec02)
                .when()
                .get("/employees");

          response.prettyPrint();

          response
                  .then()
                  .assertThat()
                  .statusCode((Integer) expectedDataMap.get("statusCode"))
                  .body("data[4].employee_name", equalTo(expectedDataMap.get("besinciClaisan")),
                          "data.id" ,hasSize((Integer) expectedDataMap.get("calisanSayisi")),
                          "data[-2].employee_salary", equalTo(expectedDataMap.get("sondanIkınciCalisanmaasi")),
                          "data.employee_age",Matchers.hasItems(((List)expectedDataMap.get("arananYaslar")).get(0),
                                                                ((List)expectedDataMap.get("arananYaslar")).get(1),
                                                                ((List)expectedDataMap.get("arananYaslar")).get(2)),
                          "data[10].employee_name", equalTo(((Map)expectedDataMap.get("onbirinciCalisan")).get("employee_name")),
                          "data[10].employee_salary", equalTo(((Map)expectedDataMap.get("onbirinciCalisan")).get("employee_salary")),
                          "data[10].employee_age", equalTo(((Map)expectedDataMap.get("onbirinciCalisan")).get("employee_age")))  ;










    }


}
