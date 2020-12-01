package by.gsu.pms;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;
import java.util.ArrayList;

public class SaxParser {
    public static Channel channelObj;

    public static Channel parse() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        XMLHandler handler = new XMLHandler();
        parser.parse("resources/tutby.xml", handler);
        return channelObj;
    }

    private static class XMLHandler extends DefaultHandler {
        private static final ArrayList<Item> items_t = new ArrayList<>();
        private String title_t;
        private String link_t;
        private String description_t;
        private Channel channel_t;

        boolean title_b = false;
        boolean link_b = false;
        boolean description_b = false;


        @Override
        public void endDocument() {
            channelObj = channel_t;
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            if (qName.equalsIgnoreCase("title")) {
                title_b = true;
            }
            if (qName.equalsIgnoreCase("link")) {
                link_b = true;
            }
            if (qName.equalsIgnoreCase("description")) {
                description_b = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String information = new String(ch, start, length);
            information = information.replace("\n", "").trim();
            if (!information.isEmpty()) {
                if (title_b) {
                    title_t = information;
                    title_b = false;
                }
                if (link_b) {
                    link_t = information;
                    link_b = false;
                }
                if (description_b) {
                    description_t = information;
                    description_b = false;
                }
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            if (qName.equals("item")) {
                if ((title_t != null && !title_t.isEmpty())
                        && (description_t != null && !description_t.isEmpty())
                        && (link_t != null && !link_t.isEmpty())) {
                    items_t.add(new Item(title_t, description_t, link_t));
                    channel_t = new Channel(items_t);
                }
                title_t = null;
                description_t = null;
                link_t = null;
            }
        }

    }

}
