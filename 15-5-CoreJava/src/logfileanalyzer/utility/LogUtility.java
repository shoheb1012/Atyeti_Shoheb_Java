package logfileanalyzer.utility;

import logfileanalyzer.pojo.UserLogEntry;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class LogUtility {

    public static long numberUniqueUser(List<UserLogEntry> logEntries) {
        Long countOfUniqueUser = logEntries.stream()
                .map(x -> x.getUserName())
                .distinct()
                .collect(Collectors.counting());
        return countOfUniqueUser;
    }


    public static String maxActionUser(List<UserLogEntry> logEntries, String action) {
        return logEntries.stream()
                .filter(entry -> entry.getAction().equalsIgnoreCase(action)).collect(Collectors.groupingBy(
                        UserLogEntry::getUserName, Collectors.counting()
                ))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No user found");
    }


    public static String minActionUser(List<UserLogEntry> logEntries, String action) {
        return logEntries.stream()
                .filter(entry -> entry.getAction().equalsIgnoreCase(action)).collect(Collectors.groupingBy(
                        UserLogEntry::getUserName, Collectors.counting()
                ))
                .entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No user found");
    }


    public static Map<LocalDate, Map<String, Set<String>>> getDailyActionSummary(List<UserLogEntry> logEntries) {
        return logEntries.stream()
                .collect(Collectors.groupingBy(
                        entry -> entry.getLocalDateTime().toLocalDateTime().toLocalDate(),
                        Collectors.groupingBy(
                                UserLogEntry::getAction,
                                Collectors.mapping(
                                        UserLogEntry::getUserName,
                                        Collectors.toSet()
                                )
                        )
                ));
    }



}
