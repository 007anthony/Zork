package ch.bbw.zork.service;

import ch.bbw.zork.model.Task;
import ch.bbw.zork.repository.TaskRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public class TaskService {

    private TaskRepository taskRepository;

    public TaskService() {
        taskRepository = new TaskRepository();
    }

    public Task[] getAllTasks() {
        return taskRepository.getAllTasks();
    }

    public Task getNextTask() {
        Optional<Task> taskOptional = taskRepository.getNextTask();
        return taskOptional.isPresent()? taskOptional.get(): null;
    }


    public Task[] getFinishedTasks() {
        return taskRepository.getFinishedTasks().toArray(Task[]::new);
    }

    public Task getCurrentTask() {
        Optional<Task> taskOptional = taskRepository.getCurrentTask();
        return taskOptional.isPresent()? taskOptional.get(): null;
    }

    public void activateTask() {
        Task nextTask = this.getNextTask();

        if(this.getCurrentTask() == null) {
            nextTask.setActive(true);
        }
    }


}
