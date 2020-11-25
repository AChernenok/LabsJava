package by.gsu.pms;

import java.util.ArrayList;

public class Item {
    private String numberItem;
    private String numberTitle;
    private String link;

    public Item(String numberItem, String numberTitle, String link) {
        this.numberItem = numberItem;
        this.numberTitle = numberTitle;
        this.link = link;
    }

    public Item() {
    }

    public String getNumberItem() {
        return numberItem;
    }

    public void setNumberItem(String numberItem) {
        this.numberItem = numberItem;
    }

    public String getNumberTitle() {
        return numberTitle;
    }

    public void setNumberTitle(String numberTitle) {
        this.numberTitle = numberTitle;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
