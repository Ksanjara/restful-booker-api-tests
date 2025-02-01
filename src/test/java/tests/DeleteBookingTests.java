package tests;

import io.qameta.allure.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static config.ProjectConfigCreator.config;

@Owner("Kseniia Kuznetsova")
@Feature("Testing delete booking of Restful-Booker service")
@Tag("api")
public class DeleteBookingTests extends TestBase {
    @DisplayName("Delete booking successfully")
    @Story("Testing of booking deletion")
    @Severity(SeverityLevel.BLOCKER)
    @Tag("Positive")
    @Test
    void deleteBookingTest() {
        String token = steps.token(config.username(), config.password());
        Integer bookingId = testData.randomId;
        Response deleteResponse = steps.deleteBooking(token, bookingId);
        steps.checkBookingIsDeleted(deleteResponse);
    }
}
