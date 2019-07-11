package com.example.photoeditor.dataAccess.databaseEnums.tableQueries;

import com.example.photoeditor.dataAccess.databaseEnums.tableFields.UserFields;
import com.example.photoeditor.dataAccess.databaseEnums.TableNames;

public enum UserQueries {
    SelecByUsernameAndPassword(
            "SelecByUsernameAndPassword",
            "SELECT* FROM " + TableNames.Users.getKey() + " WHERE " +
                    UserFields.USERNAME.getKey() + " = '%s' AND " +
                    UserFields.PASSWORD.getKey() + " = '%s'"),
    InsertUser(
            "insertUser", "INSERT INTO " +TableNames.Users.getKey()+
            " (name,username,email,password,id_role,status) VALUES ('%s','%s','%s','%s',3,1)"),

    GetUsers("getUsers", "SELECT* FROM "+ TableNames.Users.getKey()),
    UpdateUsers("updateUsers", "UPDATE "+TableNames.Users.getKey()+" SET "+UserFields.ID_ROL.getKey()+"= %d WHERE" +
            UserFields.USERNAME.getKey()+"= '%s'")
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
