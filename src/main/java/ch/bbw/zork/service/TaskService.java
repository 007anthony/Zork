package ch.bbw.zork.service;

import ch.bbw.zork.model.Task;
import ch.bbw.zork.repository.TaskRepository;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.Optional;

public class TaskService {

    private TaskRepository taskRepository;

    public TaskService() {
        taskRepository = new TaskRepository();
    }

    public Task[] getAllTasks() {
        return taskRepository.getAllTasks();
    }

    public Task[] getActiveTasks() {
        return taskRepository.getActiveTasks()
                .toArray(Task[]::new);
    }

    public Task getNextTask() {
        Optional<Task> taskOptional = taskRepository.getNextTask();
        Task task = null;
        if(taskOptional.isPresent()) {
            task = taskOptional.get();
        }
        for(Task t : getActiveTasks()) {
            if(!task.getTask().equals(t.getTask())) {
                return task;
            }
        }
        return taskOptional.isPresent()? taskOptional.get(): null;
    }


    public Task[] getFinishedTasks() {
        return taskRepository.getFinishedTasks().toArray(Task[]::new);
    }

    public Task getCurrentTask() {
        Optional<Task> taskOptional = taskRepository.getCurrentTask();
        return taskOptional.isPresent()? taskOptional.get(): null;
    }

    public String activateTask(Object trigger) {
        Task nextTask = this.getNextTask();

        if(nextTask != null && nextTask.getTrigger().equals(trigger)) {

            if(this.getCurrentTask() != null) {
                getCurrentTask().setDone(true);
            }
            taskRepository.removeTask(nextTask);
            taskRepository.addTaskToActive(nextTask);
            return nextTask.getMessage() + "\n"
                    + "Task: " + nextTask.getTask();
        }





        return null;
    }


}
