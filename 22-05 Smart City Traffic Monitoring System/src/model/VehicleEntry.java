package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class VehicleEntry {

    private String vehicle_id;
    private String vehicle_type;
    private String location;
    private LocalDateTime entry_time;
    private LocalDateTime exit_time;

    public VehicleEntry(String vehicle_id, String vehicle_type, String location, LocalDateTime entry_time, LocalDateTime exit_time) {
        this.vehicle_id = vehicle_id;
        this.vehicle_type = vehicle_type;
        this.location = location;
        this.entry_time = entry_time;
        this.exit_time = exit_time;
    }

    public String getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(String vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public String getVehicle_type() {
        return vehicle_type;
    }

    public void setVehicle_type(String vehicle_type) {
        this.vehicle_type = vehicle_type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getEntry_time() {
        return entry_time;
    }

    public void setEntry_time(LocalDateTime entry_time) {
        this.entry_time = entry_time;
    }

    public LocalDateTime getExit_time() {
        return exit_time;
    }

    public void setExit_time(LocalDateTime exit_time) {
        this.exit_time = exit_time;
    }

    @Override
    public String toString() {
        return
                        "vehicle_id='" + vehicle_id + '\'' +
                        ", vehicle_type='" + vehicle_type + '\'' +
                        ", location='" + location + '\'' +
                        ", entry_time=" + entry_time +
                        ", exit_time=" + exit_time;
    }
}
