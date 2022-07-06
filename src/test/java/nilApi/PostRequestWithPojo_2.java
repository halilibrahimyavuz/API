package nilApi;

import Utilities.nilApi.Herokuapp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import pojos.BookingResponsePojo;

import static io.restassured.RestAssured.given;

public class PostRequestWithPojo_2  extends Herokuapp {

    @Test
    public void PostPojo(){

        //https://restful-booker.herokuapp.com/booking


        BookingDatesPojo bookingdates=new BookingDatesPojo("2020-02-20","2022-02-22");
        BookingPojo bookingPojo=new BookingPojo("sare","YAVUZ",5250,true,bookingdates);
        //BookingDatesPojo veya BookıngPojo claslarında kalıpları belırledım ancak ıcıne degerlerı koymadım
        //Yukarıda obje olusturup o claslardakı key lere value ataması yaptım parantez ıclerınde ototmatık olarak kendısı gordu ve degerler atandı

        System.out.println("bookingPojo = " + bookingPojo);

        Response response=given()
                .contentType(ContentType.JSON)
                .spec(spec03)
                .auth().basic("admin","password123")
                .body(bookingPojo)
                .when()
                .post("/booking");

        response.prettyPrint();

        BookingResponsePojo actualData=response.as(BookingResponsePojo.class);
        System.out.println("actualData = " + actualData);

        Assert.assertEquals(200,response.getStatusCode());

        Assert.assertEquals(bookingPojo.getFirstname(),actualData.getBooking().getFirstname());
        Assert.assertEquals(bookingPojo.getLastname(),actualData.getBooking().getLastname());
        Assert.assertEquals(bookingPojo.getTotalprice(),actualData.getBooking().getTotalprice());
        Assert.assertEquals(bookingPojo.getBookingdates().getCheckin(),actualData.getBooking().getBookingdates().getCheckin());
        Assert.assertEquals(bookingPojo.getBookingdates().getCheckout(),actualData.getBooking().getBookingdates().getCheckout());






    }


}
