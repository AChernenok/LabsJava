package by.gsu.pms;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SaxParser {

    public static void parse() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        XMLHandler handler = new XMLHandler();
        parser.parse(new File("resources/tutby.xml"), handler);
    }

    private static class XMLHandler extends DefaultHandler {
        private static ArrayList<Item> items = new ArrayList<>();
        private String lastElementName;
        private String title;
        private String link;
        private String description;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            lastElementName = qName;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String information = new String(ch, start, length);
            information = information.replace("\n", "").trim();

            if (!information.isEmpty()) {
                if (lastElementName.equals("title")) {
                    title = information;
                }
                if (lastElementName.equals("link")) {
                    link = information;
                }
                if (lastElementName.equals("description")) {
                    description = information;
                }
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            if ((title != null && title.isEmpty())
                    && (description != null && description.isEmpty())
                    && (link != null && link.isEmpty())) {
                items.add(new Item(description, title, link));
            }
            title = null;
            description = null;
            link = null;
        }

    }

}
