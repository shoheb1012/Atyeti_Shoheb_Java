package util;

import config.Config;
import exception.FileValidationException;
import model.CurrencyType;
import model.Status;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class ValidationUtils {

    private String date;

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

    public static boolean fieldLevelValidation(String line, String fileName) {
        String[] split = line.split(",");


        String TXN_ID = split[0];
        String ACCOUNT_NO = split[1];
        LocalDate TXN_DATE = LocalDate.parse(split[2], DateTimeFormatter.ofPattern("yyyy-MM-dd"));


        double AMOUNT = Double.parseDouble(split[3]);
        String CURRENCY = split[4];
        String STATUS = split[5];

        //txn_id validation
        Set<String> stringSet = new HashSet<>();
        Pattern txnPattern = Pattern.compile("^[A-Za-z]{3}[0-9]+$");

        if (!txnPattern.matcher(TXN_ID).matches()) {
            throw new FileValidationException("Invalid TXN_ID format: " + TXN_ID + " in file " + fileName);
        }
        if (!stringSet.add(TXN_ID)) {
            throw new FileValidationException("Duplicate TXN_ID found: " + TXN_ID + " in file " + fileName);
        }

        //ACCOUNT number validation
        if (!ACCOUNT_NO.matches("\\d{10}")) {
            throw new FileValidationException("Account should be 10-digit numeric: " + ACCOUNT_NO + " in file " + fileName);
        }

        //Amount validation
        if (!(AMOUNT >= 0)) {
            throw new FileValidationException("Amount should be positive decimal number in file " + fileName);
        }

        //Date Validation
        String dateInFile = fileName.substring(fileName.lastIndexOf("_") + 1, fileName.indexOf(".csv"));
        String formattedTxnDate = TXN_DATE.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        if (!formattedTxnDate.equals(dateInFile)) {
            throw new FileValidationException("Invalid TXN_DATE: " + formattedTxnDate + " does not match file date: " + dateInFile + " in file " + fileName);
        }

        //Currency validation
        try {
            CurrencyType.valueOf(CURRENCY.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new FileValidationException("Invalid currency: " + CURRENCY + " in file " + fileName);
        }

        //Status validation
        try {
            Status.valueOf(STATUS.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new FileValidationException("Invalid Status: " + STATUS + " in file " + fileName);
        }


        return true;
    }

    public static void moveToDirectory(File file, String directoryPath) throws IOException{

            Path targetDir = Paths.get(directoryPath);
            Files.createDirectories(targetDir);
            Files.move(file.toPath(), targetDir.resolve(file.getName()), StandardCopyOption.REPLACE_EXISTING);

    }


}
