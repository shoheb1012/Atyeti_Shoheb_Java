package day3_queue_deque_stack.queue;

import java.util.*;

public class QueueComparison {
    public static void main(String[] args) {
        int ops = 100000;

        Queue<Integer> linkedQueue = new LinkedList<>();
        Queue<Integer> arrayQueue = new ArrayDeque<>();

        long start1 = System.currentTimeMillis();
        for (int i = 0; i < ops; i++) {
            linkedQueue.offer(i);
        }
        for (int i = 0; i < ops; i++) linkedQueue.poll();
        {

        }
        long end1 = System.currentTimeMillis();
        System.out.println("LinkedList Queue time: " + (end1 - start1) +" ms");

        long start2 = System.currentTimeMillis();
        for (int i = 0; i < ops; i++) arrayQueue.offer(i);
        {

        }
        for (int i = 0; i < ops; i++) arrayQueue.poll();
        {

        }
        long end2 = System.currentTimeMillis();
        System.out.println("ArrayDeque Queue time: " + (end2 - start2) + " ms");
    }
}

