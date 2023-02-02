package ch.bbw.zork.service;

import ch.bbw.zork.model.Furniture;
import ch.bbw.zork.model.Room;
import ch.bbw.zork.repository.FurnitureRepository;

import java.util.Optional;

public class FurnitureService {

    private FurnitureRepository furnitureRepository;

    public FurnitureService() {
        furnitureRepository = new FurnitureRepository();
    }

    public Furniture[] getAllFurnitures() {
        return furnitureRepository.getAllFurnitures();
    }

    public Furniture getFurnitureByName(String name) {
        Optional<Furniture> furnitureOptional = furnitureRepository.getFurnitureByName(name);
        return furnitureOptional.isPresent()? furnitureOptional.get(): null;
    }

    public Furniture[] getAllFurnituresFromRoom(Room room) {
        return furnitureRepository.getAllFurnituresFromRoom(room);
    }
}
