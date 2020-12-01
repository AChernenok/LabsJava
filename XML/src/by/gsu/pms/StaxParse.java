package by.gsu.pms;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import javax.xml.stream.XMLStreamConstants;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class StaxParse {
    private static ArrayList<Item> items = new ArrayList<>();
    private static Channel channelObj;

    public static Channel parse() throws FileNotFoundException, XMLStreamException {
        String file = "resources/tutby.xml";
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(file));

        String title_t = null;
        String link_t = null;
        String description_t = null;

        boolean item_b = false;
        boolean title_b = false;
        boolean link_b = false;
        boolean description_b = false;

        while (reader.hasNext()) {
            XMLEvent xmlEvent = reader.nextEvent();
            switch (xmlEvent.getEventType()) {
                case XMLStreamConstants.START_ELEMENT:
                    StartElement startElement = xmlEvent.asStartElement();
                    String qName = startElement.getName().getLocalPart();
                    if (qName.equalsIgnoreCase("item")) {
                        item_b = true;
                        int n = 1;
                        channelObj = new Channel();
                    }
                    if (qName.equalsIgnoreCase("title")) {
                        title_b = true;

                    } else if (qName.equals("link")) {
                        link_b = true;

                    } else if (qName.equals("description")) {
                        description_b = true;

                    }
                    break;

                case XMLStreamConstants.CHARACTERS:
                    Characters characters = xmlEvent.asCharacters();
                    if (title_b && item_b) {
                        title_t = characters.getData();
                        title_b = false;
                    }
                    if (link_b && item_b) {
                        link_t = characters.getData();
                        link_b = false;
                    }
                    if (description_b && item_b) {
                        description_t = characters.getData();
                        description_b = false;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    EndElement endElement = xmlEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equalsIgnoreCase("item") && item_b) {
                        if (title_t != null
                                && link_t != null
                                && description_t != null) {
                            items.add(new Item(title_t, link_t, description_t));
                        }
                        item_b = false;
                    }
                    if (endElement.getName().getLocalPart().equalsIgnoreCase("channel")) {
                        channelObj.setItems(items);
                    }
                    break;
            }
        }
        return channelObj;
    }
}
