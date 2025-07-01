package day3_queue_deque_stack.queue.customerticketqueuesystem;

import java.util.*;

public class CustomerTicketQueueSystem {

    public static void main(String[] args) {

        String filepath = "C:\\Users\\ShohebPathan\\Atyeti_Shoheb_Java\\Collections\\src\\day3_queue_deque_stack\\queue\\customerticketqueuesystem\\CustomerQueue.dat";
        PriorityQueue<Ticket> ticketQueue = new PriorityQueue<>(new TicketPriorityComparator());
        Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\n===== Customer Ticket Queue =====");
                System.out.println("1. Add Customer");
                System.out.println("2. Serve Next Customer");
                System.out.println("3. View Waiting Queue");
                System.out.println("4. Save Ticket Queue to File");
                System.out.println("5. Load Ticket Queue from File");
                System.out.println("6. Exit");
                System.out.print(" Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter customer name: ");
                        String name = scanner.nextLine();
                        System.out.print("Priority? (1 = VIP, 2 = Regular): ");
                        int priority = scanner.nextInt();
                        scanner.nextLine();

                        Ticket ticket = new Ticket(name, priority);
                        ticketQueue.offer(ticket);
                        System.out.println(" Ticket created: " + ticket);
                        break;

                    case 2:
                        if (!ticketQueue.isEmpty()) {
                            Ticket servedTicket = ticketQueue.poll();
                            System.out.println(" Serving: " + servedTicket);
                        } else {
                            System.out.println(" No customers in the queue.");
                        }
                        break;

                    case 3:
                        if (ticketQueue.isEmpty()) {
                            System.out.println(" Queue is empty.");
                        } else {
                            System.out.println(" Current Queue:");
                            for (Ticket t : ticketQueue) {
                                System.out.println("    " + t);
                            }
                        }
                        break;
                    case 4: SaveQueueIntoFile.saveQueueToFile(ticketQueue,filepath);
                         break;
                    case 5:
                        Queue<Ticket> tickets = LoadQueueFromFile.loadQueueFromFile(filepath);
                        for(Ticket ticket1 : tickets)
                        {
                            System.out.println(ticket1);
                        }
                        break;
                    case 6:
                        System.out.println(" Exiting... Have a great day!");
                        return;

                    default:
                        System.out.println(" Invalid choice. Try again.");
                }
            }
        }
    }

