package by.gsu.pms;

public class Item {
    private String itemTitle;
    private String itemDescription;
    private String itemLink;

    public Item(String itemTitle, String itemDescription, String itemLink) {
        this.itemTitle = itemTitle;
        this.itemDescription = itemDescription;
        this.itemLink = itemLink;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemLink() {
        return itemLink;
    }

    public void setItemLink(String itemLink) {
        this.itemLink = itemLink;
    }

    @Override
    public String toString(){
        return "News\nTitle: " + itemTitle + "\nLink: " + itemLink + "\nDescription: " + itemDescription;
    }
}
