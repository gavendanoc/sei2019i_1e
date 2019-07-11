package com.example.photoeditor.dataAccess.models;

public class PermissionsModel {
    private int id;
    private int idRol;
    private int idParameter;
    private int status;

    public PermissionsModel(String idRol, String idParameter, int status) {
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

    public String getIdRol() {
        return idRol;
    }

    public void setIdRol(String idRol) {
        this.idRol = idRol;
    }

    public String getIdParameter() {
        return idParameter;
    }

    public void setIdParameter(String idParameter) {
        this.idParameter = idParameter;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
