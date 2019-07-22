package com.example.photoeditor.dataAccess.models.pojos;

public class PermissionsCardModel {
    private int idPermissionsRegularUser;
    private int idPermissionsPaidUser;
    private int statusPermissionsPaidUser;
    private int statusPermissionsRegularUser;
    private String nameParameter;

    public PermissionsCardModel(int idPermissionsRegularUser, int statusPermissionsRegularUser, int idPermissionsPaidUser, int statusPermissionsPaidUser, String nameParameter) {
        this.idPermissionsRegularUser = idPermissionsRegularUser;
        this.idPermissionsPaidUser = idPermissionsPaidUser;
        this.statusPermissionsPaidUser = statusPermissionsPaidUser;
        this.statusPermissionsRegularUser = statusPermissionsRegularUser;
        this.nameParameter = nameParameter;
    }

    public PermissionsCardModel() {
    }

    public int getIdPermissionsRegularUser() {
        return idPermissionsRegularUser;
    }

    public void setIdPermissionsRegularUser(int idPermissionsRegularUser) {
        this.idPermissionsRegularUser = idPermissionsRegularUser;
    }

    public int getIdPermissionsPaidUser() {
        return idPermissionsPaidUser;
    }

    public void setIdPermissionsPaidUser(int idPermissionsPaidUser) {
        this.idPermissionsPaidUser = idPermissionsPaidUser;
    }

    public int getStatusPermissionsPaidUser() {
        return statusPermissionsPaidUser;
    }

    public void setStatusPermissionsPaidUser(int statusPermissionsPaidUser) {
        this.statusPermissionsPaidUser = statusPermissionsPaidUser;
    }

    public int getStatusPermissionsRegularUser() {
        return statusPermissionsRegularUser;
    }

    public void setStatusPermissionsRegularUser(int statusPermissionsRegularUser) {
        this.statusPermissionsRegularUser = statusPermissionsRegularUser;
    }

    public String getNameParameter() {
        return nameParameter;
    }

    public void setNameParameter(String nameParameter) {
        this.nameParameter = nameParameter;
    }
}
