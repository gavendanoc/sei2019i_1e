package com.example.photoeditor.dataAccess.databaseEnums;

public enum Tables {
    Users("Users"),
    Rols("Rols"),
    Parameters("Parameters"),
    Permissions("Permissions");

    private String name;

    Tables(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
