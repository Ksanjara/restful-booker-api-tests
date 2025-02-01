package tests;

import io.qameta.allure.*;
import models.Booking;
import models.CreateBookingResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


@Owner("Kseniia Kuznetsova")
@Feature("Testing of creation booking on Restful-Booker service")
@Tag("api")
public class CreateBookingTests extends TestBase {

    @DisplayName("Create successful booking")
    @Story("Testing of successful booking")
    @Severity(SeverityLevel.BLOCKER)
    @Tag("Positive")
    @Test
    void successfulBookingTest() {
        Booking bookingData = steps.createRandomBookingData();
        CreateBookingResponseModel response = steps.createBooking(bookingData);
        steps.checkBookingIsCreated(response);
    }
}
