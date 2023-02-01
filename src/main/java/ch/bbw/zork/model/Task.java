package ch.bbw.zork.model;

public class Task {

    private String task;
    private String message;
    private Object trigger;

    private boolean isActive;
    private boolean done;

    public Task() {
        this(null, null, null);
    }

    public Task(String task, String message, Object trigger) {
        this.task = task;
        this.message = message;
        this.trigger = trigger;
        this.done = false;
        this.isActive = false;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Object getTrigger() {
        return this.trigger;
    }

    public void setTrigger(Object trigger) {
        this.trigger = trigger;
    }
}
