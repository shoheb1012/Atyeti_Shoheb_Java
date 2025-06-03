package test.fileutility;
import appconfig.FileConfig;
import file_utility.ErrorFileWriter;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ErrorFileWriterTest {

    @Test
    public void shouldWriteErrorMessageToFile() throws IOException {


        String errorMsg = "Something went wrong";

        ErrorFileWriter.log(errorMsg);

        // Assert
        File file = new File(FileConfig.ERROR_LOG_FILE);
        List<String> lines = Files.readAllLines(file.toPath());
        int count = 78;

        assertEquals(count, lines.size());
        assertEquals("[ERROR] " + errorMsg, lines.get(75));

    }


}