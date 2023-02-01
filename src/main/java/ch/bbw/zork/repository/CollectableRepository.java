package ch.bbw.zork.repository;

import ch.bbw.zork.model.Collectable;
import ch.bbw.zork.model.Item;

import java.util.Arrays;
import java.util.Optional;

public class CollectableRepository {

    private Collectable[] collectables;
    private static Collectable[] inventory = new Collectable[8];

    public CollectableRepository() {
        Collectable cassette = new Collectable("Cassette", 10, false);
        Collectable key = new Collectable("Key", 50, true);

        collectables = new Collectable[] {cassette, key};

    }

    public Optional<Collectable> getCollactableByName(String name) {
         return Arrays.stream(collectables)
                .filter(collectable -> collectable.getName().equals(name))
                .findFirst();

    }

    public Collectable[] getAllCollectables() {
        return collectables;
    }

    public Collectable[] getInventory() {
        return inventory;
    }


}
