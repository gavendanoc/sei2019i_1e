package com.example.photoeditor.dataAccess.models;

public class UserModel {
    private int id;
    private String name;
    private String username;
    private String email;
    private String password;
    private int id_role;
    private int status;


    public UserModel() {
    }

    public UserModel(int id, String name, String username, String email, String password, int id_role, int status) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.id_role = id_role;
        this.status = status;
    }

    public UserModel(String name, String username, String email, String password, int id_role, int status) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.id_role = id_role;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId_role() {
        return id_role;
    }

    public void setId_role(int id_role) {
        this.id_role = id_role;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
