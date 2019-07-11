package com.example.photoeditor.bussinesLogic.controllers;

import android.content.Context;

import com.example.photoeditor.dataAccess.models.PermissionsModel;
import com.example.photoeditor.dataAccess.models.UserModel;
import com.example.photoeditor.dataAccess.repositories.UserRepository;
import com.example.photoeditor.dataAccess.requests.UserAdapter;
import com.example.photoeditor.presentation.activities.RolesDisplayActivity;

import java.util.ArrayList;

public class PermissionsController {

    private Context context;
    private ArrayList<PermissionsModel> permissions;


    public PermissionsController(Context context) {
        this.context = context;
    }

    public void permissionsList(){
        UserRepository userRepository= new UserRepository(context);
        userRepository.getAllUsers(this);
    }

    public void retunOfPermissions(ArrayList<UserModel> permissionsList) {
        this.permissions = permissionsList;
        RolesDisplayActivity rolesDisplayActivity= (RolesDisplayActivity) context;
        rolesDisplayActivity.setUserModels(this.users);
        UserAdapter userAdapter= new UserAdapter(rolesDisplayActivity.getUserModels());
        rolesDisplayActivity.getUserList().setAdapter(userAdapter);
    }

}
