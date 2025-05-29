package fileutitlity;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;

import java.io.File;
import java.util.List;

public class ZipFileProcessor {

    public static String destinationPath = "resource";

    public static void processZipFile(File file) throws ZipException {

        ZipFile zipFile = new ZipFile(file);

        List<FileHeader> fileHeaders = zipFile.getFileHeaders();

        boolean anyExtracted = false;

        for (FileHeader header : fileHeaders) {

                                            //source//fileNameWithExtension
            File extractedFile = new File(destinationPath + File.separator + header.getFileName());
            String fileName = extractedFile.getName();

            if (!extractedFile.exists()) {  //if not exists then only extract it
                zipFile.extractFile(header, destinationPath);

                if (fileName.endsWith(".log")) {
                    LogFileReader.processLogFile(extractedFile);
                } else {
                    System.out.println("Invalid file: " + fileName + ". We are expecting only .log files to process.");
                }
                System.out.println("Extracted file: " + header.getFileName());
                anyExtracted = true;
            }
        }

        if (!anyExtracted) {
            System.out.println("All files already exist. No extraction needed for: " + file.getName());
        }

    }
}