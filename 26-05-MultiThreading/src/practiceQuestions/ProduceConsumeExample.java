package practiceQuestions;

import java.util.LinkedList;
import java.util.Queue;

public class ProduceConsumeExample {

    Queue<Integer> buffer = new LinkedList<>();
    private int capacity = 5;
    public synchronized void produce(int value) {
        while (buffer.size() == capacity) {
            try {
                System.out.println("Waiting for Consumer");
                wait();

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        buffer.add(value);
        System.out.println("Produced: " + value);
        notify();
    }
    public synchronized int consume()  {
        while (buffer.isEmpty()) {
            try {
                System.out.println("Waiting for produce");
                wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        int value = buffer.poll();
        System.out.println("Consumed: " + value);
        notify();
        return value;
    }


    public static void main(String[] args) {

        ProduceConsumeExample pc = new ProduceConsumeExample();


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
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        producer.start();
        consumer.start();
    }



}
