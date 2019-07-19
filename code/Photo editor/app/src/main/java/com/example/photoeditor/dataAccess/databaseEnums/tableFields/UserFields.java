package com.example.photoeditor.dataAccess.databaseEnums.tableFields;

public enum UserFields {
    ID(0, "id"),
    NAME(1, "name"),
    USERNAME(2,"username"),
    EMAIL(3, "email"),
    PASSWORD(4, "password"),
    ID_ROL(5, "id_role"),
    STATUS(6, "status");

    private int position;
    private String Key;
    private UserFields(int position, String Key){
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
