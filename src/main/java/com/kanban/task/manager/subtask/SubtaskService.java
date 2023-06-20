package com.kanban.task.manager.subtask;

import com.kanban.task.manager.board.Subtask;

public interface SubtaskService {
    
    public Subtask getSubtaskById(int id);
    
    public void updateTask(SubtaskDTO subtask);

}
