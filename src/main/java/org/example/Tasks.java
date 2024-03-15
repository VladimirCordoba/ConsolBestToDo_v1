package org.example;



public class Tasks {
    public Tasks(String status, String task, String priority) {
        this.status = status;
        this.task = task;
        this.priority = priority;
    }

    public Tasks(String task) {
        this.task = task;
    }

    public Tasks(String id, String status, String task, String priority) {
        this.id = id;
        this.status = status;
        this.task = task;
        this.priority = priority;
    }

    public Tasks() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    private String id;

    private String task;
    private  String status;
    private String priority;


}
