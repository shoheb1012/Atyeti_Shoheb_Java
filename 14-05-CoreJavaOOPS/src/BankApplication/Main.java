package BankApplication;

import BankApplication.transctions.Operation;
import BankApplication.banks.HDFC;
import BankApplication.banks.SBI;
import BankApplication.users.Customer;

public class Main {
    public static void main(String[] args) {

        Customer customer1 = new Customer("Shoheb", "pshoheb333@gmail.com", 9145674121L);
        System.out.println(customer1);
        customer1.UpdateDetails();
        System.out.println(customer1);

        Operation op = new Operation();


        SBI sbi = new SBI("SBIN0005909", 33582050888L, 2000.0, customer1);
        System.out.println(sbi);
        op.transaction(sbi);
        System.out.println("================================================================================");

        HDFC hdfc = new HDFC("HDFC129IN", 4546455276L, 4000.0, customer1);
        System.out.println(hdfc);
        op.transaction(hdfc);


    }
}
