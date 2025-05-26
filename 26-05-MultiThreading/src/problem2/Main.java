package problem2;

public class Main {
    public static void main(String[] args) {

        Buffer buffer = new Buffer();
        int itemCount = 30;
        Consumer consumer = new Consumer(buffer,itemCount);
        Producer producer = new Producer(buffer,itemCount);

        producer.start();
        consumer.start();
    }
}
