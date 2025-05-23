package src.flight_booking_system.main;



import java.io.IOException;
import java.time.LocalDate;
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


        System.out.println("List passengers flying on a specific date.");

        Map<LocalDate, List<String>> localDateListMap = BookingService.passengersFlyingOnSpecificDate(bookings);
        Set<Map.Entry<LocalDate, List<String>>> flyingPassenger = localDateListMap.entrySet();

        for (Map.Entry<LocalDate, List<String>> entry : flyingPassenger) {
            System.out.println("Passengers are flying on "+entry.getKey()+"\n"+entry.getValue());
        }

        System.out.println("Detect duplicate bookings using passenger name + flightId.");
        List<Booking> duplicateBooking= BookingService.duplicateDetection(bookings);
        for(Booking booking : duplicateBooking)
        {
            System.out.println(booking);
        }
    }
}
