import fileutitlity.LogFileReader;
import fileutitlity.ZipFileProcessor;
import net.lingala.zip4j.exception.ZipException;

import java.io.File;
import java.io.FileReader;
import java.util.zip.ZipFile;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ZipException {


        String directoryPath="resource";
        File directory = new File(directoryPath);

        File[] files = directory.listFiles();

        for(File file : files)
        {
           if(file.getName().endsWith(".log"))
           {
               LogFileReader.processLogFile(file);

           }
           else if (file.getName().endsWith(".zip")) {
               ZipFileProcessor.processZipFile(file);

           }
        }

        System.out.println(LogFileReader.getErrorCount()+" "+LogFileReader.getInfoCount()+" "+LogFileReader.getWarnCount());

    }
}