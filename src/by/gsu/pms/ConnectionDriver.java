package by.gsu.pms;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDriver {
    private static final String URL = "jdbc:mysql://localhost:3306/myjdbc?serverTimezone=Europe/Minsk&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public ConnectionDriver() {
    }

    public Connection getConnect() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Соединение открыто");
        } catch (Exception ex) {
            System.out.println("Ошибка соединения");
            ex.printStackTrace();
        }
        return connection;
    }

}
