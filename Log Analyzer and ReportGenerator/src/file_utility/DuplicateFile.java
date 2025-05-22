package file_utility;

import appconfig.FileConfig;

import java.io.*;

import static file_utility.ErrorFileWriter.logger;

public class DuplicateFile {
    public static void writeDataToDuplicateFile(File logFile) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(logFile));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FileConfig.DUPLICATE_LOG_FILE, true));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedReader.close();
            bufferedWriter.close();

        } catch (IOException e) {

            ErrorFileWriter.log(e.getMessage());

        }

    }

}
