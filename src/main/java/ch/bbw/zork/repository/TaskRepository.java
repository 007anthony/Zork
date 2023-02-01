package ch.bbw.zork.repository;

import ch.bbw.zork.model.Furniture;
import ch.bbw.zork.model.Task;
import ch.bbw.zork.TriggerType;
import ch.bbw.zork.service.CollectableService;
import ch.bbw.zork.service.FurnitureService;
import ch.bbw.zork.service.RoomService;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class TaskRepository {

    private Task[] tasks;

    public TaskRepository() {
        RoomService roomService = new RoomService();
        CollectableService collectableService = new CollectableService();
        FurnitureService furnitureService = new FurnitureService();
        Task task1 = new Task("Find a Cassette.", "There is a Cassette Recorder. I wish I had a Cassette.", roomService.getRoomByName("living room"));
        Task task2 = new Task("Pick up the cassette and enter it in the Cassette recorder", "Here on the Desk is a Cassette I wonder what I can find here", roomService.getRoomByName("office"));
        Task task3 = new Task("Use Cassette Recorder", null, collectableService.getCollectableByName("cassette"));
        Task task4 = new Task("Find the secret room", "To come out of the House find the secret room where the key for the front door is hidden", roomService.getRoomByName("living room"));
        Task task5 = new Task("Inspect Bookshelf", "This bookshelf looks suspicious.", roomService.getRoomByName("bedroom"));
        Task task6 = new Task("find entry to secret lab", "Why does the book looks out of the shelf.", furnitureService.getFurnitureByName("bookshelf") );
        Task task7 = new Task("take the key and unlock the door", "I have the key", collectableService.getCollectableByName("key"));

        tasks = new Task[]{task1, task2, task3, task4, task5, task6, task7};
    }


    public Task[] getAllTasks() {
        return tasks;
    }

    public Optional<Task> getNextTask() {
        return Arrays.stream(tasks)
                .filter(task -> !task.isActive())
                .findFirst();
    }

    public Stream<Task> getFinishedTasks() {
        return Arrays.stream(tasks)
                .filter(task -> task.isDone());
    }

    public Optional<Task> getCurrentTask() {
        return Arrays.stream(tasks)
                .filter(task -> task.isActive() && !task.isDone())
                .findFirst();
    }
}
