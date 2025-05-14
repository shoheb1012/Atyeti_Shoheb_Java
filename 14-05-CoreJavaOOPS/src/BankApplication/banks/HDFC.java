package BankApplication.banks;

import BankApplication.exceptions.UserDefinedException;
import BankApplication.interfaces.Bank;
import BankApplication.users.Customer;

import java.util.Scanner;

 public class HDFC implements Bank {

        private  String IFSCCode;
        private long AccountNumber;
        private Double availableBalance;
        private Customer customer;//Has-A realtion
        Scanner sc = new Scanner(System.in);
        public HDFC(String IFSCCode, long accountNumber, Double availableBalance, Customer customer) {
            this.IFSCCode = IFSCCode;
            this.AccountNumber = accountNumber;
            this.availableBalance = availableBalance;
            this.customer = customer;


        }

        @Override
        public  void withdraw(int amount) {
            if(getAvailableBalance()<amount)
            {

                throw new UserDefinedException("Insufficient Balance !!");
            }
            else
            {

                setAvailableBalance(availableBalance-amount);
                Double BalanceAfterWithdraw= getAvailableBalance();
                System.out.println(amount +" Withdraw Successfully Thank You..!");
                checkAvailableBalance(getAccountNumber());
            }

        }

        @Override
        public void deposit(int amount)
        {
            setAvailableBalance(availableBalance +amount);
            Double BalanceAafterWithdraw= getAvailableBalance();
            System.out.println(amount +" Deposite Successfully Thank You..!");
            checkAvailableBalance(getAccountNumber());
        }

        @Override
        public void checkAvailableBalance(long AccountNumber)
        {
            if(AccountNumber==getAccountNumber()) {
                System.out.println("Available Balance in Your Account (AccountNumber: " + getAccountNumber() + ") is rs." + getAvailableBalance());
            }
            else
            {
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

            return AccountNumber;
        }

        public void setAccountNumber(long accountNumber) {
            AccountNumber = accountNumber;
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
        return "HDFC{" +
                "customer=" + customer +
                ", IFSCCode='" + IFSCCode + '\'' +
                ", AccountNumber=" + AccountNumber +
                ", AvaliableBalance=" + availableBalance +
                '}';
    }
}


