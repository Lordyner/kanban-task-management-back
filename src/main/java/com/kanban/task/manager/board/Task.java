package com.kanban.task.manager.board;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="task")
@JsonIgnoreProperties({ "column" })
public class Task implements Serializable {

    private static final long serialVersionUID = 7565376387195506544L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id; 
    
    @ManyToOne
    @JoinColumn(name = "id_column", nullable=false)
    private Column column;
    
    private String title;
    
    // Task description
    private String description;
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy = "task", fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    @JsonIgnoreProperties
    private List<Subtask> subtasks;
    
    // Nom de la column dans lequel la tâche se trouve
    private String status;

    public int getId() {
        return id;
    }
    
    public String getTitle() {
        return title;
    }

    public Column getColumn() {
        return column;
    }

    public void setColumn(Column column) {
        this.column = column;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }
 

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    @JsonManagedReference
    public List<Subtask> getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(List<Subtask> subtasks) {
        this.subtasks = subtasks;
    }

    public void setId(int id) {
        this.id = id;
    }
            

}
