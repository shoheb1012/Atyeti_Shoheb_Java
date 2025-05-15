package HotelRoomBookingSystem.model;


import HotelRoomBookingSystem.model.enums.RoomType;

import javax.xml.transform.Source;

public class StandardRoom extends Room {

    public StandardRoom(int roomNumber, boolean isAC, double pricePerNight) {
        super(roomNumber, RoomType.STANDARD, isAC, pricePerNight);
    }

    @Override
    public double calculateBill(int nights) {
        double bill = nights * super.getPricePerNight();
        double serviceTax = bill * 0.12;
        double acCharge = super.isAC() ? 150 : 0;
        double discount = nights > 5 ? 300 : 0;

        System.out.println("Invoice"+"\nBill :"+bill+"\nserviceTax :"+serviceTax+"\nAC Charge :"+acCharge+"\nDiscount :"+discount);
        return bill + serviceTax + acCharge - discount;
    }
}
