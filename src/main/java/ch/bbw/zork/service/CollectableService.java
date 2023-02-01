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
}
