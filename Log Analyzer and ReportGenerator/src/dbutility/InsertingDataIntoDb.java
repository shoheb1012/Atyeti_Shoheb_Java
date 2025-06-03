package dbutility;


import appconfig.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

public class InsertingDataIntoDb {

    static Logger logger = Logger.getLogger(InsertingDataIntoDb.class.getName());

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
