package service;

import model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeeService {

    //Build a Map<ManagerName, List<Employee>> using managerId and employee name.
    public static Map<String, List<Employee>> groupingByManagerName(List<Employee> employees) {

        Map<String, String> idToNameMap = employees.stream()
                .collect(Collectors.toMap(Employee::getEmployeeId, Employee::getEmployeeName));


        return employees.stream()
                .filter(e -> e.getManagerId() != null)
                .collect(Collectors.groupingBy(
                        e -> idToNameMap.get(e.getManagerId()), // managerName lookup
                        Collectors.mapping(Function.identity(), Collectors.toList())
                ));
    }

    //Find the average salary of each manager’s team.

    public static Map<String, Double> averageSalaryManagerTeam(List<Employee> employees) {
        Map<String, String> idToNameMap = employees.stream()
                .collect(Collectors.toMap(Employee::getEmployeeId, Employee::getEmployeeName));

        return employees.stream()
                .filter(x -> x.getManagerId() != null)
                .collect(Collectors.groupingBy(
                        x -> idToNameMap.get(x.getManagerId()),
                        Collectors.averagingDouble(Employee::getSalary)
                ));
    }


    //Detect cyclic manager references (an employee managing their own manager directly or indirectly).

    public static List<Employee> cyclicManager(List<Employee> employees) {

        List<Employee> collect1 = employees.stream().filter(x->x.getManagerId()==null).peek(x -> x.setManagerId(x.getEmployeeId())).collect(Collectors.toList());
        return collect1.stream().filter(x -> x.getManagerId().equals(x.getEmployeeId())).collect(Collectors.toList());


    }


}