package com.kanban.task.manager.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kanban.task.manager.task.TaskDTO;

@Controller
@RequestMapping(path="/boards")
public class BoardController {
    
    @Autowired
    private BoardService boardService;
    
    
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Board>> getBoards() {
        Iterable<Board> boards = boardService.getBoards();
        return ResponseEntity.ok(boards);   
    }
    
    @PatchMapping(path="/board")
    public @ResponseBody ResponseEntity<?> updateBoard(@RequestBody BoardDTO boardDTO) {      
        boardService.updateBoard(boardDTO);
        return ResponseEntity.noContent().build();
    }
 
}
