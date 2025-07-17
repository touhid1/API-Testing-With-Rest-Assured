package api.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hossain.ebrahim.model.Booking;

import java.io.File;
import java.io.IOException;

public class RequestBodyBuilder {

    private static final String BOOKING_JSON_PATH = "src/main/resources/booking.json";

    // Method to create a request body for authentication
    public static String createAuthBody() {
        String username = ConfigReader.getProperty("username");
        String password = ConfigReader.getProperty("password");

        if (username == null || password == null) {
            throw new RuntimeException("Username or Password is not set in the configuration file.");
        }

        System.out.println("Username: " + username);
        System.out.println("Password: " + password);

        return String.format(
                "{ \"username\": \"%s\", \"password\": \"%s\" }",
                username, password
        );
    }

    // Method to read booking from JSON file
    public static Booking readBookingFromJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File(BOOKING_JSON_PATH), Booking.class);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to read booking from JSON file: " + BOOKING_JSON_PATH, e);
        }
    }

    public static String createBookingBody(Booking booking) {
        if (booking == null) {
            throw new IllegalArgumentException("Invalid booking data!");
        }

        return String.format(
                "{ \"firstname\": \"%s\", \"lastname\": \"%s\", \"totalprice\": %d, \"depositpaid\": %b, " +
                        "\"bookingdates\": { \"checkin\": \"%s\", \"checkout\": \"%s\" }, \"additionalneeds\": \"%s\" }",
                booking.getFirstname(), booking.getLastname(), booking.getTotalprice(), booking.isDepositpaid(),
                booking.getBookingdates().getCheckin(), booking.getBookingdates().getCheckout(),
                booking.getAdditionalneeds()
        );
    }

    // Method to create a request body for updating a booking
    public static String createUpdateBookingBody(Booking booking, String token) {
        if (booking == null) {
            throw new IllegalArgumentException("Invalid booking data!");
        }

        // Constructing the request body
        String requestBody = String.format(
                "{ \"firstname\": \"%s\", \"lastname\": \"%s\", \"totalprice\": %d, \"depositpaid\": %b, " +
                        "\"bookingdates\": { \"checkin\": \"%s\", \"checkout\": \"%s\" }, \"additionalneeds\": \"%s\" }",
                booking.getFirstname(), booking.getLastname(), booking.getTotalprice(), booking.isDepositpaid(),
                booking.getBookingdates().getCheckin(), booking.getBookingdates().getCheckout(),
                booking.getAdditionalneeds()
        );
        // Returning the request body
        return requestBody;
    }
}
