package com.example.photoeditor.dataAccess.databaseEnums.TableFields;

public enum RequestFields {
    TYPE( "type");

    private String Key;
    private RequestFields( String Key){
        this.Key=Key;
    }

    public String getKey() {
        return Key;
    }

}
