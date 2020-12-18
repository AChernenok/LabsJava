import by.gsu.pms.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws SQLException{
        Scanner scanner = new Scanner(System.in);
        int menuChoice;
        boolean isRunning = true;
        Mapper mapper = new Mapper();
        ArrayList<Object> queryParameters = new ArrayList<>();

        Connection connection = (Connection) ConnectionDB.openConnection();
        if(connection != null){
            while (isRunning){
                showMenu();
                System.out.println("Choose menu item:");
                menuChoice = scanner.nextInt();
                switch (menuChoice){
                    case 1:
                        ArrayList<DeliveryRecord> deliveryRecords = Select.selectDeliveryRecords(connection);
                        for (DeliveryRecord deliveryRecord: deliveryRecords){
                            Orders orders = Select.selectOrderById(deliveryRecord.getOrderId(), connection);
                            Couriers couriers = Select.selectCourierById(deliveryRecord.getCourierId(), connection);
                            DeliveryRecordDTO deliveryRecordDTO = mapper.mapDeliveryDTO(deliveryRecord, couriers, orders);
                        }
                        break;
                    case 2:
                        ArrayList<Orders> orders = Select.selectOrders(connection);
                        break;
                    case 3:
                        ArrayList<Couriers> couriers = Select.couriers(connection);
                        break;
                    case 4:
                        System.out.println("Enter order id: ");
                        int orderId = scanner.nextInt();
                        queryParameters.add(orderId);
                        System.out.println("Enter courier id: ");
                        int courierId = scanner.nextInt();
                        queryParameters.add(courierId);
                        System.out.println("Enter delivery time: ");
                        int deliveryTime = scanner.nextInt();
                        queryParameters.add(deliveryTime);

                        Insert.insertDeliveryRecord(queryParameters, connection);
                        break;
                    case 5:
                        System.out.println("Enter courier name: ");
                        String courierName = scanner.next();
                        queryParameters.add(courierName);
                        System.out.println("Enter courier salary: ");
                        int courierSalary = scanner.nextInt();
                        queryParameters.add(courierSalary);

                        Insert.insertCourier(queryParameters, connection);
                        break;
                    case 6:
                        isRunning = false;
                }
            }
        }
    }

    private static void showMenu() {
        System.out.println("1. SELECT delivery records");
        System.out.println("2. SELECT orders");
        System.out.println("3. SELECT couriers");
        System.out.println("4. INSERT delivery records");
        System.out.println("5. INSERT courier");
        System.out.println("6. EXIT");
    }
}
