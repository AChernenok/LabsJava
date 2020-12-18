package by.gsu.pms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class Insert {
    public static final String DELIVERY_RECORD_QUERY = "INSERT INTO delivery(order_id, courier_id, delivery_time) VALUES (?,?,?,?,?);";
    public static final String COURIER_QUERY = "INSERT INTO courier(courier_name, courier_salary) VALUES (?, ?);";

    private Insert(){}

    public static void insertDeliveryRecord(ArrayList<Object> queryParameters, Connection connection){
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELIVERY_RECORD_QUERY)) {
            preparedStatement.setInt(1, (Integer) queryParameters.get(0));
            preparedStatement.setInt(2, (Integer) queryParameters.get(1));
            preparedStatement.setInt(3, (Integer) queryParameters.get(2));

            preparedStatement.execute();
            System.out.println("Insered");
        } catch (SQLException e) {
            System.out.println("Insert error");
            e.printStackTrace();
        }
    }

    public static void insertCourier(ArrayList<Object> queryParameters, Connection connection){
        try (PreparedStatement preparedStatement = connection.prepareStatement(COURIER_QUERY)) {
            preparedStatement.setString(1, (String) queryParameters.get(0));
            preparedStatement.setInt(2, (Integer) queryParameters.get(1));

            preparedStatement.execute();
            System.out.println("Insered");
        } catch (SQLException e) {
            System.out.println("Insert error");
            e.printStackTrace();
        }
    }
}
