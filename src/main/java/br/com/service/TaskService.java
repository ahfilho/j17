package br.com.service;


import br.com.entity.Task;
import br.com.repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Transactional
    public void save(Task task) {
    taskRepository.save(task);

    }

    public List<Task> listAll() {
        return taskRepository.findAll();
    }
}
