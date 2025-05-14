package BankApplication.interfaces;

public interface Bank {
    void deposit(int amount);

    void withdraw(int amount);

    void checkAvailableBalance(long accountNumber);

}
