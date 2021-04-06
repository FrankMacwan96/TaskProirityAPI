package com.frank.project.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;



@Entity
@Table(name="Task")
public class Task {

    @Id
    private Long id;

    @Column(name = "description")
    @NotNull (message = "Description Can not be empty")
    private String descrption;

    @Column(name = "priority")
    private long priority;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescrption() {
        return descrption;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }

    public long getPriority() {
        return priority;
    }

    public void setPriority(long priority) {
        this.priority = priority;
    }
}
