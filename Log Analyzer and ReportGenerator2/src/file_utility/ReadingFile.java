package file_utility;

import pojo.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadingFile {
    private int errorCount = 0;
    private int warnCount = 0;
    private int infoCount = 0;

    public void processLogFile(File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("INFO")) {
                    infoCount += 1;
                } else if (line.contains("WARNING")) {
                    warnCount += 1;
                } else if (line.contains("ERROR")) {
                    errorCount += 1;
                }
                //  DuplicateFile.writeFile(line);
            }

        } catch (Exception e) {
            ErrorFileWriter.log("Failed to process file: " + file.getName() + " => " + e.getMessage());
        }
    }

    public int getErrorCount() {
        return errorCount;
    }

    public int getWarnCount() {
        return warnCount;
    }

    public int getInfoCount() {
        return infoCount;
    }
}
