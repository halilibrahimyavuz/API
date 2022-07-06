package nilApi;

import Utilities.nilApi.Customer;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static Utilities.TokenAlma.tokenAlma;
import static io.restassured.RestAssured.given;

public class TC04  {
    //https://www.gmibank.com/api/tp-customers
    Customer customer1;
    Response response;
    //  Faker faker=new Faker();
  //  int id;
  //  String firstName;
  //  String lastName;
  //  String middleInitial;
  //  String email;
  //  String mobile;
  //  String ssn;
  //  String adress;
    @Test
    public void test(){
     //  id=150150;
     //  firstName=new Faker().name().firstName();
     //  lastName=new Faker().name().lastName();
     //  middleInitial =new Faker().name().nameWithMiddle();
     //  email=new Faker().internet().emailAddress();
     //  mobile=new Faker().phoneNumber().phoneNumber();
     //  ssn=new Faker().idNumber().ssnValid();
     //  adress=new Faker().address().fullAddress();
     //  customer=new Customer();
     //  customer.setFirstName(firstName);
     //  customer.setLastName(lastName);
     //  customer.setMiddleInitial(middleInitial);
     //  customer.setEmail(email);
     //  customer.setPhoneNumber(mobile);
     //  customer.setSsn(ssn);
     //  customer.setAddress(adress);

          customer1=new Customer("hell1o1111","adams111","m099","hel555@gamil.com","343-434-4333","canada","750-25-7507");
       // spec.pathParam("param","tp-customers");
        response=given()
                .contentType(ContentType.JSON)
                .auth().oauth2(tokenAlma())
                .body(customer1)
                .when()
                .post("https://www.gmibank.com/api/tp-customers");

        response.prettyPrint();

        // De-Serialization
        Customer actualData=response.as(Customer.class);
        System.out.println("actualData = " + actualData);

       Assert.assertEquals(customer1.getFirstName(),actualData.getFirstName());
     /*    Assert.assertEquals(customer1.getLastName(),actualData.getLastName());
        Assert.assertEquals(customer1.getAddress(),actualData.getAddress());
        Assert.assertEquals(customer1.getEmail(),actualData.getEmail());
        Assert.assertEquals(customer1.getMiddleInitial(),actualData.getMiddleInitial());
        Assert.assertEquals(customer1.getPhoneNumber(),actualData.getPhoneNumber());
        Assert.assertEquals(customer1.getSsn(),actualData.getSsn());
      */
    }
}