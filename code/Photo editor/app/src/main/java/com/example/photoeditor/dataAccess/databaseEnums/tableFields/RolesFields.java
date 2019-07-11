package com.example.photoeditor.dataAccess.databaseEnums.tableFields;

public enum RolesFields {

    ID(0, "id"),
    TYPE(1, "type"),
    STATUS(2, "status");

    private int position;
    private String Key;


    private RolesFields(int position, String Key){
        this.position=position;
        this.Key=Key;
    }

    public int getPosition() {
        return position;
    }

    public String getKey() {
        return Key;
    }
}
