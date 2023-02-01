package ch.bbw.zork.service;

import ch.bbw.zork.model.Collectable;
import ch.bbw.zork.repository.CollectableRepository;

import java.util.Optional;

public class CollectableService {



    private CollectableRepository collectableRepository;

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

    public Collectable removeCollectableToInventory(int index) {
        Collectable collectable = getInventory()[index];

        return collectable;
    }
}
