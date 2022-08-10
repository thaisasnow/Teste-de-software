package br.com.senac.todo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ToDo {

    @Id
    @GeneratedValue
    private long id;
    private String description;
    @Column(columnDefinition = "boolean default false")
    private boolean completed;

    // construtores
    public ToDo() {

    }

    public ToDo(String description, boolean completed) {
        this.description = description;
        this.completed = completed;
    }

    public ToDo(long id, String description, boolean completed) {
        this.id = id;
        this.description = description;
        this.completed = completed;
    }

    // encapsulamento
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}