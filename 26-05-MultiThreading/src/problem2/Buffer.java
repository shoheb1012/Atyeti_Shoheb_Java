package problem2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Logger;

public class Buffer {
    private final int capacity=6;
    private final Queue<Integer> integerQueue = new LinkedList<>();
    Logger logger =Logger.getLogger(Buffer.class.getName());

    public synchronized void produce(int value) throws InterruptedException {
        while (integerQueue.size()==capacity)
        {
            logger.info("Buffer is full. Producer is waiting...");
            wait();
        }
        integerQueue.add(value);
        System.out.println("produced value "+value);
        notify();

    }

    public synchronized void consume() throws InterruptedException {
        while (integerQueue.isEmpty()) {
           logger.info("Buffer is empty. Consumer is waiting...");
            wait();
        }

        int value = integerQueue.poll();
        System.out.println("Consumed: " + value);

        notify(); // notify waiting producer

    }



}
