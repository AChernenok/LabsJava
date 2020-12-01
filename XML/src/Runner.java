import by.gsu.pms.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.Scanner;

public class Runner {
    public static final String URL = "https://news.tut.by/rss/auto/road.rss";

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, XMLStreamException {
        Scanner scanner = new Scanner(System.in);
        int userInput;
        boolean isTrue = true;

        while (isTrue){
            System.out.println("\n Выберите метод получения данных:");
            System.out.println("1:Получить данные при помощи Dom парсера");
            System.out.println("2:Получить данные при помощи SAX парсера");
            System.out.println("3:Получить данные при помощи StAX парсера");
            System.out.println("4:Выход из программы");
            userInput = scanner.nextInt();
            Channel channel;
            switch (userInput) {
                case (1): {
                    channel = DomParser.parse(URL);
                    showResult(channel);
                    break;
                }
                case (2): {
                    channel = SaxParser.parse();
                    showResult(channel);
                    break;
                }
                case (3):{
                    channel = StaxParse.parse();
                    showResult(channel);
                    break;
                }
                case (4): {
                    isTrue = false;
                    break;
                }
                default:
                    System.out.println("Неправильный выбор!");
            }


        }
    }

    public static void showResult(Channel channel) {
        for (Item item : channel.getItems()) {
            System.out.println("\nTitle: " + item.getItemTitle());
            System.out.println("Link: " + item.getItemLink());
            System.out.println("Description: " + item.getItemDescription());
        }
    }
}
