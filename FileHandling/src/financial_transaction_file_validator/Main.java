package financial_transaction_file_validator;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        File logDirectory = new File("C:\\Users\\ShohebPathan\\Atyeti_Shoheb_Java\\FileHandling\\transactionfiles");

        File[] files = logDirectory.listFiles();
       // System.out.println(files.length);

        for(File file : files)
        {
            FileValidationProcessor.process(file);
           // System.out.println(file.getName());
        }
    }
}
