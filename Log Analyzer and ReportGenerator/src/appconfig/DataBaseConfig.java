package appconfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public interface DataBaseConfig {
    String JDBC_URL = "jdbc:mysql://localhost:3306/logger_db";
    String USER = "root";
    String PASSWORD = "Pass";
    String TABLE_CREATION_QUERY = "CREATE TABLE logger (" +
            "id INT AUTO_INCREMENT PRIMARY KEY, " +
            "timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +
            "error INT, " +
            "warning INT, " +
            "info INT)";

    String INSERT_QUERY = "INSERT INTO logger (error, warning, info) VALUES (?, ?, ?)";

}
