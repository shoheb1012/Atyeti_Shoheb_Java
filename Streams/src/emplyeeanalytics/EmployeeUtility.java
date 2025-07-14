package emplyeeanalytics;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeUtility {


    public static Map<String,Long> genderCount(List<Employee>employees)
    {
        return employees.stream().collect(Collectors.groupingBy(Employee::gender,Collectors.counting()));
    }

    public static Set<String> getAllDepartment(List<Employee>employees)
    {
      return employees.stream().map(x->x.department()).collect(Collectors.toSet());
    }

    public static Map<String,Double> averageAgeByGender(List<Employee>employees)
    {
        return employees.stream().collect(Collectors.groupingBy(Employee::gender,Collectors.averagingInt(Employee::age)));
    }

    public static Optional<Employee> getHighestPaidEmployee(List<Employee> employees)
    {
        Optional<Employee> collect = employees.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::salary)));
        return collect;
    }

    public static List<Employee> getEmployeesJoinedAfter2015(List<Employee> employees)
    {
        return employees.stream().filter(x->x.joiningYear()>2015).collect(Collectors.toList());
    }

    public static Map<String, Long> getEmployeeCountByDepartment(List<Employee> employees)
    {
        return employees.stream().collect(Collectors.groupingBy(Employee::department,Collectors.counting()));
    }

    public static Map<String, Double> getAverageSalaryByDepartment(List<Employee> employees)
    {
        return employees.stream().collect(Collectors.groupingBy(Employee::department,Collectors.averagingDouble(Employee::salary)));
    }


    public static Optional<Employee> getYoungestMaleInDevelopment(List<Employee> employees)
    {
        return employees.stream().filter(x -> x.gender().equals("Male") && x.department().equalsIgnoreCase("Development")).min(Comparator.comparing(Employee::age));

    }

    public static Optional<Employee> getMostExperiencedEmployee(List<Employee> employees)
    {
        return employees.stream().min(Comparator.comparing(Employee::joiningYear));
    }

    public static Map<String, Long> getGenderCountInSales(List<Employee> employees)
    {
        return employees.stream().filter(x->x.department().equalsIgnoreCase("Sales")).collect(Collectors.groupingBy(Employee::gender,Collectors.counting()));
    }

    public static Map<String, Double> getAverageAndTotalSalary(List<Employee> employees) {
      return employees.stream()
                .collect(Collectors.teeing(
                        Collectors.summingDouble(Employee::salary),
                        Collectors.averagingDouble(Employee::salary),
                        (total, average) -> {
                            Map<String, Double> map = new HashMap<>();
                            map.put("TotalSalary", total);
                            map.put("AverageSalary", average);
                          return map;
                        }
                ));


    }

    public static Map<Boolean, List<Employee>> partitionByAge(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.partitioningBy(emp -> emp.age() <= 25));
    }

    public static Optional<Employee> getOldestEmployee(List<Employee> employees)
    {
        return employees.stream().max(Comparator.comparing(Employee::age));
    }



}
