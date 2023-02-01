package ch.bbw.zork.repository;

import ch.bbw.zork.model.Room;

import java.util.Arrays;
import java.util.Optional;

public class RoomRepository {

    private static Room currentRoom;

    private Room[] rooms;

    public RoomRepository() {
        Room entry = new Room("entry", "You are in the entry.");
        Room livingRoom = new Room("living room", "You are in the living room.");
        Room kitchen = new Room("kitchen", "You are in the kitchen.");
        Room lobby = new Room("lobby", "You are in the lobby.");
        Room office = new Room("office", "You are in the office.");
        Room bathroom = new Room("bathroom", "You are in the bathroom.");
        Room bedroom = new Room("bedroom", "You are in the bedroom");
        Room secretLab = new Room("secret lab", "You have found the secret lab. \n Congrats!");


        entry.setExits(null, kitchen, lobby, livingRoom );
        livingRoom.setExits(null, entry, office, null);
        kitchen.setExits(null, null, null, entry);
        lobby.setExits(entry, bedroom, bathroom, null);
        office.setExits(livingRoom, null, null, null);
        bathroom.setExits(lobby, null, null, null);
        bedroom.setExits(null, null, null, lobby);
        secretLab.setExits(null, null, bedroom, null);

        rooms = new Room[] {entry, livingRoom, kitchen, lobby, office, bathroom, bedroom, secretLab};
        currentRoom = entry;
    }

    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public Optional<Room> getRoomByName(String name) {
        return Arrays.stream(rooms)
                .filter(room -> room.getName().equals(name))
                .findFirst();
    }

    public Room[] getAllRooms() {
        return rooms;
    }


}