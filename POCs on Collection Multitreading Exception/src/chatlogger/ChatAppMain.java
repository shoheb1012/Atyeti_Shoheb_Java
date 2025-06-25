package chatlogger;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.Scanner;

public class ChatAppMain {
    public static void main(String[] args) {
        ChatLogger logger = new ChatLogger();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of users in chat: ");
        int userCount = Integer.parseInt(scanner.nextLine());


        ExecutorService executor = Executors.newFixedThreadPool(userCount);

        for (int i = 1; i <= userCount; i++) {
            System.out.print("Enter name for User " + i + ": ");
            String userName = scanner.nextLine();

            executor.submit(() -> {
                while (true) {
                    System.out.print( userName + " Type message or type 'exit' to quit: ");
                    String message = scanner.nextLine();
                    if (message.equalsIgnoreCase("exit")) {
                        System.out.println(userName + " has left the chat.");
                        break;
                    }
                    logger.logMessage(userName, message);
                }
            });
        }

        executor.shutdown();
    }
}
