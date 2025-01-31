package api;

import data.TestData;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import models.Booking;
import models.BookingDates;
import models.CreateBookingResponseModel;
import models.CreateTokenBodyModel;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static specs.BookingSpec.*;
import static specs.CreateTokenSpec.createTokenRequestSpec;
import static specs.CreateTokenSpec.createTokenResponseSpec;

public class Steps {
    TestData testData = new TestData();

    @Step("Get authorization token")
    public String token(String username, String password) {
        CreateTokenBodyModel authData = new CreateTokenBodyModel();
        authData.setUsername(username);
        authData.setPassword(password);
        String authResponse = given(createTokenRequestSpec)
                .body(authData)
                .when().post()
                .then().spec(createTokenResponseSpec)
                .extract().path("token");

        return authResponse;
    }

    @Step("Update booking with new info")
    public Booking patchBookingRequest(Booking booking, int bookingId, String token) {
        return given(bookingRequestSpec)
                .header("Cookie", "token=" + token)
                .body(booking)
                .when()
                .patch("/" + bookingId)
                .then()
                .extract()
                .as(Booking.class);
    }

    @Step("Get booking by id")
    public Booking getBookingById(int bookingId) {
        return given(bookingRequestSpec)
                .when()
                .get("/" + bookingId)
                .then()
                .extract()
                .as(Booking.class);
    }

    @Step("Create new booking data")
    public Booking createRandomBookingData() {
        Booking bookingData = new Booking();
//        bookingData.setFirstname("testData.firstName");
//        bookingData.setLastname("fdd");
//        bookingData.setTotalprice(101);
//        bookingData.setDepositpaid(true);
//        BookingDates bookingDates = new BookingDates();
//        bookingDates.setCheckin("1213");
//        bookingDates.setCheckout("232");
//        bookingData.setBookingdates(bookingDates);
//        bookingData.setAdditionalneeds("23242");
        bookingData.setFirstname(testData.firstName);
        bookingData.setLastname(testData.lastName);
        bookingData.setTotalprice(testData.totalPrice);
        bookingData.setDepositpaid(testData.depositPaid);
        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin(testData.checkin);
        bookingDates.setCheckout(testData.checkout);
        bookingData.setBookingdates(bookingDates);
        bookingData.setAdditionalneeds(testData.additionalNeeds);

        return bookingData;
    }

    @Step("Create booking")
    public CreateBookingResponseModel createBooking(Booking bookingData) {
        CreateBookingResponseModel response = given(bookingRequestSpec)
                .body(bookingData)
                .when()
                .post()
                .then()
                .spec(bookingSuccessResponseSpec)
                .extract().as(CreateBookingResponseModel.class);

        return response;
    }

    @Step("Check booking is created")
    public Steps checkBookingIsCreated(CreateBookingResponseModel creationResponse) {
        assertThat(creationResponse.getBookingid()).isNotNull();

        return this;
    }

    @Step("Delete booking")
    public Response deleteBooking(String token, Integer bookingId) {
        return given(bookingRequestSpec)
                .header("Cookie", "token=" + token)
                .when()
                .delete("/" + bookingId)
                .then()
                .spec(bookingDeleteResponseSpec)
                .extract().response();
    }

    @Step("Check booking is deleted successfully")
    public Steps checkBookingIsDeleted(Response deletionResponse) {
        assertThat(deletionResponse.statusCode()).isEqualTo(201);

        return this;
    }

    @Step("Check that firstname is changed in booking")
    public Steps checkFirstnameUpdated(Booking bookingData, String newName) {
        assertThat(bookingData.getFirstname()).isEqualTo(newName);

        return this;
    }

    @Step("Update all booking info")
    public Booking updateAllBookingRequest(Booking booking, int bookingId, String token) {
        return given(bookingRequestSpec)
                .header("Cookie", "token=" + token)
                .body(booking)
                .when()
                .put("/" + bookingId)
                .then()
                .extract()
                .as(Booking.class);
    }

    @Step("Check that all booking is updated")
    public Steps checkAllBookingUpdated(Booking newBooking, Booking responseBookingChanged) {
        assertThat(responseBookingChanged).isEqualTo(newBooking);

        return this;
    }

    @Step("Check that totalprice is changed in booking")
    public Steps checkTotalpriceUpdated(Booking bookingData, Integer newTotalprice) {
        assertThat(bookingData.getTotalprice()).isEqualTo(newTotalprice);

        return this;
    }

}
