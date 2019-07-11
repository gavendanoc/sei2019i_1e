package com.example.photoeditor.dataAccess.databaseEnums.tableQueries;

import com.example.photoeditor.dataAccess.databaseEnums.TableNames;
import com.example.photoeditor.dataAccess.databaseEnums.tableFields.UserFields;

public enum PermissionsQueries {

    SelectAllPermissions(
            "SelectAllPermissions",
            "SELECT* FROM " + TableNames.Permissions.getKey())
    ;

    private String type;
    private String query;

    private PermissionsQueries(String type, String query){
        this.type = type;
        this.query=query;
    }

    public String getFormat(Object []args ){
        return String.format(query , args);
    }
    public String getType(){
        return this.type;
    }
}
