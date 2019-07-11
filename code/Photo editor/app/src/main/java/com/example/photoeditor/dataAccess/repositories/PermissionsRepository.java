package com.example.photoeditor.dataAccess.repositories;

import android.content.Context;

import com.example.photoeditor.bussinesLogic.controllers.PermissionsController;

public class PermissionsRepository {
    private Context context;

    public PermissionsRepository(Context context) {
        this.context = context;
    }

    public void getAllPermissions(PermissionsController permissionsController) {
    }
}