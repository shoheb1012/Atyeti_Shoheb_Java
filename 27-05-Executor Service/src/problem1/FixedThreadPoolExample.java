package problem1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FixedThreadPoolExample {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Future>futures = new ArrayList<>();
        for(int i=0;i<10;i++)
        {
            int taskNumber=i;
            Future submit = executorService.submit(() ->
            {
                String threadName = Thread.currentThread().getName();
                System.out.println("Task " + taskNumber + " is running on " + threadName);

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            futures.add(submit);
        }
        executorService.shutdown();

        for(Future future:futures) {
            try {
                future.get();
            } catch (ExecutionException |InterruptedException e) {
                throw new RuntimeException(e);
            }
        }




    }
}
