package BankApplication.users;

import java.util.Scanner;

public class Customer {
    Scanner sc = new Scanner(System.in);
    private String CustomerName;
    private String CustomerEmail;
    private long phoneNumber;

    public Customer(String customerName, String customerEmail, long phoneNumber) {
        CustomerName = customerName;
        CustomerEmail = customerEmail;
        this.phoneNumber = phoneNumber;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getCustomerEmail() {
        return CustomerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        CustomerEmail = customerEmail;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public void UpdateCustomer(long phoneNumber) {
        setPhoneNumber(phoneNumber);
    }

    public void UpdateCustomer(String Email) {
        setCustomerEmail(Email);
    }

    public void UpdateCustomer(long phoneNumber, String Email) {
        setPhoneNumber(phoneNumber);
        setCustomerEmail(Email);
    }

    public void UpdateDetails() {
        System.out.println("Hii " + getCustomerName() + " Welcome to Profile Update Section ");
        System.out.println("Please Enter Options For UpdateDetails :\n1)For Update PhoneNumber\n2)for update Email\n3)for Update Both PhoneNUmber And Email-Id");
        int Choice = sc.nextInt();
        if (Choice == 1) {
            System.out.println("Hii " + getCustomerName() + " Your Old Number is " + getPhoneNumber() + "\nEnter the New Phone Number");
            long NewPhno = sc.nextLong();
            UpdateCustomer(NewPhno);
            System.out.println("Your Phone Number is Updated...! ");

        } else if (Choice == 2) {
            System.out.println("Hii " + getCustomerName() + " Your Old Email is " + getCustomerEmail() + "\nEnter the New Email Adress");
            String NewMail = sc.nextLine();
            UpdateCustomer(NewMail);
            System.out.println("Your Email is Updated...! ");
        } else if (Choice == 3) {
            System.out.println("Hii " + getCustomerName() + " Your Old Number is " + getPhoneNumber() + "\nEnter the New Phone Number");
            long NewPhno = sc.nextLong();


            System.out.println("Hii " + getCustomerName() + " Your Old Email is " + getCustomerEmail() + "\nEnter the New Email Adress");
            String NewMail = sc.nextLine();
            NewMail = sc.nextLine();
            UpdateCustomer(NewPhno, NewMail);
            System.out.println("Your Phone Number and Email is Updated...! ");
        }
    }

    @Override
    public String toString() {
        return "Customer{" + "CustomerName='" + CustomerName + '\'' + ", CustomerEmail='" + CustomerEmail + '\'' + ", phoneNumber=" + phoneNumber + '}';
    }
}
