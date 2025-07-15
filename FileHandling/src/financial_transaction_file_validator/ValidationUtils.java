package financial_transaction_file_validator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class ValidationUtils {

    public static boolean fileHeaderValidator(String fileName) {

        return Pattern.matches("^[A-Z0-9]{3,}_TXN_\\d{8}\\.csv$",fileName);
    }

    public static boolean isDateValidFromFileName(String fileName) {

        try {
            String dateInFile = fileName.substring(fileName.lastIndexOf("_") + 1, fileName.indexOf(".csv"));
            String today = new SimpleDateFormat("yyyyMMdd").format(new Date());
            String allowedDate = "20250714"; // can be moved to config
            return dateInFile.equals(today) || dateInFile.equals(allowedDate);
        } catch (Exception e) {
            return false;
        }
    }

}
