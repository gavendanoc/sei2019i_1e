package com.example.photoeditor.presentation.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.AbsListView;
import android.widget.ListAdapter;

import com.example.photoeditor.R;
import com.example.photoeditor.bussinesLogic.controllers.UserController;
import com.example.photoeditor.dataAccess.models.UserModel;
import com.example.photoeditor.dataAccess.requests.UserAdapter;

import java.util.ArrayList;

public class RolesDisplayActivity extends AppCompatActivity {
    private RecyclerView userList;
    private ArrayList<UserModel> userModels;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        UserController userController= new UserController(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roles_display);
        userList= (RecyclerView) findViewById(R.id.UserList);
        userList.setLayoutManager(
                new LinearLayoutManager(
                        this,LinearLayoutManager.VERTICAL,false));
        userModels=userController.userList();
        UserAdapter adapter= new UserAdapter(userModels);
        userList.setAdapter(adapter);
        System.out.println("WORKS LAYOUT");
    }

}
