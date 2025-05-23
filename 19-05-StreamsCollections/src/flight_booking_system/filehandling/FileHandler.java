package src.flight_booking_system.filehandling;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    public static List<Booking> bookingData(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        ArrayList<Booking> bookings = new ArrayList<>();
        String line = "";
        reader.readLine();
        while ((line = reader.readLine()) != null) {
            String[] split = line.split(",");
            Booking booking = new Booking(split[0], split[1], LocalDate.parse(split[2]), Double.parseDouble(split[3]));
            bookings.add(booking);
        }

        return bookings;

    }
}


