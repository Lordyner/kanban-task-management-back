package com.kanban.task.manager.task;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kanban.task.manager.board.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Integer> {

}
