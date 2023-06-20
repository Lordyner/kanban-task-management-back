package com.kanban.task.manager.mapper;

import org.mapstruct.Mapper;

import com.kanban.task.manager.board.Task;
import com.kanban.task.manager.task.TaskDTO;

@Mapper
public interface DTOToTaskMapper {
    
    Task DTOToTask(TaskDTO source);
    TaskDTO taskToDTO(Task destination);

}
