import logfileanalyzer.pojo.UserLogEntry;
import logfileanalyzer.utility.LogFileAnalyzer;
import logfileanalyzer.utility.LogUtility;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {

        String filePath = "C:\\Users\\ShohebPathan\\tyeti_Shoheb_Java\\15-5-CoreJava\\src\\logfileanalyzer\\resource\\logs.txt";
        List<UserLogEntry> userLogEntries = LogFileAnalyzer.readingLogsData(filePath);

        long uniqueUserCount = LogUtility.numberUniqueUser(userLogEntries);
        System.out.println("Unique User Count : " + uniqueUserCount);

        String maxUserAction = LogUtility.maxActionUser(userLogEntries, "DOWNLOAD");
        System.out.println("User "+ maxUserAction +" having Highest Downloads ");


        String minUserAction = LogUtility.minActionUser(userLogEntries, "DOWNLOAD");
        System.out.println("User "+minUserAction+" having lowest Downloads ");


        Map<LocalDate, Map<String, Set<String>>> summary = LogUtility.getDailyActionSummary(userLogEntries);

        summary.forEach((date, actionMap) -> {
            System.out.println("Date: " + date);
            actionMap.forEach((action, users) -> {
                System.out.println("  " + action + ": " + users.size() + " users");
            });
        });



    }
}