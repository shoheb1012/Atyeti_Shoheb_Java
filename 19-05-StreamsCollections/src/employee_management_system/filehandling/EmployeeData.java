package filehandling;



import model.Employee;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeData {

    public static List<Employee> readEmployeeData(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        ArrayList<Employee> employees = new ArrayList<>();
        String line="";

        line= reader.readLine();
        while ((line=reader.readLine())!=null)
        {
            String[] split = line.split(",");
            Employee employee = new Employee(Integer.parseInt(split[0]),split[1],split[2],Double.parseDouble(split[3]));
            employees.add(employee);
        }

        return employees;

    }
}
