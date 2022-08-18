package com.example.demo;

import java.util.Date;

public class TodoBean {
    int id;
    String username;
    String name;
    Date targetDate;
    Boolean done;

    public TodoBean(int id, String username, String name,Date targetDate, Boolean done) {
        this.id = id;
        this.username=username;
        this.name = name;
        this.targetDate=targetDate;
        this.done = done;
    }
    public TodoBean(int id) {
        this.id = id;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public void setId(int id) {
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boolean getDone() {
        return done;
    }

    @Override
    public String toString() {
        return "TodoBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", done=" + done +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoBean todoBean = (TodoBean) o;
        return id == todoBean.id;
    }

}
