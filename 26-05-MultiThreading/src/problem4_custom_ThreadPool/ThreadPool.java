package problem4_custom_ThreadPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ThreadPool {
    private BlockingQueue<Runnable> blockingQueue;

    public ThreadPool(int queueSize, int noOfThreads) {
        blockingQueue = new LinkedBlockingDeque<>(queueSize);
        TaskExecutor taskExecutor = null;
        for (int i = 0; i < noOfThreads; i++) {
            taskExecutor = new TaskExecutor(blockingQueue);
            Thread thread = new Thread(taskExecutor);
            thread.start();
        }
    }

    public void submit(Runnable runnable) {
        blockingQueue.add(runnable);
    }
}