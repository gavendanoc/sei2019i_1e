package com.example.photoeditor.bussinesLogic.controllers;

import android.content.Context;

import com.example.photoeditor.dataAccess.models.UserModel;
import com.example.photoeditor.dataAccess.repositories.UserRepository;
import com.example.photoeditor.presentation.activities.MainActivity;


public class UserController {
    private Context context;


    public UserController(Context context) {
        this.context = context;
    }

    public void login (String username, String password){
        UserModel loginUser = new UserModel();
        loginUser.setUsername(username);
        loginUser.setPassword(password);

        UserRepository userRepository = new UserRepository(context);
        userRepository.getByUsernameAndPassword(loginUser, this);
    }

    public void loginLogic (UserModel user){
        MainActivity loginActivity =  (MainActivity) context;
        if (user != null){
            loginActivity.attemptLogin(user.getName(), true);
        } else {
            loginActivity.attemptLogin(null, false);
        }
    }
}
