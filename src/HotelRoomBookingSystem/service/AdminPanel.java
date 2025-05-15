package HotelRoomBookingSystem.service;

import HotelRoomBookingSystem.model.DeluxeRoom;
import HotelRoomBookingSystem.model.StandardRoom;
import HotelRoomBookingSystem.model.SuiteRoom;
import HotelRoomBookingSystem.HotelRoomBookingSystem;
import java.util.Scanner;

public class AdminPanel {

    private HotelService hotelService;
    Scanner sc = new Scanner(System.in);

    public AdminPanel(HotelService hotelService) {
        this.hotelService = hotelService;

    }

    public void showAdminMenu() {
        while (true) {
            System.out.println("--- Admin Panel ---");
            System.out.println("1. Add Room");
            System.out.println("2. Show All Rooms");
            System.out.println("3. View Customer Details");
            System.out.println("4. Exit");
            System.out.println("5. Go Back ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addRoom();
                    break;
                case 2:
                    hotelService.showAllRooms();
                    break;
                case 3:
                    System.out.print("Enter Room Number: ");
                    int roomNumber = sc.nextInt();
                    hotelService.showCustomerDetails(roomNumber);


                case 4:
                    System.out.println("Exiting Admin Panel.");
                    System.exit(0);
                case 5:
                   HotelRoomBookingSystem.welcomeToHotel(hotelService);

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void addRoom() {
        System.out.print("Enter Room Number: ");
        int num = sc.nextInt();
        System.out.print("Price per Night: ");
        double price = sc.nextDouble();
        System.out.print("Is AC true/false: ");
        boolean ac = sc.nextBoolean();
        System.out.println("Room Type: 1-Deluxe 2-Suite 3-Standard");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                DeluxeRoom deluxeRoom = new DeluxeRoom(num, ac, price);
                hotelService.addRoom(deluxeRoom);
                System.out.println("Room added successfully");
                break;
            case 2:
                SuiteRoom suiteRoom = new SuiteRoom(num, ac, price);
                hotelService.addRoom(suiteRoom);
                System.out.println("Room added successfully");
                break;
            case 3:
                StandardRoom standardRoom = new StandardRoom(num, ac, price);
                hotelService.addRoom(standardRoom);
                System.out.println("Room added successfully");
                break;
            default:
                System.out.println("Invalid Room type");

        }


    }

}


