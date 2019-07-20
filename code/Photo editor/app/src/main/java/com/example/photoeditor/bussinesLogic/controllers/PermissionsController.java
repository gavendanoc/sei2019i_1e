package com.example.photoeditor.bussinesLogic.controllers;

import android.content.Context;

import com.example.photoeditor.dataAccess.models.pojos.PermissionsJoinModel;
import com.example.photoeditor.dataAccess.repositories.PermissionsRepository;
import com.example.photoeditor.presentation.activities.Adapters.PermissionsAdapter;
import com.example.photoeditor.presentation.activities.PermissionsDisplayActivity;

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
        System.out.println("aca imrpime el primero de la consulta retunOfPermissions");
        System.out.println(permissions.get(0).getId()+" OUTSIDE "+permissions.get(0).getStatus());
        PermissionsDisplayActivity permissionsDisplayActivity= (PermissionsDisplayActivity) context;
        permissionsDisplayActivity.setPermissionsModels(this.permissions);
        PermissionsAdapter permissionsAdapter = new PermissionsAdapter(permissionsDisplayActivity.getPermissionsModels(), context);
        permissionsDisplayActivity.getPermissionsList().setAdapter(permissionsAdapter);
    }

}
