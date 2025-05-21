package dbutility;

import appconfig.DataBaseConfig;
import exceptionhandling.DataBaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;


public class TableCreation {

    static Logger logger = Logger.getLogger(TableCreation.class.getName());
    public static void createTable(String query) throws SQLException {
        Connection connection = DataBaseConfig.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        try
        {
            preparedStatement.execute();
            logger.info("Table created Successfully");
        }
        catch (DataBaseException e)
        {
            logger.warning("Failed to create table "+e.getMessage());
        }
    }
}
