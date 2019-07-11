package com.example.photoeditor.dataAccess.models;

public class PermissionsModel {
    private int id;
    private int idRol;
    private int idParameter;
    private int status;

    public PermissionsModel(int idRol, int idParameter, int status) {
        this.idRol = idRol;
        this.idParameter = idParameter;
        this.status = status;
    }

    public PermissionsModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public int getIdParameter() {
        return idParameter;
    }

    public void setIdParameter(int idParameter) {
        this.idParameter = idParameter;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
