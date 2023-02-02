package ch.bbw.zork.service;

import ch.bbw.zork.model.Collectable;
import ch.bbw.zork.repository.CollectableRepository;

import java.util.Optional;

public class CollectableService {



    private CollectableRepository collectableRepository;
    private RoomService roomService;

    public CollectableService() {
        collectableRepository = new CollectableRepository();
    }

    public Collectable getCollectableByName(String name) {
        Optional<Collectable> collectableOptional = collectableRepository.getCollactableByName(name);
        return collectableOptional.isPresent()? collectableOptional.get(): null;
    }

    public Collectable[] getAllCollectables() {
        return collectableRepository.getAllCollectables();
    }

    public Collectable[] getInventory() {
        return collectableRepository.getInventory();
    }

    public Collectable addCollectableToInventory(Collectable collectable) {
        Collectable[] inventory = getInventory();
        for(int i = 0; i < inventory.length; i++) {
            if(inventory[i] == null) {
                inventory[i] = collectable;
                return collectable;
            }
        }

        return null;
    }

    public Collectable pickUp(Collectable collectable) {
        roomService.getAllCollectables(roomService.getCurrentRoom()).forEach((key, value) -> {
            if(value.equals(collectable)) {
                key.removeCollectable(value);
                addCollectableToInventory(collectable);
                if(value.isKey()) {
                    System.out.println("You won!!!");
                }
            }

        });
        return collectable;
    }

    public Collectable removeCollectableToInventory(int index) {
        Collectable collectable = getInventory()[index];

        return collectable;
    }
}
