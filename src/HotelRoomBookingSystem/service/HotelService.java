package HotelRoomBookingSystem.service;

import HotelRoomBookingSystem.exception.CustomerInvalid;
import HotelRoomBookingSystem.exception.RoomNotAvailable;
import HotelRoomBookingSystem.model.Customer;
import HotelRoomBookingSystem.model.Room;
import HotelRoomBookingSystem.model.enums.OccupancyStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HotelService {
    private List<Room> rooms = new ArrayList<>();
    private Map<Integer, Customer> customerMap = new HashMap<>();

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void showAvailableRooms() {
        for (Room room : rooms) {
            if (room.getStatus() == OccupancyStatus.AVAILABLE) {
                System.out.println(room.getRoomNumber() + " - " + room.getRoomType() + " - ₹" + room.getPricePerNight() + " - " + (room.isAC() ? "AC" : "Non-AC"));
            }

        }
    }

    public void bookRoom(int roomNumber, Customer customer) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && room.getStatus() == OccupancyStatus.AVAILABLE) {
                room.bookRoom();
                customerMap.put(roomNumber, customer);

                System.out.println("Room " + roomNumber + " booked for " + customer.getName());

            }
            else {
                throw new RoomNotAvailable("Sorry Room not Available");
            }
        }

    }

    public void checkoutRoom(int roomNumber) {
        if (customerMap.containsKey(roomNumber)) {
            Customer customer = customerMap.get(roomNumber);
            System.out.println("Customer: " + customer.getName());
            System.out.println("Total Bill: ₹" + customer.getBill());
            customer.getBookedRoom().checkoutRoom();
            customerMap.remove(roomNumber);
        } else {
            System.out.println("Room not currently booked.");
        }
    }

    public void showAllRooms() {
        for (Room room : rooms) {
            System.out.println("Room Number "+room.getRoomNumber() + " - Room Type" + room.getRoomType() + " - " + room.getStatus());
        }
    }

    public void showCustomerDetails(int roomNumber) {
        if (customerMap.containsKey(roomNumber)) {
            System.out.println(customerMap.get(roomNumber));
        }


    }

    public Room getRoomByNumber(int roomNo) {

        return rooms.stream()
                .filter(x -> x.getRoomNumber() == roomNo)
                .findFirst()
                .orElseThrow(()-> new RoomNotAvailable("Room not available"));

    }
}


