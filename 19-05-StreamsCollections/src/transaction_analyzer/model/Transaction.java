package src.transaction_analyzer.model;

import java.sql.Timestamp;
import java.util.Objects;

public class Transaction {

    private String userId;
    private double transactionAmount;
    private Timestamp timestamp;

    public Transaction(String userId, double transactionAmount, Timestamp timestamp) {
        this.userId = userId;
        this.transactionAmount = transactionAmount;
        this.timestamp = timestamp;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "userId=" + userId +
                ", transactionAmount=" + transactionAmount +
                ", timestamp=" + timestamp +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Double.compare(transactionAmount, that.transactionAmount) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(transactionAmount);
    }
}
