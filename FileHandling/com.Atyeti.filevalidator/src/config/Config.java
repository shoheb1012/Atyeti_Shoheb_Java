package config;

public interface Config {

    String directory = "FileHandling/transactionfiles";
    String filenamePatternRegex = "^[A-Z0-9]{3,}_TXN_\\d{8}\\.csv$";
    String allowedDate = "20250715";
    String ERROR_LOG_PATH = "C:\\Users\\ShohebPathan\\Atyeti_Shoheb_Java\\FileHandling\\com.Atyeti.filevalidator\\src\\resources\\errorlog.txt";
    String expectedHeader = "TXN_ID,ACCOUNT_NO,TXN_DATE,AMOUNT,CURRENCY,STATUS";
}
