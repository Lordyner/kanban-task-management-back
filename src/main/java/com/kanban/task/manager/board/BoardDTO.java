package com.kanban.task.manager.board;

import java.util.List;

import com.kanban.task.manager.column.ColumnDTO;

public class BoardDTO {

    private int id;   
    private String name;
    private List<ColumnDTO> columns;
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public List<ColumnDTO> getColumns() {
        return columns;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setColumns(List<ColumnDTO> columns) {
        this.columns = columns;
    }   
}
