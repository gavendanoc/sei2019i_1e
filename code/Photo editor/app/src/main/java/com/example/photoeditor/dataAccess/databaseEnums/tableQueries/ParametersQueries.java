package com.example.photoeditor.dataAccess.databaseEnums.tableQueries;

import com.example.photoeditor.dataAccess.databaseEnums.TableNames;
import com.example.photoeditor.dataAccess.databaseEnums.tableFields.ParametersFields;
import com.example.photoeditor.dataAccess.databaseEnums.tableFields.PermissionsFields;
import com.example.photoeditor.dataAccess.databaseEnums.tableFields.RolesFields;

public enum  ParametersQueries {


    SelectRoleFilters(
            "SelectRoleFilters",
            "SELECT " + TableNames.Parameters.getKey() + "." + ParametersFields.ID.getKey() + " , " + TableNames.Parameters.getKey() + "." + ParametersFields.NAME.getKey() + "  " +
                    "FROM " + TableNames.Parameters.getKey() + " JOIN " + TableNames.Permissions.getKey()  + "    " +
                    "ON " + TableNames.Parameters.getKey() + "." + ParametersFields.ID.getKey() + " = " + TableNames.Permissions.getKey() + "." + PermissionsFields.ID_PARAMETER.getKey() + "   " +
                    "WHERE " + PermissionsFields.ID_ROL.getKey() + " = %d AND " + TableNames.Permissions.getKey() + "." + PermissionsFields.STATUS +" = 1");

    private String type;
    private String query;

    private ParametersQueries(String type, String query){
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
