package src.file_utility;

import pojo.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ReadingFile {
    //private  int errorCount=0;
    private  AtomicInteger errorCount = new AtomicInteger(0);
   // private AtomicInteger errorCount;
    private AtomicInteger warnCount = new AtomicInteger(0);
   // private int warnCount = 0;
    //private int infoCount = 0;
    private AtomicInteger infoCount = new AtomicInteger(0);

    public  void processLogFile(File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("INFO")) {
                    infoCount.incrementAndGet();
                } else if (line.contains("WARNING")) {
                    warnCount.incrementAndGet();
                } else if (line.contains("ERROR")) {
                    errorCount.incrementAndGet();
                }

                //  DuplicateFile.writeFile(line);
            }

        } catch (Exception e) {
            ErrorFileWriter.log("Failed to process file: " + file.getName() + " => " + e.getMessage());
        }
    }

    public int getErrorCount() {
        return errorCount.get();
    }

    public int getWarnCount() {
        return warnCount.get();
    }

    public int getInfoCount() {
        return infoCount.get();
    }
}
