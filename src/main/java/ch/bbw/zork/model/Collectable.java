package ch.bbw.zork.model;

public class Collectable extends Item {

    private boolean isKey;

    public Collectable() {
        super(null, 0);
        this.isKey = false;
    }

    public Collectable(String name, double weight, boolean isKey) {
        super(name, weight);
        this.isKey = isKey;
    }

    public boolean isKey() {
        return isKey;
    }

    public void setIsKey(boolean isKey) {
        this.isKey = isKey;
    }
}
