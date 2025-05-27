package src.transaction_analyzer.main;




import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\ShohebPathan\\tyeti_Shoheb_Java\\19-05-StreamsCollections\\src\\transaction_analyzer\\resources\\transactions.csv";
        List<Transaction> transactionList = TransactionData.readingTransactionData(filePath);


        Map<String, Double> stringDoubleMap = TransactionService.totalTransactionPerUser(transactionList);
        Set<Map.Entry<String, Double>> entries = stringDoubleMap.entrySet();
        System.out.println("UserName::Total Transaction");
        for (Map.Entry<String, Double> entry : entries) {
            System.out.println(entry);

        }


        List<Transaction> transactionList1= TransactionService.TransactionBelowThreshold(transactionList, 100);

        for(Transaction transaction:transactionList1)
        {
            System.out.println(transaction);
        }


        System.out.println("Top Three Highest Transaction");
        List<Transaction> topThreeHighestTransaction= TransactionService.topThreeHighestTransaction(transactionList);

        for(Transaction transaction:topThreeHighestTransaction)
        {
            System.out.println(transaction);
        }


    }
}
