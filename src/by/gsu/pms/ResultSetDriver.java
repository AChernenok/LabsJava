package by.gsu.pms;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetDriver {
    private ResultSetDriver(){}

    public static String parseResultSet(int taskNumber, ResultSet resultSet) throws SQLException {
        StringBuilder taskResult = new StringBuilder("<div class='taskTable'><p>Запрос №" + taskNumber + "</p><table cellspacing='2' border='1' cellpadding='5'><thead><tr><td>name</td><td>birthday</td><td>role</td></tr></thead><tbody>");
        while (resultSet.next()) {
            String name = resultSet.getString(1);
            String birthday = resultSet.getString(2);
            String role = resultSet.getString(3);
            taskResult.append(String.format("<tr><td>%-10s</td><td>%-10s</td><td>%-10s</td></tr>",  name, birthday, role));
        }
        taskResult.append(String.format("</tbody></table></div>"));
        return taskResult.toString();
    }

    public static String parseResultSetExtended(int taskNumber, ResultSet resultSet) throws SQLException {
        StringBuilder taskResult = new StringBuilder("<div class='taskTable'><p>Запрос №" + taskNumber + "</p><table cellspacing='2' border='1' cellpadding='5'><thead><tr><td>filmname</td></tr></thead><tbody>");
        while (resultSet.next()) {
            String filmname = resultSet.getString(1);
            taskResult.append(String.format("<tr><td>%-10s</td></tr>", filmname));
        }
        taskResult.append(String.format("</tbody></table></div>"));
        System.out.println(taskResult.toString());
        return taskResult.toString();
    }
    public static String parseResultSetExtendedTwo(int taskNumber, ResultSet resultSet) throws SQLException {
        StringBuilder taskResult = new StringBuilder("<div class='taskTable'><p>Запрос №" + taskNumber + "</p><table cellspacing='2' border='1' cellpadding='5'><thead><tr><td>name</td><td>birthname</td></tr></thead><tbody>");
        while (resultSet.next()) {

            String name = resultSet.getString(1);
            String birthname = resultSet.getString(2);
            taskResult.append(String.format("<tr><td>%-10s</td><td>%-10s</td></tr>", name, birthname));
        }
        taskResult.append(String.format("</tbody></table></div>"));
        System.out.println(taskResult.toString());
        return taskResult.toString();
    }
}