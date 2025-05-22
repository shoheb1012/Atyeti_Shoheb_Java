package main;

import appconfig.DataBaseConfig;
import appconfig.FileConfig;
import dbutility.InsertingDataIntoDb;
import dbutility.TableCreation;
import exceptionhandling.DataBaseException;
import file_utility.DuplicateFile;
import file_utility.ErrorFileWriter;
import file_utility.ReadingFile;
import pojo.Log;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) throws SQLException {
        // 1 Creating Table
        Logger logger = Logger.getLogger(Main.class.getName());
        try {
            //  TableCreation.createTable(DataBaseConfig.TABLE_CREATION_QUERY);
        } catch (DataBaseException exception) {
            System.out.println(exception.getMessage());
            ErrorFileWriter.log(exception.getMessage());
        }


        //Reading Files From Directory
        File logDirectory = new File(FileConfig.LOG_DIRECTORY);

        if (!(logDirectory.exists()) || !(logDirectory.isDirectory())) {
            System.out.println("Log directory not found: " + FileConfig.LOG_DIRECTORY);
        }

        File[] files = logDirectory.listFiles((dir, name) -> name.endsWith(".log"));
        if (files == null || files.length == 0) {
            System.out.println("No log files found in " + FileConfig.LOG_DIRECTORY);
        }
        ReadingFile readingFile = new ReadingFile();
        for (File file : files) {
            readingFile.processLogFile(file);
            //DuplicateFile.writeDataToDuplicateFile(file);
        }

        InsertingDataIntoDb.insertingCountIntoTable(readingFile.getErrorCount(), readingFile.getWarnCount(), readingFile.getInfoCount());


    }
}