package de.anhquan.doit.todos.service;

import de.anhquan.doit.todos.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private List<Task> tasks;

    public TaskServiceImpl() {
        tasks = new ArrayList<>();
    }

    @Override
    public List<Task> getTasks() {
        return tasks;
    }

    @Override
    public void addTask(Task task) {
        tasks.add(task);
    }

    @Override
    public void removeTask(Task task) {
        tasks.removeIf(task1 -> task1.getId().equals(task.getId()));
    }

    @Override
    public Optional<Task> getTask(String id) {
        return tasks.stream().filter(task -> task.getId().equals(id)).findFirst();
    }
}
