package api.endpoinds;

import com.hossain.ebrahim.api.base.BaseAPI;
import io.restassured.response.Response;

public class BookingEndpoint extends BaseAPI {
    private static final String BOOKING_ENDPOINT = "/booking";

    public Response getBookingById(int id) {
        return get(BOOKING_ENDPOINT + "/" + id);
    }

    public Response createBooking(Object bookingPayload) {
        return post(BOOKING_ENDPOINT, bookingPayload);
    }

    public Response updateBooking(int id, Object bookingPayload, String token) {
        return put(BOOKING_ENDPOINT + "/" + id, bookingPayload, token);
    }

    public Response deleteBooking(int id, String token) {
        return delete(BOOKING_ENDPOINT + "/" + id, token);
    }
}
