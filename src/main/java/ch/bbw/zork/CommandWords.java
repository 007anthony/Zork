package ch.bbw.zork;

import ch.bbw.zork.annotation.CommandHandler;
import ch.bbw.zork.model.Collectable;
import ch.bbw.zork.model.Furniture;
import ch.bbw.zork.model.Room;
import ch.bbw.zork.model.Task;
import ch.bbw.zork.service.CollectableService;
import ch.bbw.zork.service.FurnitureService;
import ch.bbw.zork.service.RoomService;
import ch.bbw.zork.service.TaskService;

@CommandHandler
public class CommandWords {
    private TaskService taskService;
    private Parser parser;
    private RoomService roomService;
    private FurnitureService furnitureService;
    private CollectableService collectableService;

    public CommandWords() {
        taskService = new TaskService();
        parser = new Parser(System.in);
        roomService = new RoomService();
        furnitureService = new FurnitureService();
        collectableService = new CollectableService();
    }

    public void use(String collectableName) {
        Collectable collectable = collectableService.getCollectableByName(collectableName);
        taskService.activateTask(collectable);

    }
    public void help() {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at Monash Uni, Peninsula Campus.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println(parser.showCommands());
    }

    public void task() {
        for(Task task : taskService.getActiveTasks()) {
            System.out.println((task.isDone()?"\u001B[32m [ok] \u001B[00m": "o ") + task.getTask());
        }
    }

    public void release(String index) {
        try {
            Collectable result = collectableService.removeCollectableToInventory(Integer.parseInt(index) - 1);
            if(result != null) {
                System.out.println(result.getName() + " was removed from the inventory");
            }
            else {
                System.out.println("There was no item on this position");
            }
        }
        catch(NumberFormatException e) {
            System.out.println("Please enter a number");
        }
    }

    public void inspect(String furnitureName) {
        Furniture furniture = furnitureService.getFurnitureByName(furnitureName);
        System.out.println(taskService.activateTask(furniture));
    }

    public void go(String direction) {
        if (direction == null) {
            System.out.println("Go where?");
        } else {

            // Try to leave current room.
            Room room = roomService.goRoom(direction);

            if (room == null)
                System.out.println("There is no door!");
            else {
                System.out.println(roomService.getCurrentRoom().longDescription());
                String message = taskService.activateTask(room);
                if(message != null) {
                    System.out.println(message);
                }

            }
        }

    }

    public void open() {

    }

    public void map() {

        System.out.println("You are currently in: " + roomService.getCurrentRoom().getName());

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
