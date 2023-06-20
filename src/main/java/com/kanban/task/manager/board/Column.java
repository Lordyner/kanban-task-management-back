package com.kanban.task.manager.board;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table(name="boardcolumn")
@JsonIgnoreProperties({ "board" })
public class Column implements Serializable {
    
    private static final long serialVersionUID = 7565376387195506734L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id; 
    
    @ManyToOne
    @JoinColumn(name = "id_board", nullable=false)
    private Board board;
    
    private String name;
    
    @OneToMany(mappedBy = "column", fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    private List<Task> tasks;

    public int getId() {
        return id;
    }
       
    public Board getBoard() {
        return board;
    }

    public String getName() {
        return name;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
    
    
    
    
    

}
