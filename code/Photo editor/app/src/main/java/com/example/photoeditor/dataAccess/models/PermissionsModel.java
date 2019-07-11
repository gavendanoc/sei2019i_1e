package com.example.photoeditor.dataAccess.models;

public class PermissionsJoinModel {
    private int id;
    private String idRol;
    private String idParameter;
    private int status;

    public PermissionsJoinModel(int id, String idRol, String idParameter, int status) {
        this.id = id;
        this.idRol = idRol;
        this.idParameter = idParameter;
        this.status = status;
    }

    public PermissionsJoinModel() {
    }

    public PermissionsJoinModel(String idRol, String idParameter, int status) {
        this.idRol = idRol;
        this.idParameter = idParameter;
        this.status = status;
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
