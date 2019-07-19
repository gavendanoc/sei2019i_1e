package com.example.photoeditor.dataAccess.models;

public class RoleModel {
    private int id;
    private String type;
    private int status;

    public RoleModel(){

    }

    public RoleModel(int id, String type, int status) {
        this.id = id;
        this.type = type;
        this.status = status;
    }

    public RoleModel(String type, int status) {
        this.type = type;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
