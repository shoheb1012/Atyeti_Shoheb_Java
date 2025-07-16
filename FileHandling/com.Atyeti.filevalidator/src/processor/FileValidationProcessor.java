package processor;

import exception.FileValidationException;
import io.ErrorWriter;
import util.ValidationUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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


            if (!ValidationUtils.isDateValidFromFileName(fileName)) {
                throw new FileValidationException("File Date is invalid");
            }


            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            String header = reader.readLine();
            if (!ValidationUtils.isFileHeaderValid(header)) {
                throw new FileValidationException("Header is mismatch");
            }

            while ((line = reader.readLine()) != null) {
                if (!ValidationUtils.isValidRow(line)) {
                    throw new FileValidationException("Row invalid");
                }

                ValidationUtils.fieldLevelValidation(line, fileName);

            }

        } catch (FileValidationException e) {
            logger.warning(" Validation failed for file: " + fileName + " - " + e.getMessage());
            ErrorWriter.writeErrorToFile(fileName, e.getMessage());
        } catch (IOException e) {
            ErrorWriter.writeErrorToFile(fileName, e.getMessage());
        }
    }
}
