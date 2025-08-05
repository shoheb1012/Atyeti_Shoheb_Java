package task_2_fix_StringConcatenationPerformance;


import java.util.*;

/*
WHY IS THIS SO SLOW?

Every time you do: result = result + item + ", "

Java creates a NEW string object because strings are immutable!

So for 10,000 items:
- First iteration: Creates 1 new string
- Second iteration: Creates 1 new string (copies the previous string + new item)
- Third iteration: Creates 1 new string (copies the previous TWO items + new item)
- ...
- 10,000th iteration: Creates 1 new string (copies 9,999 previous items + new item)

This becomes O(n²) complexity instead of O(n)!


*/

// SLOW CODE - Fix performance issue
public class ReportService {


    public String buildReport(List<String> items) {
        String result = "";
        for (String item : items) {
            result = result + item + ", ";
        }
        return result;
    }

    public String buildReportWithStringBuilder(List<String> items) {
        StringBuilder result = new StringBuilder();
        for (String item : items) {
            result = result.append(item).append(", ");
        }
        return result.toString();
    }

    // Let's test how slow this really is
    public static void main(String[] args) {
        ReportService service = new ReportService();


        List<String> smallList = Arrays.asList("Apple", "Banana", "Cherry");
        List<String> mediumList = new ArrayList<>();
        List<String> largeList = new ArrayList<>();


        for (int i = 0; i < 1000; i++) {
            mediumList.add("Item_" + i);
        }


        for (int i = 0; i < 10000; i++) {
            largeList.add("Product_" + i);
        }

        System.out.println("=== STRING CONCATENATION PERFORMANCE TEST ===\n");


        long startTime = System.currentTimeMillis();
        String smallResult = service.buildReport(smallList);
        long endTime = System.currentTimeMillis();
        System.out.println("Small list (3 items):");
        System.out.println("Result: " + smallResult);
        System.out.println("Time taken: " + (endTime - startTime) + " ms\n");

        // Test medium list
        startTime = System.currentTimeMillis();
        String mediumResult = service.buildReport(mediumList);
        endTime = System.currentTimeMillis();
        System.out.println("Medium list (1,000 items):");
        System.out.println("Result length: " + mediumResult.length() + " characters");
        System.out.println("Time taken: " + (endTime - startTime) + " ms\n");

        // Test large list - This will be VERY slow!
        System.out.println("Testing large list (10,000 items)...");
        startTime = System.currentTimeMillis();
        String largeResult = service.buildReport(largeList);
        endTime = System.currentTimeMillis();
        System.out.println("Large list (10,000 items):");
        System.out.println("Result length: " + largeResult.length() + " characters");
        System.out.println("Time taken: " + (endTime - startTime) + " ms");

        if (endTime - startTime > 1000) {
            System.out.println(" SLOW! This took more than 1 second!");
            System.out.println(" Imagine if this was 100,000 items in production!");
        }


        System.out.println("YOUR TASK: Fix the buildReport() method to make it fast!");


        System.out.println("=== STRING BUILDER CONCATENATION PERFORMANCE TEST ===\n");


        startTime = System.currentTimeMillis();
        smallResult = service.buildReportWithStringBuilder(smallList);
        endTime = System.currentTimeMillis();
        System.out.println("Small list (3 items):");
        System.out.println("Result: " + smallResult);
        System.out.println("Time taken: " + (endTime - startTime) + " ms\n");

        // Test medium list
        startTime = System.currentTimeMillis();
        mediumResult = service.buildReportWithStringBuilder(mediumList);
        endTime = System.currentTimeMillis();
        System.out.println("Medium list (1,000 items):");
        System.out.println("Result length: " + mediumResult.length() + " characters");
        System.out.println("Time taken: " + (endTime - startTime) + " ms\n");

        // Test large list - This will be VERY slow!
        System.out.println("Testing large list (10,000 items)...");
        startTime = System.currentTimeMillis();
        largeResult = service.buildReportWithStringBuilder(largeList);
        endTime = System.currentTimeMillis();
        System.out.println("Large list (10,000 items):");
        System.out.println("Result length: " + largeResult.length() + " characters");
        System.out.println("Time taken: " + (endTime - startTime) + " ms");
        // System.out.println(largeResult);


    }
}


