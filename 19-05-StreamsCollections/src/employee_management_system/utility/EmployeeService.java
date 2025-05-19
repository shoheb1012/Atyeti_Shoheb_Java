package employee_management_system.utility;

import employee_management_system.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeService {

    public static Map<String,List<Employee>> allEmployeeByDepartment(List<Employee>employeeList)
    {
       return employeeList.stream().collect(Collectors.groupingBy(
                x-> x.getDepartment()
        ));
    }


    public static  List<Employee> sortBySalaryDesc(List<Employee> employees)
    {
        return employees.stream().sorted((x,y)-> (int)(y.getSalary()-x.getSalary()))
                .collect(Collectors.toList());
    }


    public static List<Employee> removeDuplicate(List<Employee>employees) {
        return employees.stream().distinct().collect(Collectors.toList());
    }

    public static List<Employee>findByDepartment(List<Employee> employees,String department)
    {
        System.out.println("===="+department+" Department===");
         return employees.stream().filter(x->x.getDepartment().equalsIgnoreCase(department)).collect(Collectors.toList());
    }


}
