package problem1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;

public class ThreadUtils {

    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);
        System.out.println("enter the Number of Threads ");
        int n = sc.nextInt();
        List<Thread>threads = new ArrayList<>();
        Counter counter = new Counter();
        for(int i=0;i<n;i++)
        {
            Thread thread = new Thread(()->{
                counter.sharedIntegerCounter();
            });
            threads.add(thread);
            thread.start();
        }

        for(Thread thread : threads)
            thread.join();



        System.out.println("final value of the counter : "+counter.getCounting());
    }
}
