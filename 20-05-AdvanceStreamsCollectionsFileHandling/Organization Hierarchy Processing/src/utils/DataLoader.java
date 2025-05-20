package utils;

import model.Employee;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataLoader {

    public static List<Employee> employeeDataLoading (String filePath) throws IOException,FileNotFoundException {
        List<Employee>employees = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        reader.readLine();
        while ((line=reader.readLine())!=null)
        {
            String[] split = line.split(",");
            String employeeId = split[0];
            String employeeName = split[1];
            String managerId = split[2];
            if(managerId.isEmpty())
            {
                managerId=null;
            }
            String department = split[3];
            double salary = Double.parseDouble(split[4]);

            Employee employee = new Employee(employeeId,employeeName,managerId,department,salary);
            employees.add(employee);
        }

        return employees;
    }
}
