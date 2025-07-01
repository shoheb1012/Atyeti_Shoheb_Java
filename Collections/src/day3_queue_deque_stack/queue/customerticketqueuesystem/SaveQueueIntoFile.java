package day3_queue_deque_stack.queue.customerticketqueuesystem;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Queue;

public class SaveQueueIntoFile {

    public static void saveQueueToFile(Queue<Ticket> queue,String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(queue);
            System.out.println("Queue saved to file.");
        } catch (IOException e) {
            System.out.println(" Failed to save queue: " + e.getMessage());
        }
    }
}
