package BankApplication.transctions;

import BankApplication.exceptions.UserDefinedException;
import BankApplication.interfaces.Bank;
import BankApplication.users.Customer;

import java.util.Scanner;

public class Operation {

    Scanner sc = new Scanner(System.in);
    Customer customer;

    public void transaction(Bank bank) {
        while (true) {
            System.out.println("Hi   Welcome to the Bank transaction section");
            System.out.println("1 for Withdraw\n2 for Deposit\n3 for Check Balance \n4 for Exit");
            int choice = sc.nextInt();
            try {
                switch (choice) {
                    case 1:
                        System.out.println("Please enter the Amount for Withdrawn");
                        int amount = sc.nextInt();
                        bank.withdraw(amount);
                        break;

                    case 2:
                        System.out.println("Please enter the Amount for Deposit");
                        int depAmount = sc.nextInt();
                        bank.deposit(depAmount);
                        break;

                    case 3:
                        System.out.println("Enter your Account Number :");
                        long accNumber = sc.nextLong();
                        bank.checkAvailableBalance(accNumber);
                        break;
                    case 4:
                        System.out.println("Thank You !! Exiting the Tracnscation...!");
                        System.exit(0);
                        break;
                    default:
                        throw new UserDefinedException("Sorry Invalid Option..");
                }
            } catch (UserDefinedException dr) {
                System.out.println(dr.getMessage());
            }
        }
    }
}
