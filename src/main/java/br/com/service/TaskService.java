package br.com.service;


import br.com.TaskDto;
import br.com.entity.Task;
import br.com.repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.nio.file.LinkOption;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private static final Logger logger = LoggerFactory.getLogger(TaskService.class);

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Transactional
    public void save(TaskDto taskDto) {
        ModelMapper mp = new ModelMapper();
        logger.info("TaskDto: {}", taskDto);
        Task task = mp.map(taskDto, Task.class);
        logger.info("task: {}",task);
        taskRepository.save(task);

    }

    public List<Task> listAll() {
        return taskRepository.findAll();
    }
}
