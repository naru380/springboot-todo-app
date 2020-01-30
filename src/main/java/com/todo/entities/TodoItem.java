package com.todo.entities;

import javax.persistence.*;

@Entity
@Table(name = "todoitems")
public class TodoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "todoitems_id_seq")
    @SequenceGenerator(name = "todoitems_id_seq", sequenceName = "todoitems_id_seq", allocationSize=1)
    @Column(name="id")
    private Long id;
    @Column(name="title")
    private String title;
    @Column(name="done")
    private Boolean done;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}
