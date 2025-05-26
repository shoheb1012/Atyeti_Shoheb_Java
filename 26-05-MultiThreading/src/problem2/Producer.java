package problem2;

public class Producer extends Thread {

    private final Buffer buffer;
    private int itemCount;

    public Producer(Buffer buffer, int itemCount) {
        this.buffer = buffer;
        this.itemCount = itemCount;
    }

    @Override
    public void run() {
        int value = 0;
        try {
            for (int i = 0; i < itemCount; i++) {
                buffer.produce(i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


