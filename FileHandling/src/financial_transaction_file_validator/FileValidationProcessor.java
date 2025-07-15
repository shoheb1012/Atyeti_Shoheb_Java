package financial_transaction_file_validator;

import java.io.File;
import java.util.logging.Logger;


public class FileValidationProcessor {

    static Logger logger = Logger.getLogger(FileValidationProcessor.class.getName());

    public static void process(File file) {
        String fileName = file.getName();
        logger.info("Starting validation for file: " + fileName);

        try {
            if (!ValidationUtils.filenameValidator(fileName)) {
                throw new FileValidationException("FileName is not valid");
            }
            logger.info(" FileName is valid for file: " + fileName);

            if (!ValidationUtils.isDateValidFromFileName(fileName)) {
                throw new FileValidationException("File Date is invalid");
            }
            logger.info("File Date is valid for file: " + fileName);

        } catch (FileValidationException e) {
            logger.warning(" Validation failed for file: " + fileName + " - " + e.getMessage());
            ErrorWriter.writeErrorToFile(fileName, e.getMessage());
        }
    }
}
