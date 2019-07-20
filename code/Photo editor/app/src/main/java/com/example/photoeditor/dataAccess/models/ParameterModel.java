package com.example.photoeditor.dataAccess.models;

public class ParameterModel {
    private int id;
    private String name;
    private int status;

    public ParameterModel(int id, String name, int status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }


    public ParameterModel(String name, int status) {
        this.name = name;
        this.status = status;
    }


    public ParameterModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
