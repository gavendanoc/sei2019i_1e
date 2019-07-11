package com.example.photoeditor.dataAccess.databaseEnums.tableQueries;

import com.example.photoeditor.dataAccess.databaseEnums.TableNames;
import com.example.photoeditor.dataAccess.databaseEnums.tableFields.ParametersFields;
import com.example.photoeditor.dataAccess.databaseEnums.tableFields.PermissionsFields;
import com.example.photoeditor.dataAccess.databaseEnums.tableFields.RolesFields;
import com.example.photoeditor.dataAccess.databaseEnums.tableFields.UserFields;

public enum PermissionsQueries {

    SelectAllPermissions(
            "SelectAllPermissions",
            "SELECT* FROM " + TableNames.Permissions.getKey()),

    SelectAllPermisionsWithJoin ("SelectAllPermisionsWithJoin",
            "SELECT " + TableNames.Permissions.getKey() + "." + PermissionsFields.ID.getKey() + ", " +
                    TableNames.Roles.getKey() + "." + RolesFields.TYPE.getKey() + ", " +
                    TableNames.Parameters.getKey() + "." + ParametersFields.NAME.getKey() + ", " +
                    TableNames.Permissions.getKey() + "." + PermissionsFields.STATUS.getKey() + ", " +
                    " FROM " +
                    TableNames.Permissions.getKey() +
                    " INNER JOIN PARAMETERS ON PERMISSIONS.id_parameter = PARAMETERS.id " +
                    " INNER JOIN ROLES ON PERMISSIONS.id_rol = ROLES.id"
    );

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
