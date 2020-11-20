package de.anhquan.doit.todos.service;

import de.anhquan.doit.todos.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<Task> getTasks();
    void addTask(Task task);
    void removeTask(Task task);
    Optional<Task> getTask(String id);
}
