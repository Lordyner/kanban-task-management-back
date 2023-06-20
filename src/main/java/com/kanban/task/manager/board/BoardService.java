package com.kanban.task.manager.board;

public interface BoardService {
    
    public Board getBoard(int id);
    public Iterable<Board> getBoards();

    public void updateBoard(BoardDTO boardDTO);

}
