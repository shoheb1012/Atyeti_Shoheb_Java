package logfileanalyzer.utility;

import logfileanalyzer.pojo.UserLogEntry;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class LogFileAnalyzer {

    public static List<UserLogEntry> readingLogsData(String filePath) throws IOException {

        List<UserLogEntry> userLogEntries = new ArrayList<>();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            String line="";
            while ((line=bufferedReader.readLine())!=null)
            {

                String[] split = line.split(",");
                Timestamp localDateTime = Timestamp.valueOf(split[0].trim());
                String userName= split[1].trim();
                String action = split[2].trim();
               UserLogEntry entry = new UserLogEntry(localDateTime,userName,action);

               userLogEntries.add(entry);

            }

            return userLogEntries;
        }
    }


