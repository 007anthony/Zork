package ch.bbw.zork;

import java.util.ArrayList;
import java.util.List;

public class Furniture {

    private String furnitureName;
    private List<Item> items;

    public Furniture() {
        this(null);
    }

    public Furniture(String furnitureName) {
        this.furnitureName = furnitureName;
        this.items = new ArrayList<>();

    }

    public String getFurnitureName() {
        return furnitureName;
    }

    public void setFurnitureName(String furnitureName) {
        this.furnitureName = furnitureName;
    }

    public List<Item> getItems() {
        return this.items;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }
}
