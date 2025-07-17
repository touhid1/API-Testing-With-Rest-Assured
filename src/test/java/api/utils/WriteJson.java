package api.utils;

import com.github.javafaker.Faker;
import com.hossain.ebrahim.model.Booking;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WriteJson {

    public void writeJson() {
        Faker faker = new Faker();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        List<Booking> users = Arrays.asList(
                new Booking(
                        faker.name().firstName(),
                        faker.name().lastName(),
                        faker.number().numberBetween(50, 500),
                        faker.bool().bool(),
                        new Booking.BookingDates(
                                dateFormat.format(faker.date().past(5, TimeUnit.DAYS)),
                                dateFormat.format(faker.date().future(10, TimeUnit.DAYS))
                        ),
                        faker.lorem().sentence()
                )
        );

        // Assuming we only have one Booking object in the list for simplicity
        Booking booking = users.get(0);

        // Convert Booking to JSON
        JSONObject bookingDates = new JSONObject();
        bookingDates.put("checkin", booking.getBookingdates().getCheckin());
        bookingDates.put("checkout", booking.getBookingdates().getCheckout());

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("firstname", booking.getFirstname());
        jsonObject.put("lastname", booking.getLastname());
        jsonObject.put("totalprice", booking.getTotalprice());
        jsonObject.put("depositpaid", booking.isDepositpaid());
        jsonObject.put("bookingdates", bookingDates);
        jsonObject.put("additionalneeds", booking.getAdditionalneeds());

        try {
            Files.write(Paths.get("src/main/resources/booking.json"), jsonObject.toString(4).getBytes());
            System.out.println("Data saved to booking.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
