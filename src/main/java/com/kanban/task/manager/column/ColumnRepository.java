package com.kanban.task.manager.column;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.kanban.task.manager.board.Column;

public interface ColumnRepository extends CrudRepository<Column, Integer> {
    
    @Query(value = "SELECT * FROM boardcolumn"
                    + " WHERE id_board = :boardId", nativeQuery = true)
    Iterable<Column> findByBoardId(int boardId);
    

}
