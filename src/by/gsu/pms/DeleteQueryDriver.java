package by.gsu.pms;

import java.sql.*;

public class DeleteQueryDriver {
    private static PreparedStatement preparedStatement;


    private DeleteQueryDriver() { }

    public static String executeDeleteQuery(int taskNumber, String query, Connection connection) throws SQLException {
        String result = "";
        try {
            preparedStatement = connection.prepareStatement(query);
        } catch (SQLException sqlException) {
            System.out.println(">>> Delete query execution failed.");
            sqlException.printStackTrace();
        } finally {
            preparedStatement.close();
        }
        return result;
    }
}