package com.kanban.task.manager.subtask;

public class SubtaskDTO {
    
    private int id;
    private String title;   
    private boolean isCompleted;
    
    public String getTitle() {
        return title;
    }
    public boolean isCompleted() {
        return isCompleted;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }
    public int getId() {
        return id;
    }

}
