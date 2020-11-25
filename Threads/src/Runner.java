import by.gsu.pms.ThreadGenerator;
import by.gsu.pms.OperationType;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число потоков: ");
        int countOfThreads = scanner.nextInt();
        System.out.println("Введите число А: ");
        int maxValue = scanner.nextInt();
        System.out.println("Выберите операцию ('1 - сложение', '2 - вычитание', '3 - умножение)");
        String operationType = scanner.next();

        OperationType op = OperationType.ADDITION;

        switch (operationType) {
            case "1":
                op = OperationType.ADDITION;
                break;
            case "2":
                op = OperationType.SUBTRACTION;
                break;
            case "3":
                op = OperationType.MULTIPLICATION;
                break;
            default:
                System.out.println("Error! Выберите один из предложенных вариантов");
        }

        ThreadGenerator calculator;
        calculator = new ThreadGenerator(countOfThreads, op, maxValue);
        calculator.execute();
        System.out.println("\nВывод: " + calculator.getResult());
    }
}
