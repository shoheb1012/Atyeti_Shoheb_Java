package fileutitlity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.concurrent.atomic.AtomicInteger;

public class LogFileReader {

    //private  int errorCount=0;
    private static AtomicInteger errorCount = new AtomicInteger(0);
    // private AtomicInteger errorCount;
    private static AtomicInteger warnCount = new AtomicInteger(0);
    // private int warnCount = 0;
    //private int infoCount = 0;
    private static AtomicInteger infoCount = new AtomicInteger(0);

    public static void processLogFile(File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int lineNumber = 0;
            String firstLine = null;
            String lastLine = null;

            while ((line = br.readLine()) != null) {
                if (lineNumber == 0) {
                    firstLine = line;
                }
                lastLine = line;

                if (line.contains("INFO")) {
                    infoCount.incrementAndGet();
                } else if (line.contains("WARNING")) {
                    warnCount.incrementAndGet();
                } else if (line.contains("ERROR")) {
                    errorCount.incrementAndGet();
                }
                lineNumber++;
            }


            if (firstLine != null) {
                String[] parts = firstLine.split(",");
                if (parts.length != 2 || !isValidDateFormat(parts[1])) {
                    System.out.println("Invalid header format in file: " + file.getName() +
                            ". Expected format: <file_name>,yyyyMMdd");
                }
            }


            if (lastLine != null) {
                int expectedLineCount = lineNumber - 1; // Exclude footer
                try {
                    int footerValue = Integer.parseInt(lastLine.trim());
                    if (footerValue != expectedLineCount) {
                        System.out.println("Invalid footer in file: " + file.getName() +
                                ". Expected line count: " + expectedLineCount +
                                ", but found: " + footerValue);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Footer is not a number in file: " + file.getName());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean isValidDateFormat(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        try {
            LocalDate parsedDate = LocalDate.parse(date, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static int getErrorCount() {
        return errorCount.get();
    }

    public static int getWarnCount() {
        return warnCount.get();
    }

    public static int getInfoCount() {
        return infoCount.get();
    }
}

