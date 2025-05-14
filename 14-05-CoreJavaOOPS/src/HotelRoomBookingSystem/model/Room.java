package HotelRoomBookingSystem.model;

import HotelRoomBookingSystem.model.enums.OccupancyStatus;
import HotelRoomBookingSystem.model.enums.RoomType;

public abstract class Room {

    private int roomNumber;
    private RoomType roomType;
    private boolean isAC;
    private double pricePerNight;
    private OccupancyStatus status;

    public Room(int roomNumber, RoomType roomType, boolean isAC, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.isAC = isAC;
        this.pricePerNight = pricePerNight;
        this.status= OccupancyStatus.AVAILABLE;
    }

    public abstract double calculateBill(int nights);

    public void bookRoom() {
        status = OccupancyStatus.OCCUPIED;
    }
    public void checkoutRoom() {
        status = OccupancyStatus.AVAILABLE;
    }


    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public boolean isAC() {
        return isAC;
    }

    public void setAC(boolean AC) {
        isAC = AC;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public OccupancyStatus getStatus() {
        return status;
    }

    public void setStatus(OccupancyStatus status) {
        this.status = status;
    }
}

