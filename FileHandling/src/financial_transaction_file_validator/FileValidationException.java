package financial_transaction_file_validator;

public class FileValidationException extends RuntimeException{

    public FileValidationException(String msg)
    {
        super(msg);
    }

}
