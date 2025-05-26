package problem4_custom_ThreadPool;

import java.util.concurrent.BlockingQueue;

public class TaskExecutor implements Runnable{

    private BlockingQueue<Runnable> blockingQueue;

    public TaskExecutor(BlockingQueue<Runnable> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (true){
            try {
                // take the task from queue and execute
                Runnable runnable = blockingQueue.take();
                runnable.run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
