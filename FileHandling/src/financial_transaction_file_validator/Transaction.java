package financial_transaction_file_validator;

import java.time.LocalDate;

public class Transaction {
    private String TXN_ID;
    private long ACCOUNT_NO;
    private LocalDate TXN_DATE;
    private double AMOUNT;
    private String CURRENCY;
    private String STATUS;

    public Transaction(String TXN_ID, long ACCOUNT_NO, LocalDate TXN_DATE, double AMOUNT, String CURRENCY, String STATUS) {
        this.TXN_ID = TXN_ID;
        this.ACCOUNT_NO = ACCOUNT_NO;
        this.TXN_DATE = TXN_DATE;
        this.AMOUNT = AMOUNT;
        this.CURRENCY = CURRENCY;
        this.STATUS = STATUS;
    }

    public String getTXN_ID() {
        return TXN_ID;
    }

    public void setTXN_ID(String TXN_ID) {
        this.TXN_ID = TXN_ID;
    }

    public long getACCOUNT_NO() {
        return ACCOUNT_NO;
    }

    public void setACCOUNT_NO(long ACCOUNT_NO) {
        this.ACCOUNT_NO = ACCOUNT_NO;
    }

    public LocalDate getTXN_DATE() {
        return TXN_DATE;
    }

    public void setTXN_DATE(LocalDate TXN_DATE) {
        this.TXN_DATE = TXN_DATE;
    }

    public double getAMOUNT() {
        return AMOUNT;
    }

    public void setAMOUNT(double AMOUNT) {
        this.AMOUNT = AMOUNT;
    }

    public String getCURRENCY() {
        return CURRENCY;
    }

    public void setCURRENCY(String CURRENCY) {
        this.CURRENCY = CURRENCY;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "TXN_ID='" + TXN_ID + '\'' +
                ", ACCOUNT_NO=" + ACCOUNT_NO +
                ", TXN_DATE=" + TXN_DATE +
                ", AMOUNT=" + AMOUNT +
                ", CURRENCY='" + CURRENCY + '\'' +
                ", STATUS='" + STATUS + '\'' +
                '}';
    }
}
