package HotelRoomBookingSystem.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Customer {

    private static int counter=1000;
    private int customerId;
    private String name;
    private long mobileNumber;
    private LocalDate checkInDate;
    private int duration;
    private Room bookedRoom;

    public Customer(String name, long mobileNumber, LocalDate checkInDate, int duration, Room room) {
        this.customerId = counter++;
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.checkInDate = checkInDate;
        this.duration = duration;
        this.bookedRoom = room;
    }

    public double getBill()
    {
        return  bookedRoom.calculateBill(duration);
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Customer.counter = counter;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Room getBookedRoom() {
        return bookedRoom;
    }

    public void setBookedRoom(Room bookedRoom) {
        this.bookedRoom = bookedRoom;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", mobileNumber=" + mobileNumber +
                ", checkInDate=" + checkInDate +
                ", duration=" + duration +
                ", bookedRoom=" + bookedRoom +
                '}';
    }
}
