

import employee_management_system.filehandling.EmployeeData;
import employee_management_system.model.Employee;
import employee_management_system.utility.EmployeeService;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {

      String filePath="C:\\Users\\ShohebPathan\\tyeti_Shoheb_Java\\19-05-StreamsCollections\\src\\employee_management_system\\resources\\employee_data_with_duplicates.txt";
       //String filePath = "employee_data_with_duplicates.txt";

        List<Employee> employees = EmployeeData.readEmployeeData(filePath);

        //Find all employees in a specific department.
        List<Employee> hrDepartment = EmployeeService.findByDepartment(employees, "HR");


        for (Employee employee : hrDepartment) {
            System.out.println(employee);
        }
        System.out.println("==========================================");
        //Sort employees by salary in descending order.
        List<Employee> sortBySalaryDesc = EmployeeService.sortBySalaryDesc(employees);
        System.out.println("Employee Salary sorted in descending order");
        for (Employee employee : sortBySalaryDesc) {
            System.out.println(employee);
        }
        System.out.println("====================================================\nDuplicate Removed");

        List<Employee> removedDuplicate = EmployeeService.removeDuplicate(employees);
        for (Employee employee : removedDuplicate) {
            System.out.println(employee);
        }

        System.out.println("====================================================\nGrouped By Department");
        Map<String, List<Employee>> employeeByDepartment = EmployeeService.allEmployeeByDepartment(employees);
        Set<Map.Entry<String, List<Employee>>> entries = employeeByDepartment.entrySet();
        for (Map.Entry<String, List<Employee>> entry : entries) {
            System.out.println("Department: " + entry.getKey() + " Employees :" + entry.getValue());

        }
    }
}
