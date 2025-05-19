package src.flight_booking_system.service;

import src.flight_booking_system.model.Booking;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookingService {


    public static Map<String,Double> totalRevenuePerFlight(List<Booking>bookings)
    {
        return bookings.stream().collect(
                Collectors.groupingBy(Booking::getFlightId,
                Collectors.summingDouble(Booking::getFare)));
    }
}
