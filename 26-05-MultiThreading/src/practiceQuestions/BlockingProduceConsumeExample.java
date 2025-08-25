package practiceQuestions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingProduceConsumeExample {


    BlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(5);

    public void produce(int value) {
        try {
            buffer.put(value);
            System.out.println("Produced: " + value);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void consume() {
        try {
            int value = buffer.take();
            System.out.println("Consumed: " + value);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }


    public static void main(String[] args) {

        BlockingProduceConsumeExample pc = new BlockingProduceConsumeExample();


        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 25; i++) {

                pc.produce(i);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });


        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 25; i++) {

                pc.consume();

                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        producer.start();
        consumer.start();
    }


}

