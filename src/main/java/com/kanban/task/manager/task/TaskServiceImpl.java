package com.kanban.task.manager.task;

import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.kanban.task.manager.board.Column;
import com.kanban.task.manager.board.Task;
import com.kanban.task.manager.column.ColumnServiceImpl;
import com.kanban.task.manager.mapper.DTOToTaskMapper;

@Service
public class TaskServiceImpl implements TaskService {
    
    @Autowired
    private TaskRepository taskRepository;
    
    @Autowired 
    private ColumnServiceImpl columnService;
    
    private DTOToTaskMapper mapper = Mappers.getMapper(DTOToTaskMapper.class);

    @Override
    public Task getTaskById(int id) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isEmpty()) throw new EmptyResultDataAccessException(id);
        return task.get();
    }

    @Override
    public void updateTask(TaskDTO taskDTO) {
        // Retrieve the task in DB with the id passed by in parameter
        Optional<Task> fetchedTask = taskRepository.findById(taskDTO.getId());    
        // Check if task exists in DB
        if (fetchedTask.isEmpty()) throw new EmptyResultDataAccessException(taskDTO.getId());
        // Map DTO to a Task 
        Task task = mapper.DTOToTask(taskDTO);
        // Set task to every subtasks
        task.getSubtasks().forEach(subtask -> subtask.setTask(fetchedTask.get()));
        Column newColumn;
        if (taskDTO.getColumnId() != 0) newColumn = columnService.getColumnById(taskDTO.getColumnId());
        else newColumn = columnService.getColumnById(fetchedTask.get().getColumn().getId());
       
        // Set column to the task
        task.setColumn(newColumn);
        // Save task in DB
        taskRepository.save(task);     
    }

    
    
}
