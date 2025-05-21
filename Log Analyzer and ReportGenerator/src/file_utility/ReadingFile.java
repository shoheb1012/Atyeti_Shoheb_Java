package file_utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReadingFile {

    public void processLogFile(File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null)
            {

            }
        } catch (Exception e) {
            ErrorFileWriter.log("Failed to process file: " + file.getName() + " => " + e.getMessage());
        }
    }
}
