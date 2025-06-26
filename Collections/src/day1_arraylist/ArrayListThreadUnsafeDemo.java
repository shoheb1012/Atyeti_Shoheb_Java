package day1_arraylist;

import java.util.ArrayList;
import java.util.List;

public class ArrayListThreadUnsafeDemo {
    public static void main(String[] args) throws InterruptedException {

        List<Integer> list = new ArrayList<>();

        Runnable task=()->
        {

            for (int i = 0; i < 1000; i++) {
                list.add(i);
            }

        };
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println("Expected size: 2000 | Actual size: " + list.size());

    }
}
