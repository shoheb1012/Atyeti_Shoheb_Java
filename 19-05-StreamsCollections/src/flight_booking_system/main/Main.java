package src.flight_booking_system.main;

import src.flight_booking_system.filehandling.FileHandler;
import src.flight_booking_system.model.Booking;
import src.flight_booking_system.service.BookingService;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\ShohebPathan\\tyeti_Shoheb_Java\\19-05-StreamsCollections\\src\\flight_booking_system\\resources\\bookings.csv";
        List<Booking> bookings = FileHandler.bookingData(filePath);
        System.out.println(bookings);


        System.out.println("total revenue  per flight");
        Map<String, Double> stringDoubleMap = BookingService.totalRevenuePerFlight(bookings);
        Set<Map.Entry<String, Double>> entries = stringDoubleMap.entrySet();
        for (Map.Entry<String, Double> entry : entries) {
            System.out.println(entry);
        }


    }
}
