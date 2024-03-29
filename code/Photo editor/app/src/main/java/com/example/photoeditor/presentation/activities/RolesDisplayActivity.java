package com.example.photoeditor.presentation.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.photoeditor.R;
import com.example.photoeditor.bussinesLogic.controllers.UserController;
import com.example.photoeditor.dataAccess.models.UserModel;

import java.util.ArrayList;

public class RolesDisplayActivity extends AppCompatActivity {
    private RecyclerView userList;
    private ArrayList<UserModel> userModels;

    public ArrayList<UserModel> getUserModels() {
        return userModels;
    }

    public void setUserModels(ArrayList<UserModel> userModels) {
        this.userModels = userModels;
    }

    public RecyclerView getUserList() {
        return userList;
    }

    public void setUserList(RecyclerView userList) {
        this.userList = userList;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        UserController userController= new UserController(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roles_display);
        userList= (RecyclerView) findViewById(R.id.UserList);
        userList.setLayoutManager(
                new LinearLayoutManager(
                        this,LinearLayoutManager.VERTICAL,false));
        userController.userList();
    }


}
