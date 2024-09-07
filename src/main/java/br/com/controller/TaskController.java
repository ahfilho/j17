package br.com.controller;


import br.com.TaskDto;
import br.com.entity.Task;
import br.com.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;
    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/new")
    public ResponseEntity<String> save(@RequestBody TaskDto taskDto) {
        try {
            taskService.save(taskDto);
            return ResponseEntity.status(HttpStatus.CREATED).body("Tarefa criada com sucesso!");
        } catch (Exception e) {
            logger.error("Erro ao processaor a solicitação 'criar nova tarefa'." + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao processar solicitação.");
        }

    }

    @GetMapping("/list/all")
    public List<Task> listAll() {
        return taskService.listAll();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable String id, @RequestBody Task task) {
        try {
            Optional<Task> updatedTask = taskService.updateTask(task);
            if (updatedTask.isPresent()) {
                return ResponseEntity.ok().body("Task atualizada com sucesso.");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task não encontrada.");
            }
        } catch (Exception e) {
            logger.error("Erro durante a atualização da task: " + e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar.");
        }
    }

}
