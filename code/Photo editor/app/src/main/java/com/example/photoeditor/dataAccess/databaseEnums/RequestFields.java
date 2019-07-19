package com.example.photoeditor.dataAccess.databaseEnums;

public enum RequestFields {
    TYPE( "type"),
    QUERY("query");

    private String Key;
    private RequestFields( String Key){
        this.Key=Key;
    }

    public String getKey() {
        return Key;
    }

}
