package test.dbutility;

import appconfig.DbConnection;
import dbutility.InsertingDataIntoDb;


import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.mockito.Mockito.*;

public class InsertingDataIntoDbTest {

    @Test
    public void testInsertingCountIntoTable() throws SQLException {

        Connection mockConnection = mock(Connection.class);
        PreparedStatement mockStatement = mock(PreparedStatement.class);


        try (MockedStatic<DbConnection> dbConnectionMock = mockStatic(DbConnection.class)) {

            dbConnectionMock.when(DbConnection::getConnection).thenReturn(mockConnection);
            when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);
            when(mockStatement.executeUpdate()).thenReturn(1);

            // Call the method with sample values
            InsertingDataIntoDb.insertingCountIntoTable(109, 111, 297);

            // Verify that correct methods were called
            verify(mockStatement).setInt(1, 109);
            verify(mockStatement).setInt(2, 111);
            verify(mockStatement).setInt(3, 297);
            verify(mockStatement).executeUpdate();
        }
    }
}

