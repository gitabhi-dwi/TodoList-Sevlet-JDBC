package com.todoList.dto;

import java.time.LocalDate;

public class todoList {
    private int index;
    private String task;
    private LocalDate duedate;
    private String tags;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public LocalDate getDuedate() {
        return duedate;
    }

    public void setDuedate(LocalDate duedate) {
        this.duedate = duedate;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public todoList() {
        // No-argument constructor
    }

    public todoList(int index, String task, LocalDate duedate, String tags) {
        this.index = index;
        this.task = task;
        this.duedate = duedate;
        this.tags = tags;
    }

    public todoList(String task, LocalDate duedate, String tags) {
        this.task = task;
        this.duedate = duedate;
        this.tags = tags;
    }
}
