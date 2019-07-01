package com.example.photoeditor.dataAccess.databaseEnums.TableQueries;

public enum UserQueries {
    SelecByUsernameAndPassword("SelecByUsernameAndPassword");

    private String query;
    private UserQueries(String query){
        this.query=query;
    }

    public String getQuery(){
        return this.query;
    }

}
