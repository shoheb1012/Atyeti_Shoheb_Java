package config;

public interface Config {

    String directory = "FileHandling/com.Atyeti.filevalidator/Transactionfiles";
    String ACCEPTED_DIR = "FileHandling/com.Atyeti.filevalidator/Accepted";
    String REJECTED_DIR = "FileHandling/com.Atyeti.filevalidator/Rejected";
    String filenamePatternRegex = "^[A-Z0-9]{3,}_TXN_\\d{8}\\.csv$";
    String allowedDate = "20250715";
    String ERROR_LOG_PATH = "FileHandling/com.Atyeti.filevalidator/Rejected/errorlog.txt";
    String expectedHeader = "TXN_ID,ACCOUNT_NO,TXN_DATE,AMOUNT,CURRENCY,STATUS";
}
