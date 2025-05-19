package src.flight_booking_system.model;

import java.time.LocalDate;

public class Booking {

    private String flightId;
    private String passengerName;
    private LocalDate date;
    private double fare;

    public Booking(String flightId, String passengerName, LocalDate date, double fare) {
        this.flightId = flightId;
        this.passengerName = passengerName;
        this.date = date;
        this.fare = fare;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    @Override
    public String toString() {
        return
                "flightId='" + flightId + '\'' +
                ", passengerName='" + passengerName + '\'' +
                ", date=" + date +
                ", fare=" + fare ;
    }
}
