package HotelRoomBookingSystem;

import HotelRoomBookingSystem.exception.RoomNotAvailable;
import HotelRoomBookingSystem.model.Customer;
import HotelRoomBookingSystem.model.Room;
import HotelRoomBookingSystem.model.enums.OccupancyStatus;
import HotelRoomBookingSystem.service.AdminPanel;
import HotelRoomBookingSystem.service.HotelService;

import java.time.LocalDate;
import java.util.Scanner;

public class HotelRoomBookingSystem {
    public static void main(String[] args) {

        HotelService hotel = new HotelService();


        welcomeToHotel(hotel);
    }



        public static void welcomeToHotel(HotelService hotel)
        {
            Scanner sc = new Scanner(System.in);
            AdminPanel admin = new AdminPanel(hotel);
        while (true) {
            System.out.println("---- Welcome to Star Hotel ----");
            System.out.println("1. Show Available Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Checkout");
            System.out.println("4. Admin Panel");
            System.out.println("5. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    hotel.showAvailableRooms();
                    break;
                case 2:
                    sc.nextLine();
                    System.out.print("Enter your name: ");
                    String name = sc.nextLine();
                    System.out.print("Mobile Number: ");
                    long mob = sc.nextLong();
                    System.out.print("Room Number: ");
                    int roomNo = sc.nextInt();
                    System.out.print("Number of days: ");
                    int days = sc.nextInt();

                    Room room;
                    try {
                        room = hotel.getRoomByNumber(roomNo);
                        if (room.getStatus() == OccupancyStatus.AVAILABLE) {
                            Customer customer = new Customer(name, mob, LocalDate.now(), days, room);
                            hotel.bookRoom(roomNo, customer);
                            break;
                        } else {
                            throw new RoomNotAvailable("Room is not available currently.");
                        }
                    } catch (RoomNotAvailable e) {
                        System.out.println(e.getMessage());
                    }

                case 3:
                    System.out.print("Enter Room Number: ");
                    int roomNumber = sc.nextInt();
                    hotel.checkoutRoom(roomNumber);

                case 4:
                    admin.showAdminMenu();
                case 5:
                    System.out.println("Thank you for visiting!");
                    System.exit(0);

                default:
                    System.out.println("Invalid option.");
            }
        }


    }


}




