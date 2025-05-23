package src.main;

import src.appconfig.DataBaseConfig;
import src.appconfig.FileConfig;
import src.dbutility.InsertingDataIntoDb;
import src.dbutility.TableCreation;
import src.exceptionhandling.DataBaseException;
import src.file_utility.DuplicateFile;
import src.file_utility.ErrorFileWriter;
import src.file_utility.ReadingFile;
import pojo.Log;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) throws SQLException {
        // 1 Creating Table
        Logger logger = Logger.getLogger(Main.class.getName());
        try {
            TableCreation.createTable(DataBaseConfig.TABLE_CREATION_QUERY);
        } catch (DataBaseException exception) {
            System.out.println(exception.getMessage());
            ErrorFileWriter.log(exception.getMessage());
        }


        //Reading Files From Directory
        File logDirectory = new File(FileConfig.LOG_DIRECTORY);
        File[] files = logDirectory.listFiles((dir, name) -> name.endsWith(".log"));
        if (files == null || files.length == 0) {
            System.out.println("No log files found in " + FileConfig.LOG_DIRECTORY);
        }
        ReadingFile readingFile = new ReadingFile();
        ExecutorService executorService = Executors.newFixedThreadPool(files.length);
        for (File file : files) {
            //readingFile.processLogFile(file);
            executorService.submit(() -> readingFile.processLogFile(file));
            //DuplicateFile.writeDataToDuplicateFile(file);
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(5, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            ErrorFileWriter.log("Executor interrupted: " + e.getMessage());
        }

        InsertingDataIntoDb.insertingCountIntoTable(readingFile.getErrorCount(), readingFile.getWarnCount(), readingFile.getInfoCount());

        //System.out.println(readingFile.getErrorCount());

    }
}