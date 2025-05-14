package HotelRoomBookingSystem.model;


import HotelRoomBookingSystem.model.enums.RoomType;

public class SuiteRoom extends Room{

    public SuiteRoom(int roomNumber, boolean isAC, double pricePerNight) {
        super(roomNumber, RoomType.STANDARD, isAC, pricePerNight);
    }

    @Override
    public double calculateBill(int nights) {
        double bill = nights * super.getPricePerNight();
        double serviceTax = bill * 0.12;
        double acCharge = super.isAC() ? 150 : 0;
        double discount = nights > 5 ? 350 : 0;
        return bill + serviceTax + acCharge - discount;

    }
}
