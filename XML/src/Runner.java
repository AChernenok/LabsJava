import by.gsu.pms.Channel;
import by.gsu.pms.DomParser;
import by.gsu.pms.Item;
import by.gsu.pms.SaxParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Runner {
    public static final String URL = "https://news.tut.by/rss/auto/road.rss";
    private static Channel channel;
    private static ArrayList<Item> items;

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        Scanner scanner = new Scanner(System.in);
        int userInput;
        boolean isTrue = true;

        do {
            System.out.println("\n Выберите метод получения данных:");
            System.out.println("1:Получить данные при помощи Dom парсера");
            System.out.println("2:Получить данные при помощи SAX парсера");
            System.out.println("3:Получить данные при помощи StAX парсера");
            System.out.println("4:Выход из программы");
            userInput = scanner.nextInt();
            switch (userInput) {
                case (1): {

                    channel = DomParser.parse(URL);

                    for (Item item : channel.getItems()) {
                        System.out.println("\nTitle: " + item.getNumberItem());
                        System.out.println("Link: " + item.getNumberTitle());
                        System.out.println("Description: " + item.getLink());
                    }
                    break;
                }
                case (2): {
                    SaxParser.parse();
                    break;
                }
                //case 3 ->1
                case (4): {

                    isTrue = false;
                    break;
                }
                default:
                    System.out.println("Неправильный выбор!");
            }


        } while (isTrue);
    }

}
