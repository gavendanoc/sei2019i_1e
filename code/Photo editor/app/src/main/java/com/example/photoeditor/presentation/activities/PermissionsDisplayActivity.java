package com.example.photoeditor.presentation.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.photoeditor.R;
import com.example.photoeditor.bussinesLogic.controllers.PermissionsController;
import com.example.photoeditor.bussinesLogic.controllers.UserController;
import com.example.photoeditor.dataAccess.models.PermissionsModel;
import com.example.photoeditor.dataAccess.models.UserModel;
import com.example.photoeditor.dataAccess.models.pojos.PermissionsCardModel;

import java.util.ArrayList;


public class PermissionsDisplayActivity extends AppCompatActivity {

    private RecyclerView permissionsList;
    private ArrayList<PermissionsCardModel> permissionsModels;

    public  void setPermissionsModels(ArrayList<PermissionsCardModel> permissionsModels) {
        this.permissionsModels = permissionsModels;
    }

    public ArrayList<PermissionsCardModel> getPermissionsModels() {
        return permissionsModels;
    }



    public RecyclerView getPermissionsList() {
        return permissionsList;
    }

    public void setPermissionsList(RecyclerView permissionsList) {
        this.permissionsList = permissionsList;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        PermissionsController permissionsController= new PermissionsController(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permissions_display);

        permissionsList= (RecyclerView) findViewById(R.id.PermissionsList);
        permissionsList.setLayoutManager(
                new LinearLayoutManager(
                        this,LinearLayoutManager.VERTICAL,false));
        permissionsController.permissionsList();

    }



}
