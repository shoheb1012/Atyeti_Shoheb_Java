package DataDeduplication.utility;

import DataDeduplication.java.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DataDuplicatorUtility {

   public static List<Data> removeDuplicateDataSet(List<Data> mergedDataSet)
   {
       HashSet<Object> seen = new HashSet<>();
       mergedDataSet.removeIf(e -> !seen.add(e.getEmail()) || !seen.add(e.getPhoneNumber()));
       return mergedDataSet;
   }
}
