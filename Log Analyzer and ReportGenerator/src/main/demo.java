package main;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class demo {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CountDownLatch countDownLatch = new CountDownLatch(3);

        for(int i =0;i<6;i++)
        {
            try {
                int finalI = i;
                executorService.submit(() -> {
                    System.out.println(+finalI +" Hii by " + Thread.currentThread().getName());
                });
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            finally {
                countDownLatch.countDown();
            }
        }

        try
        {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            executorService.shutdown();
        }
    }
}
