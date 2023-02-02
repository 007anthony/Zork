package ch.bbw.zork.model;

import java.util.ArrayList;
import java.util.List;

public class Furniture extends Item {
    private List<Collectable> collectables;

    public Furniture() {
        super();
        this.collectables = new ArrayList<>();
    }

    public Furniture(String furnitureName, double weight) {
        super(furnitureName, weight);
        this.collectables = new ArrayList<>();

    }

    public List<Collectable> getCollectables() {
        return this.collectables;
    }

    public void removeCollectable(Collectable collectable) {
        collectables.remove(collectable);
    }

    public void addCollectable(Collectable collectable) {
        this.collectables.add(collectable);
    }
}
