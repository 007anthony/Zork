package ch.bbw.zork;

public class Item {

    private String itemName;
    private boolean isItem;

    public Item() {
        this(null, false);


    }

    public Item(String itemName,boolean isItem) {
        this.itemName = itemName;
        this.isItem = isItem;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public boolean isItem() {
        return isItem;
    }

    public void setItem(boolean isItem) {
        isItem = isItem;
    }
}
