package main;

import appconfig.*;
import dbutility.*;

import exceptionhandling.*;

import file_utility.*;
import pojo.*;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.logging.Logger;
import java.util.zip.ZipFile;

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
        List<Future> futures = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(files.length);
       // CountDownLatch countDownLatch = new CountDownLatch(files.length);
        for (File file : files) {
            Future submit = executorService.submit(() -> {
                try {
                    readingFile.processLogFile(file);
                    //DuplicateFile.writeDataToDuplicateFile(file);
                } catch (Exception e) {
                    ErrorFileWriter.log("Error processing file " + file.getName() + ": " + e.getMessage());
                }
            });
            futures.add(submit);
        }
        executorService.shutdown();

        for(Future future :futures)
        {
           try {
               future.get();
           } catch (ExecutionException | InterruptedException e) {
               ErrorFileWriter.log(e.getMessage());
           }
        }


        
        InsertingDataIntoDb.insertingCountIntoTable(readingFile.getErrorCount(), readingFile.getWarnCount(), readingFile.getInfoCount());

        //System.out.println(readingFile.getErrorCount());

    }
}