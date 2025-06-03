package test.config;


import appconfig.DataBaseConfig;
import appconfig.DbConnection;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;

public class DbConnectionTest {

    @Test
    void connectionShouldNotNull() {
        try (Connection connection = DbConnection.getConnection()) {
            assertNotNull(connection, "Connection should not be null");
        } catch (SQLException e) {
           e.printStackTrace();
        }
    }

    @Test
    public void shouldThrowSQLExceptionForInvalidConnection()
    {
        assertThrows(SQLException.class,()->{
           DriverManager.getConnection(DataBaseConfig.JDBC_URL, "invalid_User", DataBaseConfig.PASSWORD);
        });
    }

//    @Test
//    public void testConnectionNullHandling() {
//        try {
//            Connection connection = DbConnection.getConnection();
//            if (connection == null) {
//                System.out.println("Handled null connection gracefully.");
//            }
//        } catch (Exception e) {
//            fail("Should not throw any exception");
//        }
//    }

}