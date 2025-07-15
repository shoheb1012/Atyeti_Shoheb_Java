package financial_transaction_file_validator;

public interface Config {

    String directory = "FileHandling/transactionfiles";
    String filenamePatternRegex ="^[A-Z0-9]{3,}_TXN_\\d{8}\\.csv$";
    String allowedDate = "20250714";
     String ERROR_LOG_PATH = "FileHandling/src/financial_transaction_file_validator/errorlog.txt";
}
