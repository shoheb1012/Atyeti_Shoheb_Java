package dbutility;
import appconfig.*;

import exceptionhandling.*;
import file_utility.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;


public class TableCreation {

    static Logger logger = Logger.getLogger(TableCreation.class.getName());

    public static void createTable(String query) {
        try {
            Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.execute();
            logger.info("Table created Successfully");
        } catch (SQLException | DataBaseException e) {
            logger.warning("Failed to create table " + e.getMessage());
            ErrorFileWriter.log("Failed to create table " + e.getMessage());
        }
    }
}
