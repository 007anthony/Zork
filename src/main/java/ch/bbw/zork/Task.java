package ch.bbw.zork;

public class Task {

    private String task;
    private Room startRoom;
    private boolean done;

    public Task() {
        this(null, null);
    }

    public Task(String task, Room startRoom) {
        this.task = task;
        this.startRoom = startRoom;
        this.done = false;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Room getStartRoom() {
        return startRoom;
    }

    public void setStartRoom(Room startRoom) {
        this.startRoom = startRoom;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
