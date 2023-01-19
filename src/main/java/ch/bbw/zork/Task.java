package ch.bbw.zork;

public class Task {

    private String task;
    private Trigger trigger;
    private boolean done;

    public Task() {
        this(null, Trigger.ROOM);
    }

    public Task(String task, Trigger trigger) {
        this.task = task;
        this.done = false;
        this.trigger = trigger;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Trigger getTrigger() {
        return this.trigger;
    }
}
