package com.example.photoeditor.bussinesLogic.controllers;

import android.content.Context;
import android.widget.Toast;

import com.example.photoeditor.dataAccess.models.UserModel;
import com.example.photoeditor.dataAccess.repositories.UserRepository;
import com.example.photoeditor.dataAccess.requests.UserAdapter;
import com.example.photoeditor.presentation.activities.MainActivity;
import com.example.photoeditor.presentation.activities.RegisterActivity;
import com.example.photoeditor.presentation.activities.RolesDisplayActivity;

import java.util.ArrayList;


public class UserController {
    private Context context;
    private ArrayList<UserModel> users;

    public UserController(Context context) {
        this.context = context;
        users= new ArrayList<>();
    }

    public void login (String username, String password){
        UserModel loginUser = new UserModel();
        loginUser.setUsername(username);
        loginUser.setPassword(password);

        UserRepository userRepository = new UserRepository(context);
        userRepository.getByUsernameAndPassword(loginUser, this);
    }

    public void register(String name,String username, String email, String password) {
        UserModel user=new UserModel();
        user.setName(name);
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        UserRepository userRepo= new UserRepository(context);
        userRepo.insertUser(user,this);
    }
    public void regSuccess(boolean r){
        RegisterActivity registerRet=  (RegisterActivity) context;
        registerRet.createdUser(r);
    }
    public void loginLogic (UserModel user){
        MainActivity loginActivity =  (MainActivity) context;
        if (user != null){
            loginActivity.attemptLogin(user.getName(), true);
        } else {
            loginActivity.attemptLogin(null, false);
        }
    }
    public void userList(){
        UserRepository userRepository= new UserRepository(context);
        userRepository.getAllUsers(this);
    }

    public void retunOfUsers(ArrayList<UserModel> userList) {
        this.users=userList;
        System.out.println(users.get(0).getUsername()+" OUTSIDE "+users.get(0).getPassword());
        RolesDisplayActivity rolesDisplayActivity= (RolesDisplayActivity) context;
        rolesDisplayActivity.setUserModels(this.users);
        UserAdapter userAdapter= new UserAdapter(rolesDisplayActivity.getUserModels(),context);
        rolesDisplayActivity.getUserList().setAdapter(userAdapter);
    }
    public void updateUser(int role, String username){
        UserRepository userRepository= new UserRepository(context);
        userRepository.updateUser(role,username,this);
    }

    public void returnUpdate(boolean success) {
        RolesDisplayActivity rolesDisplayActivity = (RolesDisplayActivity) context;
        if (success) {
            Toast.makeText(rolesDisplayActivity, "Actualizado", Toast.LENGTH_LONG);
        }
        else{
            Toast.makeText(rolesDisplayActivity, "NO Actualizado", Toast.LENGTH_LONG);
        }
    }
}
