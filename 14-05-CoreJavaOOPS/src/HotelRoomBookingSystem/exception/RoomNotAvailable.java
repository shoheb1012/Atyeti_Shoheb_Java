package HotelRoomBookingSystem.exception;

public class RoomNotAvailable extends RuntimeException {

    public RoomNotAvailable(String msg) {
        super(msg);
    }
}
