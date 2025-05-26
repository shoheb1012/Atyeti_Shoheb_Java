package problem2;

class Consumer extends Thread {
    private final Buffer buffer;
    private int itemCount;

    public Consumer(Buffer buffer, int itemCount) {
        this.buffer = buffer;
        this.itemCount = itemCount;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < itemCount; i++) {
                buffer.consume();
                Thread.sleep(800); // simulate delay
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
