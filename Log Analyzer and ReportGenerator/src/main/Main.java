package main;
import appconfig.DataBaseConfig;
import appconfig.FileConfig;
import dbutility.TableCreation;

import java.io.File;
import java.sql.SQLException;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args)  {
        // 1 Creating Table
        Logger logger = Logger.getLogger(Main.class.getName());
        try
       {
           TableCreation.createTable(DataBaseConfig.query) ;
       }
       catch (SQLException sqlException)
       {
           System.out.println(sqlException.getMessage());
       }


        //Reading Files From Directory
        File logDirectory = new File(FileConfig.LOG_DIRECTORY);
        if (!logDirectory.exists() || !logDirectory.isDirectory()) {
            System.out.println("Log directory not found: " + FileConfig.LOG_DIRECTORY);
        }

        File[] files = logDirectory.listFiles((dir, name) -> name.endsWith(".log"));

        if (files == null || files.length == 0) {
            System.out.println("No log files found in " + FileConfig.LOG_DIRECTORY);
        }
        for(File file : files)
        {

        }

    }
}