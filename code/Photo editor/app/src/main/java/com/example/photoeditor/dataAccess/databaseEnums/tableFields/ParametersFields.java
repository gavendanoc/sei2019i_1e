package com.example.photoeditor.dataAccess.databaseEnums.tableFields;

public enum ParametersFields {
    ID(0, "id"),
    NAME(1, "name"),
    STATUS(2, "status");


    private int position;
    private String Key;


    private ParametersFields(int position, String Key){
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
