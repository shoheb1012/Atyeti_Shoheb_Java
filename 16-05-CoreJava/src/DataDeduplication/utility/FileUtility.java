package DataDeduplication.utility;

import DataDeduplication.java.Data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class FileUtility {


    public static List<Data> readCsvData(String filePath) throws IOException {
        String line = "";
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        ArrayList<Data> dataSet = new ArrayList<>();
        line = reader.readLine();
        while ((line = reader.readLine()) != null) {
            String[] split = line.split(",");
            Data data = new Data(Integer.parseInt(split[0]), split[1], split[2], Long.valueOf(split[3]));
            dataSet.add(data);
        }
        return dataSet;
    }


    public static List<Data> mergingTwoFile(List<Data> file1, List<Data> file2) {
        file1.addAll(file2);
        return file1;
    }

    public static void writeCleanedData(List<Data> uniqueData, String filePath) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        writer.write("ID,Name,Email,Phone\n");

        for (int i = 0; i < uniqueData.size(); i++) {
            writer.write(uniqueData.get(i).toString()+"\n");
        }
        writer.flush();
        writer.close();

        System.out.println("Clean Data Written Successfully");
    }

}
