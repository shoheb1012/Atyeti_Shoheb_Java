package day3_queue_deque_stack.queue.customerticketqueuesystem;


import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.PriorityQueue;
import java.util.Queue;

public class LoadQueueFromFile {

    public static Queue<Ticket> loadQueueFromFile(String filepath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filepath))) {
            PriorityQueue<Ticket> queue = (PriorityQueue<Ticket>) ois.readObject();
            System.out.println("Queue loaded from file.");
            return queue;
        } catch (Exception e) {
            System.out.println(" No existing queue found. Starting fresh.");
            return new PriorityQueue<>(new TicketPriorityComparator());
        }
    }
}
