package main.java.com.expensetracker.model;



public enum PaymentMethod {
    CASH("Cash"),
    CREDIT_CARD("Credit Card"),
    DEBIT_CARD("Debit Card"),
    UPI("UPI"),
    NET_BANKING("Net Banking"),
    WALLET("Digital Wallet"),
    CHECK("Check"),
    OTHER("Other");

    private final String displayName;


    PaymentMethod(String displayName) {
        this.displayName = displayName;

    }

    public String getDisplayName() { return displayName; }

}