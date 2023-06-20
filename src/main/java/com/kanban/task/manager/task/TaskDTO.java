package com.kanban.task.manager.task;

import java.util.List;

import com.kanban.task.manager.subtask.SubtaskDTO;

public class TaskDTO {
    
    private int id;
    
    private String title;
    
    private String description;

    private List<SubtaskDTO> subtasks;
    
    private String status;
    
    private int columnId;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<SubtaskDTO> getSubtasks() {
        return subtasks;
    }

    public String getStatus() {
        return status;
    }
    
    public int getColumnId() {
        return columnId;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSubtasks(List<SubtaskDTO> subtasks) {
        this.subtasks = subtasks;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setColumnId(int columnId) {
        this.columnId = columnId;
    }
    
}
