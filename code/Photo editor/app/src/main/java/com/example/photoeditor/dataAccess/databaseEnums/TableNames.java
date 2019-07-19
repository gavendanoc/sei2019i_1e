package com.example.photoeditor.dataAccess.databaseEnums;

public enum TableNames {
    Users("USERS"),
    Roles("ROLES"),
    Parameters("PARAMETERS"),
    Permissions("PERMISSIONS");

    private String key;

    TableNames(String name) {
        this.key = name;
    }

    public String getKey() {
        return key;
    }
}
