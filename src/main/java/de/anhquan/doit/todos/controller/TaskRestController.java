package de.anhquan.doit.todos.controller;

import de.anhquan.doit.todos.exception.TaskNotFoundException;
import de.anhquan.doit.todos.model.Task;
import de.anhquan.doit.todos.service.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController(value = "/")
public class TaskRestController {

    private TaskServiceImpl taskService;

    @Autowired
    public TaskRestController(final TaskServiceImpl taskService){
        this.taskService = taskService;
    }

    @GetMapping(path = "/public/tasks")
    public ResponseEntity<List<Task>> getTasks(){
        return ResponseEntity.ok(taskService.getTasks());
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable String id) throws TaskNotFoundException {
        Optional<Task> foundTask = taskService.getTask(id);
        if (foundTask.isPresent()){
            return ResponseEntity.ok(foundTask.get());
        }
        throw new TaskNotFoundException();
    }
}
