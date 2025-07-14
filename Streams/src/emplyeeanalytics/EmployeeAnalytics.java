package emplyeeanalytics;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class EmployeeAnalytics {

    public static void main(String[] args) {

        String filepath = "C:\\Users\\ShohebPathan\\Atyeti_Shoheb_Java\\Streams\\src\\emplyeeanalytics\\EmplyeeData.txt";

        List<Employee> employees = FileUtility.loadEmployeeDataSet(filepath);

        //Count of Male & Female employees
        Map<String, Long> stringLongMap = EmployeeUtility.genderCount(employees);
        Set<Map.Entry<String, Long>> entries = stringLongMap.entrySet();
        for (Map.Entry<String, Long> entry : entries) {
            //   System.out.println(entry);
        }


        System.out.println("AllDepartments");
        Set<String> departments = EmployeeUtility.getAllDepartment(employees);
        for (String department : departments) {
            //  System.out.println(department);
        }

        System.out.println("AverageAgeByGender");
        Map<String, Double> averageAgeByGender = EmployeeUtility.averageAgeByGender(employees);
        Set<Map.Entry<String, Double>> entrySet = averageAgeByGender.entrySet();
        for (Map.Entry<String, Double> entry : entrySet) {
            System.out.println(entry);
        }

        System.out.println("HighestPaidEmployee");
        Optional<Employee> highestPaidEmployee = EmployeeUtility.getHighestPaidEmployee(employees);
        System.out.println(highestPaidEmployee.get());


        System.out.println("EmployeesJoinedAfter2015");
        List<Employee> employeesJoinedAfter2015 = EmployeeUtility.getEmployeesJoinedAfter2015(employees);
        for (Employee employee : employeesJoinedAfter2015) {
            System.out.println(employee);
        }

        System.out.println("EmployeeCountByDepartment");
        Map<String, Long> employeeCountByDepartment = EmployeeUtility.getEmployeeCountByDepartment(employees);
        Set<Map.Entry<String, Long>> entries1 = employeeCountByDepartment.entrySet();
        for (Map.Entry<String, Long> entry : entries1) {
            System.out.println(entry);
        }

        System.out.println("Average Salary By Department");
        Map<String, Double> averageSalaryByDepartment = EmployeeUtility.getAverageSalaryByDepartment(employees);
        Set<Map.Entry<String, Double>> entrySet1 = averageSalaryByDepartment.entrySet();
        for (Map.Entry<String, Double> entry : entrySet1) {
            System.out.println(entry);
        }

        System.out.println("Youngest Male In Development");
        Optional<Employee> youngestMaleInDevelopment = EmployeeUtility.getYoungestMaleInDevelopment(employees);
        System.out.println(youngestMaleInDevelopment.get());

        System.out.print("Most Experienced Employee");
        Optional<Employee> mostExperiencedEmployee = EmployeeUtility.getMostExperiencedEmployee(employees);
        Employee employee = mostExperiencedEmployee.get();
        System.out.println(employee);


        System.out.println("Gender Count In Sales");
        Map<String, Long> genderCountInSales = EmployeeUtility.getGenderCountInSales(employees);
        Set<Map.Entry<String, Long>> entries2 = genderCountInSales.entrySet();
        for (Map.Entry<String, Long> entry : entries2) {
            System.out.println(entry);
        }
        System.out.println("Average And Total Salary");
        System.out.println(EmployeeUtility.getAverageAndTotalSalary(employees));


        System.out.println("partition By Age");

        Map<Boolean, List<Employee>> booleanListMap = EmployeeUtility.partitionByAge(employees);

        Set<Map.Entry<Boolean, List<Employee>>> entries3 = booleanListMap.entrySet();

        for(Map.Entry<Boolean, List<Employee>>entry:entries3)
        {
            if(entry.getKey())
            {
                System.out.println("Under 25");
                System.out.println(entry.getValue());
            }
            else
            {
                System.out.println("above 25");
                System.out.println(entry.getValue());

             }
        }

        System.out.println("Oldest Employee");
        Optional<Employee> oldestEmployee = EmployeeUtility.getOldestEmployee(employees);
        System.out.println(oldestEmployee.get());

    }

}
