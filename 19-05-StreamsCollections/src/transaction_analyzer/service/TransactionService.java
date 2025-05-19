package src.transaction_analyzer.service;

import src.transaction_analyzer.model.Transaction;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransactionService {

    public static Map<String, Double> totalTransactionPerUser(List<Transaction> transactionList) {
        return transactionList.stream()
                .collect(Collectors.groupingBy(
                        Transaction::getUserId,
                        Collectors.summingDouble(Transaction::getTransactionAmount)
                ));
    }

    public static List<Transaction> TransactionBelowThreshold(List<Transaction> transactionList, double threshold) {
        System.out.println("Transaction Below " + threshold);
        return transactionList.stream().filter(x -> x.getTransactionAmount() < threshold).collect(Collectors.toList());
    }

    public static List<Transaction> topThreeHighestTransaction(List<Transaction> transactions) {
        return transactions.stream()
                .sorted(Comparator.comparing(Transaction::getTransactionAmount).reversed())
                .distinct()
                .limit(3)
                .collect(Collectors.toList());

    }

}
