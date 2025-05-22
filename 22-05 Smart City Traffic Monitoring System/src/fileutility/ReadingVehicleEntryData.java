package fileutility;

import model.VehicleEntry;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ReadingVehicleEntryData {

    public static List<VehicleEntry> vehicleEntries(String filePath) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        List<VehicleEntry> listOfEntries = new ArrayList<>();
        reader.readLine();
        String line ="";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        while ((line=reader.readLine())!=null)
        {
            String[] split= line.split(",");
            VehicleEntry vehicleEntry = new VehicleEntry(split[0],split[1],split[2], LocalDateTime.parse(split[3],formatter),LocalDateTime.parse(split[4],formatter));
            listOfEntries.add(vehicleEntry);
        }
        return listOfEntries;
    }

}
