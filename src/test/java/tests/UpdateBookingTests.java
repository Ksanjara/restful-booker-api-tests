package tests;

import models.Booking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static config.ProjectConfigCreator.config;

public class UpdateBookingTests extends TestBase {
    @DisplayName("Update tourist name")
    @Tag("API")
    @Test
    void updateFirstnameTest() {
        String token = steps.token(config.username(), config.password());
        Integer bookingId = testData.randomId;
        String newFirstName = testData.firstName;
        Booking bookingData = steps.getBookingById(bookingId);
        bookingData.setFirstname(newFirstName);
        Booking response = steps.patchBookingRequest(bookingData, bookingId, token);
        steps.checkFirstnameUpdated(response, newFirstName);
    }

    @DisplayName("Update all booking info")
    @Tag("API")
    @Tag("ready")
    @Test
    void updateAllBookingTest() {
        String token = steps.token(config.username(), config.password());
        Integer bookingId = testData.randomId;
        Booking newBookingData = steps.createRandomBookingData();

        Booking response = steps.updateAllBookingRequest(newBookingData, bookingId, token);
        steps.checkAllBookingUpdated(newBookingData, response);
    }

    @DisplayName("Update total price")
    @Tag("API")
    @Test
    void updateTotalPriceTest() {
        String token = steps.token(config.username(), config.password());
        Integer bookingId = testData.randomId;
        Integer newTotalprice = testData.totalPrice;
        Booking bookingData = steps.getBookingById(bookingId);
        bookingData.setTotalprice(newTotalprice);

        Booking response = steps.patchBookingRequest(bookingData, bookingId, token);
        steps.checkTotalpriceUpdated(response, newTotalprice);
    }
}

