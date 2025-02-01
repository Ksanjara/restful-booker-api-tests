package tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static config.ProjectConfigCreator.config;

public class DeleteBookingTests extends TestBase {
    @DisplayName("Delete booking successfully")
    @Tag("API")
    @Test
    void deleteBookingTest() {
        String token = steps.token(config.username(), config.password());
        Integer bookingId = testData.randomId;
        Response deleteResponse = steps.deleteBooking(token, bookingId);
        steps.checkBookingIsDeleted(deleteResponse);
    }
}
