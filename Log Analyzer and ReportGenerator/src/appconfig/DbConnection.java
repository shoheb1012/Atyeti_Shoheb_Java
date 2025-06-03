package appconfig;

import file_utility.ErrorFileWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public interface DbConnection {
    Logger LOGGER = Logger.getLogger(DbConnection.class.getName());
    static Connection getConnection() throws SQLException {
        try {
            Connection connection = DriverManager.getConnection(DataBaseConfig.JDBC_URL, DataBaseConfig.USER, DataBaseConfig.PASSWORD);
            LOGGER.info("Database Connected Successfully : ");
            return connection;
        } catch (SQLException e) {
           LOGGER.warning(e.getMessage());
            ErrorFileWriter.log(e.getMessage());
        }
        return null;
    }
}
