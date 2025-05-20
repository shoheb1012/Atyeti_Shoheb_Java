package src.flight_booking_system.service;

import src.flight_booking_system.model.Booking;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class BookingService {


    public static Map<String,Double> totalRevenuePerFlight(List<Booking>bookings)
    {
        return bookings.stream().collect(
                Collectors.groupingBy(Booking::getFlightId,
                Collectors.summingDouble(Booking::getFare)));
    }

    public static Map<LocalDate,List<String>> passengersFlyingOnSpecificDate(List<Booking>bookings)
    {
       return  bookings.stream().collect(
               Collectors.groupingBy(Booking::getDate,
             Collectors.mapping(Booking::getPassengerName,
                       Collectors.toList())));
    }


    public static List<Booking> duplicateDetection(List<Booking> bookings) {
        Set<String> seen = new HashSet<>();
        return bookings.stream()
                .filter(b -> !seen.add(b.getPassengerName() + "_" + b.getFlightId()))
                .collect(Collectors.toList());
    }



}
