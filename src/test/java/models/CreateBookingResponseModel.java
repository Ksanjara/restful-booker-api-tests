package models;

import lombok.Data;

@Data
public class CreateBookingResponseModel {
    private Integer bookingid;
    private Booking booking;
}
