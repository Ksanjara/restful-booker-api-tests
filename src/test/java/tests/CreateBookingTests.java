package tests;

import models.Booking;
import models.CreateBookingResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class CreateBookingTests extends TestBase {

    @DisplayName("Create successful booking")
    @Tag("API")
    @Test
    void successfulBookingTest() {
        Booking bookingData = steps.createRandomBookingData();
        CreateBookingResponseModel response = steps.createBooking(bookingData);
        steps.checkBookingIsCreated(response);
    }
}
