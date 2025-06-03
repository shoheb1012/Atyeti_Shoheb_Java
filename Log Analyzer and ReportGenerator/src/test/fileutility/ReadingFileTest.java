package test.fileutility;

import file_utility.ReadingFile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class ReadingFileTest {

    private ReadingFile readerWithData;
    private ReadingFile readerEmptyFile;
    private File validDataFile;
    private File emptyFile;
    private File invalidFile;

    @BeforeEach
    void setUp() throws IOException {

        validDataFile = new File("resource/log2.log");
        emptyFile = new File("resource/emptylogfile.log");
        invalidFile = new File("resource/nonexistent.log");

        readerWithData = new ReadingFile();
        readerWithData.processLogFile(validDataFile);

        readerEmptyFile = new ReadingFile();
        readerEmptyFile.processLogFile(emptyFile);
    }

    @Test
    void testLogCountsFromDataFile() {

        assertEquals(8, readerWithData.getInfoCount());
        assertEquals(2, readerWithData.getWarnCount());
        assertEquals(2, readerWithData.getErrorCount());
    }

    @Test
    void testEmptyFileCounts() {

        assertEquals(0, readerEmptyFile.getInfoCount());
        assertEquals(0, readerEmptyFile.getWarnCount());
        assertEquals(0, readerEmptyFile.getErrorCount());
    }

    @Test
    void testInvalidFileHandling() {

       // ReadingFile readerInvalid = new ReadingFile();
        assertDoesNotThrow(() -> readerWithData.processLogFile(invalidFile));
    }

    @Test
    void testInfoLog() {

        assertEquals(8, readerWithData.getInfoCount());
    }

    @Test
    void testWarningLog() {

        assertEquals(2, readerWithData.getWarnCount());
    }

    @Test
    void testErrorLog() {

        assertEquals(2, readerWithData.getErrorCount());
    }
}
