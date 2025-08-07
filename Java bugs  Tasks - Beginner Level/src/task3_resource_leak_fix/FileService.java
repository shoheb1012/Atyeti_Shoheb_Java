package task3_resource_leak_fix;

import java.io.*;
import java.util.Scanner;

/**
 * FileService - Handles file operations with proper resource management
 * <p>
 * ORIGINAL PROBLEM: All methods had resource leaks - FileReader, BufferedReader,
 * Scanner, and Stream objects were never closed, causing "Too many open files"
 * errors in production.
 * <p>
 * SOLUTION: Replaced manual resource management with try-with-resources blocks
 * to ensure automatic cleanup even when exceptions occur.
 *
 * @author ShohebPathan
 */

public class FileService {


    /*
     * FIX APPLIED: Used try-with-resources to automatically close resources
     * - Resources are closed automatically when try block exits
     * - Works even if IOException occurs
     * - No manual cleanup required
     */
    public String readFile(String filename) {
        try (FileReader file = new FileReader(filename); BufferedReader reader = new BufferedReader(file)) {
            return reader.readLine();
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return "Error reading file";
        }

    }


    public void processConfigFile(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("Config: " + line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Config file not found: " + filename);
        }

    }





    public static void main(String[] args) {
        FileService service = new FileService();

        // Create a test file first
        createTestFile("test.txt", "Hello World!\nThis is line 2\nEnd of file");
        createTestFile("config.txt", "database.url=localhost:5432\napp.name=MyApp");

        String s = service.readFile("test.txt");
        System.out.println(s);

        for (int i = 0; i < 5; i++) {
            String content = service.readFile("test.txt");
            System.out.println("Read " + (i + 1) + ": " + content);
        }


        service.processConfigFile("config.txt");




    }


    private static void createTestFile(String filename, String content) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(content);
        } catch (IOException e) {
            System.err.println("Could not create test file: " + filename);
        }
    }
}


