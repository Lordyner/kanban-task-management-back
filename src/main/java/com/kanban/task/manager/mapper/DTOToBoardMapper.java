package com.kanban.task.manager.mapper;

import org.mapstruct.Mapper;

import com.kanban.task.manager.board.Board;
import com.kanban.task.manager.board.BoardDTO;

@Mapper
public interface DTOToBoardMapper {
    
    Board DTOToBoard(BoardDTO source);
    BoardDTO boardToDTO(Board destination);

}
