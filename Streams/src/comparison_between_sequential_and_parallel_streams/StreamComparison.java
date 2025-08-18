package comparison_between_sequential_and_parallel_streams;

import java.util.ArrayList;
import java.util.Random;

/*
    Clearly shows parallel stream winning when tasks involve waiting (Thread.sleep).
    Without the delay, parallel may not always win because overhead dominates.
 */
public class StreamComparison {
    public static void main(String[] args) {

        int size = 10_000;
        ArrayList<Integer> nums = new ArrayList<>(size);
        Random random = new Random();
        for (int i = 1; i <= size; i++) {
            nums.add(random.nextInt(100));
        }
        //System.out.println(nums);
        long sequentialStart = System.currentTimeMillis();
        int sum1 = nums.stream()
                .map(x -> {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                    return x * 2;
                })
                .mapToInt(x -> x)
                .sum();
        long sequentialEnd = System.currentTimeMillis();

        long parallelStart = System.currentTimeMillis();
        int sum2 = nums.parallelStream()
                .map(x -> {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                    return x * 2;
                })
                .mapToInt(x -> x)
                .sum();

        long parallelEnd = System.currentTimeMillis();
        System.out.println("Sequential Stream sum : " + sum1);
        System.out.println("Parallel Stream sum : " + sum2);
        System.out.println("Sequential Stream : " + (sequentialEnd - sequentialStart));
        System.out.println("Parallel Stream : " + (parallelEnd - parallelStart));
    }
}
