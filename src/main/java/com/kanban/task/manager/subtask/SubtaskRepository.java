package com.kanban.task.manager.subtask;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kanban.task.manager.board.Subtask;

@Repository
public interface SubtaskRepository extends CrudRepository<Subtask, Integer> {

}
