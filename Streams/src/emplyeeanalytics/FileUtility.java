package emplyeeanalytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtility {

    public static List<Employee> loadEmployeeDataSet(String filepath)
    {
       try(BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
           String line;
           reader.readLine();
           List<Employee> employees = new ArrayList<>();
           while ((line=reader.readLine())!=null)
           {
               String[] split = line.split(",");
               Employee employee = new Employee(Integer.parseInt(split[0]),split[1],Integer.parseInt(split[2]),split[3],split[4],Integer.parseInt(split[5]),Double.parseDouble(split[6]));
               employees.add(employee);
           }

           return employees;

       }
       catch (IOException e) {
           e.printStackTrace();

       }
      return null;
    }
}
