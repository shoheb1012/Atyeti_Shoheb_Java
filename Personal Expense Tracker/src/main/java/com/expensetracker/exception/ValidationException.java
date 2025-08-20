package main.java.com.expensetracker.exception;

public class ValidationException extends RuntimeException{
    public ValidationException(String msg)
    {
        super(msg);
    }
}
