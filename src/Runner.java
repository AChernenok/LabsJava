import by.gsu.pms.ConnectionDriver;
import by.gsu.pms.DeleteQueryDriver;
import by.gsu.pms.SelectQueryDriver;
import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws IOException, SQLException {
        Scanner scanner = new Scanner(System.in);
        int userInput;
        boolean test = true;

        Connection connection = new ConnectionDriver().getConnect();
        ScriptRunner scriptRunner = new ScriptRunner(connection);
        try {
            Reader readerCreate = new BufferedReader(new FileReader("./resources/CREATE_DB.sql"));
            scriptRunner.runScript(readerCreate);

            Reader readerInsert = new BufferedReader(new FileReader("./resources/InsertScript.sql"));
            scriptRunner.runScript(readerInsert);
            System.out.println("Таблицы созданы и заполнены");
        }catch (Exception ex ){
            System.out.println("Таблицы уже существуют");
        }
        if (connection != null) {
            showMenu();
            System.out.println("\n Выберите: ");
            userInput = scanner.nextInt();
            switch (userInput) {
                case 1:
                    String result = "";
                    String exercise1Select = "select filmname\n" +
                            "from films\n" +
                            "where ((films.releasedate in (2019)) or (films.releasedate in (2020)))";
                    result += SelectQueryDriver.executeSelectQuery(1, exercise1Select, connection);
                    String exercise2Select = "select cast.name, cast.birthdate\n" +
                            "from cast\n" +
                            "inner join films on cast.id = films.castid\n" +
                            "where films.filmname = 'Mstiteli'";
                    result += SelectQueryDriver.executeSelectQuery(2, exercise2Select, connection);
                    String exercise3Select = "select cast.name, cast.birthdate\n" +
                            "from cast\n" +
                            "inner join films on cast.id = films.id group by cast.name, cast.birthdate\n" +
                            "having count(films.filmname)>=1";
                    result += SelectQueryDriver.executeSelectQuery(3, exercise3Select, connection);
                    String exercise4Select = "select cast.name, cast.birthdate, films.role\n" +
                            "from cast\n" +
                            "inner join films on cast.id = films.id group by cast.name, cast.birthdate\n" +
                            "having films.role = 'producer'";
                    result += SelectQueryDriver.executeSelectQuery(4, exercise4Select, connection);
                    reportToHTML(result);
                    break;
                case 2:
                    String exercise5Update = "delete from films WHERE films.releasedate > '2019';";
                    DeleteQueryDriver.executeDeleteQuery(5, exercise5Update, connection);
                    break;
                case 3:
                    System.out.println("exit");
                    test = false;
                    connection.close();
                    break;
                default:
                    System.out.println("err input");
                    break;
            }
        } else {
            System.out.println("exit");
        }

    }

    public static void showMenu() {
        System.out.println("Выберите тип запроса: ");
        System.out.println("Select: 1");
        System.out.println("Delete : 2");
        System.out.println("Выход: 3");
    }

    public static void reportToHTML(String result) {
        File f = new File("./resources/index.html");
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f))) {
            System.out.println("Создание index.html...");
            bufferedWriter.write(
                    "<!DOCTYPE html>" +
                            "<html lang=\"en\">" +
                            "   <head>" +
                            "       <meta charset=\"UTF-8\">" +
                            "       <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">" +
                            "       <title>Видеотека</title>" +
                            "       <style>.taskTable{display: inline-block; margin-left: 2rem;}</style>"+
                            "   </head>" +
                            "   <body>" +
                            "       <h1>Видеотека</h1>" +
                            "       <p>" + result + "</p>" +
                            "   </body>" +
                            "</html>"
            );
            System.out.println("Файл сохранен в ./resources/index.html");
        } catch (Exception ex) {
            System.out.println("Ошибка при сохранении");
            ex.printStackTrace();
        }
    }
}

// 1. select filmname from films where ((films.releasedate in (2019)) or (films.releasedate in (2020)))
// 2. select cast.name, cast.birthdate from cast inner join films on cast.id = films.castid where films.filmname = "Mstiteli"
// 3. select cast.name, cast.birthdate from cast inner join films on cast.id = films.id group by cast.name, cast.birthdate having count(films.filmname)>=1
// 4. select cast.name, cast.birthdate, films.role from cast inner join films on cast.id = films.id group by cast.name, cast.birthdate having films.role = 'producer'
// 5. delete from films WHERE films.releasedate > "2019";
