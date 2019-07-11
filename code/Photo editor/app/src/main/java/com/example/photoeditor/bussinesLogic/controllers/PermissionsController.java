package com.example.photoeditor.bussinesLogic.controllers;

import android.content.Context;

import com.example.photoeditor.dataAccess.models.PermissionsModel;
import com.example.photoeditor.dataAccess.models.UserModel;
import com.example.photoeditor.dataAccess.models.pojos.PermissionsJoinModel;
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
    }

    public void retunOfPermissions(ArrayList<PermissionsJoinModel> permissionsList) {

    }

}
