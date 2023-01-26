package ch.bbw.zork;

public class Task {

    private String task;
    private String message;
    private Trigger trigger;
    private boolean done;
    private Object triggerObject;

    public Task() {
        this(null, null, null);
    }

    public Task(String task, String message, Object triggerObject) {
        this.task = task;
        this.message = message;
        this.done = false;
        this.triggerObject = triggerObject;

        if(triggerObject instanceof Room) {
            trigger = Trigger.ROOM;
        }
        else if(triggerObject instanceof Item) {
            trigger = Trigger.ITEM;
        }
        else {
            throw new IllegalArgumentException("You provided a object from type " + triggerObject.getClass()
                    + "but the allowed types are Room and Item");
        }
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

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Trigger getTrigger() {
        return this.trigger;
    }

    public Object getTriggerObject() {
        return this.triggerObject;
    }

    public void setTriggerObject(Object triggerObject) {
        this.triggerObject = triggerObject;
    }
}
