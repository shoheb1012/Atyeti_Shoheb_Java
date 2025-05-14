package BankApplication.banks;

import BankApplication.exceptions.UserDefinedException;
import BankApplication.interfaces.Bank;
import BankApplication.users.Customer;

import java.util.Scanner;

public class SBI implements Bank {
    private String IFSCCode;
    private long accountNumber;
    private Double availableBalance;
    private Customer customer;
    Scanner sc = new Scanner(System.in);

    public SBI(String IFSCCode, long accountNumber, Double availableBalance, Customer customer) {
        this.IFSCCode = IFSCCode;
        this.accountNumber = accountNumber;
        this.availableBalance = availableBalance;
        this.customer = customer;
    }


    @Override
    public void withdraw(int amount) {

        if (getAvailableBalance() < amount) {
            throw new UserDefinedException("Oops... Insufficient Balance !!");
        } else {

            setAvailableBalance(availableBalance - amount);
            Double balanceAafterWithdraw = getAvailableBalance();
            System.out.println(amount + " Withdraw Successfully Thank You..!");
            checkAvailableBalance(getAccountNumber());
        }

    }

    @Override
    public void deposit(int amount) {
        setAvailableBalance(availableBalance + amount);
        Double balanceAafterWithdraw = getAvailableBalance();
        System.out.println(amount + " Deposit Successfully Thank You..!");
        checkAvailableBalance(getAccountNumber());
    }

    @Override
    public void checkAvailableBalance(long accountNumber) {

        if (accountNumber == getAccountNumber()) {
            System.out.println("Available Balance in Your Account (AccountNumber: " + getAccountNumber() + ") is rs." + getAvailableBalance());
        } else {
            throw new UserDefinedException("Account Number incorrect Try Again");
        }


    }


    public String getIFSCCode() {
        return IFSCCode;
    }

    public void setIFSCCode(String IFSCCode) {
        this.IFSCCode = IFSCCode;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(Double availableBalance) {
        this.availableBalance = availableBalance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "SBI{" +
                "customer=" + customer +
                ", AccountNumber=" + accountNumber +
                ", IFSCCode='" + IFSCCode + '\'' +
                ", AvaliableBalance=" + availableBalance +
                '}';
    }
}
