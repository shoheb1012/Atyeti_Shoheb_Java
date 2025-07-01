package day3_queue_deque_stack.queue.customerticketqueuesystem;

import java.io.Serializable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ticket implements Serializable {

    private final int priority;
    private static int ticketCounter = 1001;
    private final int ticketId;
    private final String customerName;
    private final LocalDateTime timestamp;

    public Ticket( String customerName,int priority) {
        this.priority = priority;
        this.ticketId = ticketCounter++;
        this.customerName = customerName;
        this.timestamp = LocalDateTime.now();
    }

    public int getTicketId() {
        return ticketId;
    }
    public String getCustomerName() {
        return customerName;
    }

    public String getFormattedTime() {
        return timestamp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public int getPriority() { return priority; }

    @Override
    public String toString() {
        String type = (priority == 1) ? "VIP" : "Regular";
        return "#" + ticketId + " | " + customerName + " | " + type + " | " + getFormattedTime();
    }
}
