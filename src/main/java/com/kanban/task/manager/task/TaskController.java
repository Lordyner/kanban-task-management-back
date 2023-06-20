package com.kanban.task.manager.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kanban.task.manager.board.Task;

@Controller
@RequestMapping(path="/tasks")
public class TaskController {
    
    @Autowired
    private TaskServiceImpl taskService;
    
    public ResponseEntity<Task> getTask(@PathVariable int id) {   
        Task task = taskService.getTaskById(id);
        return ResponseEntity.ok(task);   
    }
    
    @PatchMapping(path="/task")
    public @ResponseBody ResponseEntity<?> updateTask(@RequestBody TaskDTO taskDTO) {      
        taskService.updateTask(taskDTO);
        return ResponseEntity.noContent().build();
    }
}
