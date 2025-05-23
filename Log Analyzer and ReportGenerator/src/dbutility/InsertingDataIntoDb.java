package src.dbutility;

import src.appconfig.*;
import src.appconfig.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static src.dbutility.TableCreation.logger;


public class InsertingDataIntoDb {

    public static void insertingCountIntoTable(int errorCount, int warnCount, int infoCount) throws SQLException {

        Connection connection = DbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DataBaseConfig.INSERT_QUERY);
        preparedStatement.setInt(1, errorCount);
        preparedStatement.setInt(2, warnCount);
        preparedStatement.setInt(3, infoCount);
        int i = preparedStatement.executeUpdate();
        if (i > 0) {

            logger.info("Data inserted Successfully");
        }
    }
}
