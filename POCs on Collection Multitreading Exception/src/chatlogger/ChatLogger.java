package chatlogger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

public class ChatLogger {
    private final String logFile = "C:\\Users\\ShohebPathan\\Atyeti_Shoheb_Java\\POCs on Collection Multitreading Exception\\src\\chatlogger\\chatlog.txt";
    Logger logger = Logger.getLogger(ChatLogger.class.getName());


    public synchronized void logMessage(String user, String message) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(logFile, true))) {
            writer.println(user + ": " + message);
            logger.info(user + " sent message: " + message);
        }
        catch (IOException e) {
           logger.warning("Failed to write message from " + user + ": " + e.getMessage());
        }


    }
}

