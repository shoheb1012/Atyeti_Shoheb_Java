package financial_transaction_file_validator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class ValidationUtils {

    public static boolean filenameValidator(String fileName) {

        return Pattern.matches(Config.filenamePatternRegex,fileName);
    }

    public static boolean isDateValidFromFileName(String fileName) {

        try {
            String dateInFile = fileName.substring(fileName.lastIndexOf("_") + 1, fileName.indexOf(".csv"));
            String today = new SimpleDateFormat("yyyyMMdd").format(new Date());
            return dateInFile.equals(today) || dateInFile.equals(Config.allowedDate);
        } catch (Exception e) {
            return false;
        }
    }

}
