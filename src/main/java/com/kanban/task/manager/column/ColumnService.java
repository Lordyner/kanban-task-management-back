package com.kanban.task.manager.column;

import java.util.List;

import com.kanban.task.manager.board.Column;

public interface ColumnService {
    
    Column getColumnById(int id);
    Iterable<Column> getColumnsByBoardId(int id);

    void updateColumns(List<Column> columns);

}
