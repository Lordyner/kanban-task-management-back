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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="board")
public class Board implements Serializable {

    private static final long serialVersionUID = 7596376387197406734L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;   
    
    private String name;
    
    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    @JsonIgnoreProperties
    private List<Column> columns;
    

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }       
}
