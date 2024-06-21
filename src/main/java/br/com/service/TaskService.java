package br.com.service;


import br.com.entity.Task;
import br.com.repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

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
}
