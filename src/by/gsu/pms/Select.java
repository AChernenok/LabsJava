package by.gsu.pms;

import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;

public class Select {
    public static final String DELIVERIES_QUERY = "SELECT * FROM delivery;";
    public static final String COURIERS_QUERY = "SELECT * FROM couriers;";
    public static final String COURIER_QUERY = "SELECT courier_name, courier_salary FROM couriers WHERE courier_id = ?";
    public static final String ORDERS_QUERY = "SELECT * FROM orders";
    public static final String ORDER_QUERY = "SELECT order_name, order_cost FROM orders WHERE order_id = ?";

    private Select(){}


    public static ArrayList<DeliveryRecord> selectDeliveryRecords(Connection connection) throws SQLException{
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<DeliveryRecord> deliveryRecords = new ArrayList<>();

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(DELIVERIES_QUERY);

            int deliveryId = resultSet.getInt("delivery_id");
            int orderId = resultSet.getInt("order_id");
            int courierId = resultSet.getInt("courier_id");
            int deliveryTime = resultSet.getInt("delivery_time");

            deliveryRecords.add(new DeliveryRecord(deliveryId, orderId, courierId, deliveryTime));

        } catch (SQLException sqlException){
            System.out.println("Error select query");
            sqlException.printStackTrace();
        } finally {
            assert statement != null;
            statement.close();
            assert resultSet != null;
            resultSet.close();
        }

        return deliveryRecords;
    }

    public static ArrayList<Couriers> couriers(Connection connection) throws SQLException {
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<Couriers> couriers = new ArrayList<>();

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(COURIERS_QUERY);

            int courierId = resultSet.getInt("courier_id");
            String courierName = resultSet.getString("courier_name");
            int courierSalary = resultSet.getInt("courier_salary");

            couriers.add(new Couriers(courierId, courierName, courierSalary));

        } catch (SQLException sqlException){
            System.out.println("Error select query");
            sqlException.printStackTrace();
        } finally {
            assert statement != null;
            statement.close();
            assert resultSet != null;
            resultSet.close();
        }

        return couriers;
    }

    public static Couriers selectCourierById(int courierId, Connection connection) throws SQLException{
        Couriers couriers;

        try (PreparedStatement preparedStatement = connection.prepareStatement(COURIER_QUERY)){
            preparedStatement.setInt(1, courierId);
            ResultSet resultSet = null;
            couriers = null;

            try {
                resultSet = preparedStatement.executeQuery();
                String courierName = resultSet.getString("courier_name");
                int courierSalary = resultSet.getInt("courier_salary");


                couriers = new Couriers(courierName, courierSalary);
            } catch (SQLException sqlException){
                assert resultSet != null;
                resultSet.close();
            } finally {
                assert resultSet != null;
                resultSet.close();
            }
        }
        return couriers;
    }

    public static ArrayList<Orders> selectOrders(Connection connection) throws SQLException{
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<Orders> orders = new ArrayList<>();

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(ORDERS_QUERY);

            int orderId = resultSet.getInt("order_id");
            String orderName = resultSet.getString("order_name");
            int orderCost = resultSet.getInt("order_cost");

            orders.add(new Orders(orderId, orderName, orderCost));
        } catch (SQLException sqlException){
            assert statement != null;
            statement.close();
            assert resultSet != null;
            resultSet.close();
        }
        return orders;
    }

    public static Orders selectOrderById(int orderId, Connection connection) throws SQLException{
        Orders orders;
        try (PreparedStatement preparedStatement = connection.prepareStatement(ORDER_QUERY)){
            preparedStatement.setInt(1, orderId);
            ResultSet resultSet = null;
            orders = null;

            try {
                resultSet = preparedStatement.executeQuery();
                String orderName = resultSet.getString("order_name");
                int orderCost = resultSet.getInt("order_cost");

                orders = new Orders(orderId, orderName, orderCost);
            } catch (SQLException sqlException){
                assert resultSet != null;
                resultSet.close();
            } finally {
                assert resultSet != null;
                resultSet.close();
            }
        }

        return orders;
    }
}
