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
            logger.info(" FileName is valid for file: " + fileName);

            if (!ValidationUtils.isDateValidFromFileName(fileName)) {
                throw new FileValidationException("File Date is invalid");
            }
            logger.info("File Date is valid for file: " + fileName);
            logger.info("Reading a file :"+fileName);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            String header = reader.readLine();
            if(!ValidationUtils.isFileHeaderValid(header))
            {
               throw new FileValidationException("Header is mismatch");
            }
            logger.info("file header is valid for file "+fileName);
            while ((line=reader.readLine())!=null)
            {
                if(!ValidationUtils.isValidRow(line))
                {
                    throw new FileValidationException("Row invalid");
                }
            }

        } catch (FileValidationException e) {
            logger.warning(" Validation failed for file: " + fileName + " - " + e.getMessage());
            ErrorWriter.writeErrorToFile(fileName, e.getMessage());
        } catch (IOException e) {
            ErrorWriter.writeErrorToFile(fileName,e.getMessage());
        }
    }
}
