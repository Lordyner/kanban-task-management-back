package com.kanban.task.manager.mapper;

import org.mapstruct.Mapper;

import com.kanban.task.manager.board.Subtask;
import com.kanban.task.manager.subtask.SubtaskDTO;

@Mapper
public interface DTOToSubtaskMapper {
	
	Subtask DTOToSubtask(SubtaskDTO source);
    SubtaskDTO goalToDTO(Subtask destination);

}
