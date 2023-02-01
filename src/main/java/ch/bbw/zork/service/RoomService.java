package ch.bbw.zork.service;

import ch.bbw.zork.model.Room;
import ch.bbw.zork.repository.RoomRepository;

import java.util.Optional;

public class RoomService {

    private RoomRepository roomRepository;

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

    public boolean goRoom(String direction) {

            // Try to leave current room.
            Room nextRoom = getCurrentRoom().nextRoom(direction);

            if (nextRoom == null) {
                System.out.println("There is no door!");
                return false;
            }
            else {
                setCurrentRoom(nextRoom);
                return true;
            }
    }
}
