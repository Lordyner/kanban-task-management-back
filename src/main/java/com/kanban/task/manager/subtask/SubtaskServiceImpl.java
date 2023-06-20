package com.kanban.task.manager.subtask;

import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.kanban.task.manager.board.Subtask;
import com.kanban.task.manager.mapper.DTOToSubtaskMapper;

@Service
public class SubtaskServiceImpl implements SubtaskService {
    
    @Autowired
    public SubtaskRepository subtaskRepository;
    
    private DTOToSubtaskMapper mapper = Mappers.getMapper(DTOToSubtaskMapper.class);
    
    @Override
    public Subtask getSubtaskById(int id) {
        Optional<Subtask> subtask = subtaskRepository.findById(id);
        return subtask.isPresent() ? subtask.get() : null;
    }

    @Override
    public void updateTask(SubtaskDTO subtaskDTO) {
        Optional<Subtask> fetchedSubtask = subtaskRepository.findById(subtaskDTO.getId());  
        if (fetchedSubtask.isEmpty()) throw new EmptyResultDataAccessException(subtaskDTO.getId());
        
        Subtask subtask = mapper.DTOToSubtask(subtaskDTO);
        subtaskRepository.save(subtask);
    }

    
}
