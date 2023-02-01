package ch.bbw.zork.repository;

import ch.bbw.zork.model.Collectable;
import ch.bbw.zork.model.Furniture;
import ch.bbw.zork.service.CollectableService;

import java.util.Arrays;
import java.util.Optional;

public class FurnitureRepository {

    private Furniture[] furnitures;

    public FurnitureRepository() {
        CollectableService collectableService = new CollectableService();

        Furniture bookshelf = new Furniture("bookshelf", 1000*1000);
        bookshelf.addCollectable(collectableService.getCollectableByName("book 1"));

        furnitures = new Furniture[] {
          bookshelf
        };
    }

    public Furniture[] getAllFurnitures() {
        return furnitures;
    }

    public Optional<Furniture> getFurnitureByName(String name) {
        return Arrays.stream(furnitures)
                .filter(furniture -> furniture.getName().equals(name))
                .findFirst();
    }
}
