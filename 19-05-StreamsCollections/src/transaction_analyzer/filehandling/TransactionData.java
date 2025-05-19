package src.transaction_analyzer.filehandling;

import src.transaction_analyzer.model.Transaction;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class TransactionData {

    public static List<Transaction> readingTransactionData(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        List<Transaction> transactionList = new ArrayList<>();
        String line="";
        reader.readLine();
        while ((line=reader.readLine())!=null)
        {
            String[] split = line.split(",");
            Transaction transaction = new Transaction(split[0],Double.parseDouble(split[1]), Timestamp.valueOf(split[2]));
            transactionList.add(transaction);
        }

        return transactionList;
    }
}
