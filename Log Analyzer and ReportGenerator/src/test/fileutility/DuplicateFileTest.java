package test.fileutility;

import appconfig.FileConfig;
import file_utility.DuplicateFile;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;

class DuplicateFileTest {

    @Test
    public void shouldCopyContentsToDuplicateFile() throws IOException {

        File sourceLogFile = new File("src/duplicate_file/sourceFileToCopyContent");

        BufferedWriter writer = new BufferedWriter(new FileWriter(sourceLogFile,true));
        writer.write("INFO: Test line 1\nWARNING: Test line 2\nERROR: Test line 3");
        writer.close();


        DuplicateFile.writeDataToDuplicateFile(sourceLogFile);

        File file = new File(FileConfig.DUPLICATE_LOG_FILE);
        String copiedContent = Files.readString(file.toPath());
        assertTrue(copiedContent.contains("INFO: Test line 1"));
        assertTrue(copiedContent.contains("WARNING: Test line 2"));
        assertTrue(copiedContent.contains("ERROR: Test line 3"));
    }

    @Test
    public void shouldHandleNonExistingSourceFile() {

        File sourceFile = new File("non_existing.log");

        // Act (no exception should be thrown)
        assertDoesNotThrow(() -> DuplicateFile.writeDataToDuplicateFile(sourceFile));
    }



}