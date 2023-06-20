package com.kanban.task.manager.column;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.kanban.task.manager.board.Board;
import com.kanban.task.manager.board.BoardService;
import com.kanban.task.manager.board.Column;

@Service
public class ColumnServiceImpl implements ColumnService {
    
    @Autowired
    @Lazy
    public BoardService boardService;

    @Autowired
    public ColumnRepository columnRepository;
    
    @Override
    public Column getColumnById(int id) {
        Optional<Column> column = columnRepository.findById(id);
        if (column.isEmpty()) throw new EmptyResultDataAccessException(id);
        return column.get();
    }
    
    @Override
    public Iterable<Column> getColumnsByBoardId(int id) {
        Board board = boardService.getBoard(id);
        return columnRepository.findByBoardId(board.getId());      
    }
      
    @Override
    public void updateColumns(List<Column> columns) {
       columnRepository.saveAll(columns);
        
    }
}
