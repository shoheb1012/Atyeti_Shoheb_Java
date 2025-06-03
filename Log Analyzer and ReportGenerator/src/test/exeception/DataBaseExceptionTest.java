package test.exeception;

import exceptionhandling.DataBaseException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DataBaseExceptionTest {

    @Test
    void shouldThrowDataBaseExceptionWithCorrectMessage() {
        DataBaseException ex = assertThrows(DataBaseException.class, () -> {
            throw new DataBaseException("DB error occurred");
        });
        assertEquals("DB error occurred", ex.getMessage());
    }
}


