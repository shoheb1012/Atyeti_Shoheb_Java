package financial_transaction_file_validator;

import java.io.File;
import java.nio.file.Path;
import java.util.logging.Logger;

public class FileValidationProcessor {

   static Logger logger = Logger.getLogger(FileValidationProcessor.class.getName());

    public static void process(File file) {

       String fileName = file.getName();
       if(ValidationUtils.fileHeaderValidator(fileName))
       {
           logger.info("Header valid "+fileName);
           if(ValidationUtils.isDateValidFromFileName(fileName))
           {
               logger.info("Date valid "+fileName);
           }
           else
           {
               logger.warning("Date Invalid "+fileName);
           }
       }
       else {
           logger.warning("Header not valid"+fileName);
       }

    }
}
