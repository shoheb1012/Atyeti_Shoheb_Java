package io;

import config.Config;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class ErrorWriter {

    public static void writeErrorToFile(String fileName, String errorMessage) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(Config.ERROR_LOG_PATH, true))) {
            writer.write(LocalDateTime.now() + " - File: " + fileName + " - Error: " + errorMessage);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
