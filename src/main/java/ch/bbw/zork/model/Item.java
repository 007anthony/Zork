package ch.bbw.zork.model;

public class Item {

    private String name;
    private double weight;

    public Item() {
        this(null, 0.0);


    }

    public Item(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
