package file_utility;
import appconfig.FileConfig;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;
public class ErrorFileWriter {

    static Logger logger = Logger.getLogger(ErrorFileWriter.class.getName());

    public static void log(String message) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FileConfig.ERROR_LOG_FILE, true))) {
            bw.write("[ERROR] " + message);
            bw.newLine();
        } catch (IOException ioe) {
            logger.warning("Failed to write to error-log.txt: " + ioe.getMessage());
        }
    }
}
