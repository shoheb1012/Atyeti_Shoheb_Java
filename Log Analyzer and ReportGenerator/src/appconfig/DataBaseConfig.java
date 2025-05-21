package appconfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public interface DataBaseConfig {
    String JDBC_URL = "jdbc:mysql://localhost:3306/logger_db";
    String USER = "root";
    String PASSWORD = "Pass";
    String query = "CREATE TABLE logger (" +
            "id INT AUTO_INCREMENT PRIMARY KEY, " +
            "timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +
            "error INT, " +
            "warning INT, " +
            "info INT)";

    static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
        return connection;
    }
}
