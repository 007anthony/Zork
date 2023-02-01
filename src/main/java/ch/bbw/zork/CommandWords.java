package ch.bbw.zork;

import ch.bbw.zork.annotation.CommandHandler;
import ch.bbw.zork.model.Room;

@CommandHandler
public class CommandWords {

    public void use() {
        System.out.println("Andrej was here");

    }
    public void help() {
        System.out.println("Hallo welt");
    }

    public void task() {
        /*for(Task task : getActiveTasks()) {
            System.out.println((task.isDone()?"\u001B[32m [ok] \u001B[00m": "o ") + task.getTask());
        }*/
    }

    public void release() {
        System.out.println("Gut ist nicht genügend");

    }

    public void inspect() {

    }

    public void go(String secondWord) {
        if (secondWord == null) {
            System.out.println("Go where?");
        } else {

            // Try to leave current room.
            Room nextRoom = Room.currentRoom.nextRoom(secondWord);

            if (nextRoom == null)
                System.out.println("There is no door!");
            else {
                Room.currentRoom = nextRoom;
                System.out.println(Room.currentRoom.longDescription());
            }
        }

    }

    public void back() {

    }

    public void open() {

    }

    public void map() {

        System.out.println("You are currently in: " + Room.currentRoom.getName());

        System.out.println(
                            """
                            ---------------------         	---------------------				---------------------
                            |   |   |    |      |			|					|				|					|
                            |------------- 	    |			|					|				|					|
                            |      living       | <------->	|	    Entry		| <----------> 	|	   Kitchen		|
                            |       room        |			|					|				|					|
                            |                   |			|					|				|					|
                            |                   |			|					|				|					|
                            ---------------------			----|-----------|----				---------------------
                                     /\\							|			|
                                     ||							|-----------|
                                     ||							|			|
                                     ||							|-----------|
                                     \\/							|			|
                            ---------------------			----|-----------|----				---------------------
                            |					|			|					|				|			|		|
                            |					|			|					|				|			--------|
                            |		office		| 			|		lobby		| <----------->	|		bedroom		|
                            |					|			|					|				|					|
                            |		  			|			|					|				|					|
                            |					|			|					|				|					|
                            ---------------------			---------------------				---------------------
                                                                     /\\	
                                                                     ||
                                                                     ||	
                                                                     ||
                                                                     \\/
                                                              ----------------
                                                              |				 |
                                                              |    bath      |
                                                              |    room      |
                                                              |              |
                                                              ----------------
                            
                            
                            
                            """
        );

    }

    /*private Task[] getActiveTasks() {
        List<Task> taskList = new ArrayList<>();
        for(Task task : tasks) {
            if(task.isActive()) {
                taskList.add(task);
            }
        }

        return taskList.toArray(new Task[taskList.size()]);
    }*/
}
