package com.example.photoeditor.bussinesLogic.controllers;

import android.content.Context;
import android.widget.Toast;

import com.example.photoeditor.dataAccess.models.pojos.PermissionsJoinModel;
import com.example.photoeditor.dataAccess.repositories.PermissionsRepository;
import com.example.photoeditor.dataAccess.repositories.UserRepository;
import com.example.photoeditor.presentation.activities.Adapters.PermissionsAdapter;
import com.example.photoeditor.presentation.activities.PermissionsDisplayActivity;
import com.example.photoeditor.presentation.activities.RolesDisplayActivity;

import java.util.ArrayList;

public class PermissionsController {

    private Context context;
    private ArrayList<PermissionsJoinModel> permissions;


    public PermissionsController(Context context) {
        this.context = context;
    }

    public void permissionsList(){
        PermissionsRepository permissionsRepository= new PermissionsRepository(context);
        permissionsRepository.getAllPermissions(this);
    }

    public void retunOfPermissions(ArrayList<PermissionsJoinModel> permissionsList) {
        this.permissions = permissionsList;
        PermissionsDisplayActivity permissionsDisplayActivity= (PermissionsDisplayActivity) context;
        permissionsDisplayActivity.setPermissionsModels(this.permissions);
        PermissionsAdapter permissionsAdapter = new PermissionsAdapter(permissionsDisplayActivity.getPermissionsModels(), context);
        permissionsDisplayActivity.getPermissionsList().setAdapter(permissionsAdapter);
    }
    //status, id
    public void updatePermissions(int status, int id){
        PermissionsRepository permissionsRepository= new PermissionsRepository(context);
        permissionsRepository.updatePermissions(status,id,this);
    }

    public void returnUpdate(boolean success) {
        PermissionsDisplayActivity permissionsDisplayActivity = (PermissionsDisplayActivity) context;
        if (success) {
            Toast.makeText(permissionsDisplayActivity, "Actualizado", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(permissionsDisplayActivity, "NO Actualizado", Toast.LENGTH_LONG).show();
        }
    }


}
