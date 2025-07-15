package util;

import config.Config;
import exception.FileValidationException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class ValidationUtils {

    public static boolean filenameValidator(String fileName) {

        return Pattern.matches(Config.filenamePatternRegex, fileName);
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


    public static boolean isFileHeaderValid(String header) {
        if (header.split(",").length != 6) {
            throw new FileValidationException("Header column count mismatch. Expected 6 columns.");
        }
        if (header.isEmpty() || header.isBlank()) {
            throw new FileValidationException("Header is missing or empty.");
        }
        return header != null && header.trim().equalsIgnoreCase(Config.expectedHeader);
    }


    public static boolean isValidRow(String row) {
        if (row == null || row.trim().isEmpty()) return false;

        String[] fields = row.split(",");
        if (fields.length != 6) return false;

        for (String field : fields) {
            if (field.trim().isEmpty()) return false;
        }

        return true;
    }


}
