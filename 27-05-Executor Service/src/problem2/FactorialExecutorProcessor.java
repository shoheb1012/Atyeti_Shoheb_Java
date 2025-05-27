package problem2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class FactorialExecutorProcessor {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(12,34,6,2,4);

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        ArrayList <Future<Long>> futures = new ArrayList<>();
        for(int num : numbers)
        {
            Callable<Long>longCallable=new FactorialPrinter(num);
            Future<Long> submit = executorService.submit(longCallable);
            futures.add(submit);
        }

        for (int i = 0; i < numbers.size(); i++) {
            try {
                Long factorial = futures.get(i).get(); // Blocking call
                System.out.println("Factorial of " + numbers.get(i) + " is: " + factorial);
            } catch (InterruptedException | ExecutionException e) {
                System.err.println("Error computing factorial of " + numbers.get(i) + ": " + e.getMessage());
            }
        }

        executorService.shutdown();
    }
}
