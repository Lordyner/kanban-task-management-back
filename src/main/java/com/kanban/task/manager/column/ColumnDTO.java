package com.kanban.task.manager.column;

import com.kanban.task.manager.task.TaskDTO;

public class ColumnDTO {
    
    private String name;
    private TaskDTO task;
    public String getName() {
        return name;
    }
   
    public void setName(String name) {
        this.name = name;
    }

    public TaskDTO getTask() {
        return task;
    }

    public void setTask(TaskDTO task) {
        this.task = task;
    }
}
