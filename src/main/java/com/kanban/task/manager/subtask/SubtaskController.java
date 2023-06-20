package com.kanban.task.manager.subtask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kanban.task.manager.board.Subtask;

@Controller
@RequestMapping(path="/subtasks")
public class SubtaskController {
    
    @Autowired
    private SubtaskServiceImpl subtaskService;
    
    public ResponseEntity<Subtask> getSubtask(@PathVariable int id) {   
        Subtask subtask = subtaskService.getSubtaskById(id);
        return ResponseEntity.ok(subtask);
    }
    
    @PatchMapping(path="/subtask")
    public @ResponseBody ResponseEntity<?> updateSubtask(@RequestBody SubtaskDTO subtask) {
        
        subtaskService.updateTask(subtask);
        return ResponseEntity.noContent().build();
    }

}
