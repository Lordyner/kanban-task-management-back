package com.kanban.task.manager.board;

import java.util.Optional;
import java.util.stream.Collectors;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.kanban.task.manager.column.ColumnService;
import com.kanban.task.manager.mapper.DTOToBoardMapper;
import com.kanban.task.manager.task.TaskDTO;
import com.kanban.task.manager.task.TaskService;

@Service
public class BoardServiceImpl implements BoardService {
    
    @Autowired
    private BoardRepository boardRepository;
    
    @Autowired
    @Lazy
    private ColumnService columnService;
    
    @Autowired
    @Lazy
    private TaskService taskService;
    
    private DTOToBoardMapper mapper = Mappers.getMapper(DTOToBoardMapper.class);

    
    @Override
    public Board getBoard(int id) {
        Optional<Board> result = boardRepository.findById(id);
        if (result.isEmpty()) throw new EmptyResultDataAccessException(id);
        return result.get();
    }


    @Override
    public Iterable<Board> getBoards() {
        return boardRepository.findAll();
    }


    @Override
    public void updateBoard(BoardDTO boardDTO) {
        Optional<Board> fetchedBoard = boardRepository.findById(boardDTO.getId());
        if (fetchedBoard.isEmpty()) throw new EmptyResultDataAccessException(boardDTO.getId());
      
        Board board = mapper.DTOToBoard(boardDTO);
        
        boardRepository.save(board);
//        columnService.updateColumns(board.getColumns());
        TaskDTO taskToUpdate = boardDTO.getColumns()
                .stream()
                .filter(column -> column.getTask() != null)
                .collect(Collectors.toList()).get(0).getTask();
        taskService.updateTask(taskToUpdate);

        
    }
    
 
    
    
}
