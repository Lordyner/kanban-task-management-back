package com.kanban.task.manager.board;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="subtask")
@JsonIgnoreProperties({ "task" })
public class Subtask implements Serializable {

 private static final long serialVersionUID = 7565354387195506544L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id; 
    
    @ManyToOne
    @JoinColumn(name = "id_task", nullable=false)
    private Task task;
    
    private String title;
    
    private boolean isCompleted;

    public int getId() {
        return id;
    }
    
    
    public Task getTask() {
        return task;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
}
