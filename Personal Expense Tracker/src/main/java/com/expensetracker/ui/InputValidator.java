package main.java.com.expensetracker.ui;

import main.java.com.expensetracker.exception.ValidationException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class InputValidator {

    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public int getValidChoice(int i, int i1) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the choice between "+i+" to"+i1);
        int choice = sc.nextInt();
        if(choice>=i && choice<=i1)
        {
            return choice;
        }
        throw new ValidationException("Invalid choice");

    }
    public LocalDate getValidDate(String dateInput) throws ValidationException {
        try {
            LocalDate date = LocalDate.parse(dateInput, dateFormatter);

            // Check if date is not in the future
            if (date.isAfter(LocalDate.now())) {
                throw new ValidationException("Date cannot be in the future");
            }

            return date;
        } catch (DateTimeParseException e) {
            throw new ValidationException("Invalid date format. Please use yyyy-MM-dd format");
        }
    }
}
