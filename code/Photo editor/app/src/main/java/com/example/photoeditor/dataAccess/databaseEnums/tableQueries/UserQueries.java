package com.example.photoeditor.dataAccess.databaseEnums.tableQueries;

import com.example.photoeditor.dataAccess.databaseEnums.tableFields.UserFields;
import com.example.photoeditor.dataAccess.databaseEnums.TableNames;

public enum UserQueries {
    SelecByUsernameAndPassword(
            "SelecByUsernameAndPassword",
            "SELECT* FROM " + TableNames.Users.getKey() + " WHERE " +
                    UserFields.USERNAME.getKey() + " = '%s' AND " +
                    UserFields.PASSWORD.getKey() + " = '%s'"),
    insertUser(
            "", "INSERT INTO " +TableNames.Users.getKey() + "VALUES (" +101+
            ",'%s','%s','%s','%s', "+ 123+", "+1+")")

    ;

    private String type;
    private String query;

    private UserQueries(String type, String query){
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
