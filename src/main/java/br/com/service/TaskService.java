package br.com.service;


import br.com.TaskDto;
import br.com.entity.Task;
import br.com.repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        logger.info("task: {}", task);
        taskRepository.save(task);

    }

    public List<Task> listAll() {
        return taskRepository.findAll();
    }


    @Transactional
    public Optional<Task> updateTask(Task updatedTask) {
        Optional<Task> existingTaskOpt = taskRepository.findById(updatedTask.getId());
        if (existingTaskOpt.isPresent()) {
            Task existingTask = existingTaskOpt.get();
            existingTask.setName(updatedTask.getName());
            existingTask.setStatus(updatedTask.getStatus());
            existingTask.setDayOfTask(updatedTask.getDayOfTask());
            existingTask.setNotification(updatedTask.isNotification());
            existingTask.setPriority(updatedTask.getPriority());
            existingTask.setSubject(updatedTask.getSubject());

            taskRepository.save(existingTask);
            return Optional.of(existingTask);
        } else {
            return Optional.empty();
        }
    }
}
