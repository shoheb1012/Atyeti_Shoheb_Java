package service;

import model.VehicleEntry;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class VehicleService {

    //Identify vehicles that overstayed (more than 3 hours).
    public static List<VehicleEntry> overstayedVehicles(List<VehicleEntry>vehicleEntryList)
    {
      return  vehicleEntryList.stream()
                .filter(x-> Duration.between(x.getEntry_time(),x.getExit_time()).toMinutes()>180)
                .collect(Collectors.toList());
    }
}
