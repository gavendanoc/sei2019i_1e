package com.example.photoeditor.presentation.activities.CardControl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Switch;
import android.widget.TextView;

import com.example.photoeditor.R;
import com.example.photoeditor.bussinesLogic.controllers.UserController;
import com.example.photoeditor.dataAccess.models.UserModel;

public class CardControlUser extends AppCompatActivity {
    private Switch payment;
    private TextView usuario;
    private UserModel user;
    private UserController userController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.payment = (Switch) findViewById(R.id.Payment);
        this.usuario= (TextView) findViewById(R.id.userTextF);
        user= new UserModel();
        user.setUsername(usuario.getText().toString());
        userController= new UserController(this);
    }

    public Switch getPayment() {
        return payment;
    }

    public void setPayment(Switch payment) {
        this.payment = payment;
    }

    public TextView getUsuario() {
        return usuario;
    }

    public void setUsuario(TextView usuario) {
        this.usuario = usuario;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public UserController getUserController() {
        return userController;
    }

    public void setUserController(UserController userController) {
        this.userController = userController;
    }
}
