package com.example.photoeditor.dataAccess.models.pojos;

public class PermissionsJoinModel {

    private int id;
    private String roleType;
    private String parameterName;
    private int status;

    public PermissionsJoinModel(int id, String roleType, String parameterName, int status) {
        this.id = id;
        this.roleType = roleType;
        this.parameterName = parameterName;
        this.status = status;
    }


    public PermissionsJoinModel(String roleType, String parameterName, int status) {
        this.roleType = roleType;
        this.parameterName = parameterName;
        this.status = status;
    }

    public PermissionsJoinModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getroleType() {
        return roleType;
    }

    public void setroleType(String roleType) {
        this.roleType = roleType;
    }

    public String getparameterName() {
        return parameterName;
    }

    public void setparameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

