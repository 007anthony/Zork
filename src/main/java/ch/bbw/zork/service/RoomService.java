package ch.bbw.zork.service;

import ch.bbw.zork.model.Collectable;
import ch.bbw.zork.model.Furniture;
import ch.bbw.zork.model.Room;
import ch.bbw.zork.repository.RoomRepository;

import java.util.*;
import java.util.stream.Collectors;

public class RoomService {

    private RoomRepository roomRepository;
    private FurnitureService furnitureService;

    public RoomService() {
        roomRepository = new RoomRepository();
    }

    public Room[] getAllRooms() {
        return roomRepository.getAllRooms();
    }

    public Room getCurrentRoom() {
        return roomRepository.getCurrentRoom();
    }

    public void setCurrentRoom(Room currentRoom) {
        roomRepository.setCurrentRoom(currentRoom);
    }

    public Room getRoomByName(String name) {
        Optional<Room> roomOptional = roomRepository.getRoomByName(name);
        return roomOptional.isPresent()? roomOptional.get(): null;
    }

    public Map<Furniture, Collectable> getAllCollectables(Room room) {
        Map<Furniture, Collectable> collectableMap = new HashMap<>();
        for(Furniture furniture: furnitureService.getAllFurnituresFromRoom(room)) {
            for(Collectable collectable : furniture.getCollectables()) {
                collectableMap.put(furniture, collectable);
            }
        }
        return collectableMap;
    }

    public Room goRoom(String direction) {

            // Try to leave current room.
            Room nextRoom = getCurrentRoom().nextRoom(direction);

            if (nextRoom == null) {
                System.out.println("There is no door!");
                return null;
            }
            else {
                setCurrentRoom(nextRoom);
                return nextRoom;
            }
    }
}
