package com.kanban.task.manager.task;

import com.kanban.task.manager.board.Task;

public interface TaskService {
    
    public Task getTaskById(int id);
    
    public void updateTask(TaskDTO task);

}
