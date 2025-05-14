package HotelRoomBookingSystem.model;

import HotelRoomBookingSystem.model.enums.RoomType;

public class DeluxeRoom extends Room {


    public DeluxeRoom(int roomNumber, boolean isAC, double pricePerNight) {
        super(roomNumber, RoomType.DELUXE, isAC, pricePerNight);
    }

    @Override
    public double calculateBill(int nights) {
        double bill = nights * super.getPricePerNight();
        double serviceTax = bill * 0.12;
        double acCharge = super.isAC() ? 300 : 0;
        double discount = nights > 5 ? 400 : 0;
        return bill + serviceTax + acCharge - discount;
    }
}
