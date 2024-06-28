package br.com.controller;


import br.com.TaskDto;
import br.com.entity.Task;
import br.com.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

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
            ModelMapper mp = new ModelMapper();
            Task task = mp.map(taskDto, Task.class);
            taskService.save(task);
           return ResponseEntity.status(HttpStatus.CREATED).body("Tarefa criada com sucesso!");
        } catch (Exception e) {
            logger.error("Erro ao processaor a solicitação 'criar nova tarefa'."+e.getMessage());
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao processar solicitação.");
        }

    }
    @GetMapping("/list/all")
    public List<Task> listAll(){
        return taskService.listAll();
    }


}
