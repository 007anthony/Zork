package ch.bbw.zork.repository;

import ch.bbw.zork.model.Collectable;
import ch.bbw.zork.model.Furniture;
import ch.bbw.zork.model.Room;
import ch.bbw.zork.service.CollectableService;

import java.util.Arrays;
import java.util.Optional;

public class FurnitureRepository {

    private Furniture[] furnitures;

    public FurnitureRepository() {
        CollectableService collectableService = new CollectableService();

        Furniture bookshelf = new Furniture("bookshelf", 1000*1000);
        bookshelf.addCollectable(collectableService.getCollectableByName("book 1"));


        Furniture desk = new Furniture("desk", 10000);

        desk.addCollectable(collectableService.getCollectableByName("cassette"));

        furnitures = new Furniture[] {
          bookshelf, desk
        };
    }

    public Furniture[] getAllFurnitures() {
        return furnitures;
    }
    public Furniture[] getAllFurnituresFromRoom(Room room) {
        return room.getFurnitures();
    }

    public Optional<Furniture> getFurnitureByName(String name) {
        return Arrays.stream(furnitures)
                .filter(furniture -> furniture.getName().equals(name))
                .findFirst();
    }
}
