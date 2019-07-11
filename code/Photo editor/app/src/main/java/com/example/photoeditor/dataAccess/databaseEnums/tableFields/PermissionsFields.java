package com.example.photoeditor.dataAccess.databaseEnums.tableFields;

public enum PermissionsFields {

    ID(0, "id"),
    ID_ROL(1, "id_rol"),
    ID_PARAMETER(2,"id_parameter"),
    STATUS(3, "status");


    private int position;
    private String Key;
    private PermissionsFields(int position, String Key){
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
