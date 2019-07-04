package com.example.photoeditor.presentation.activities;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.photoeditor.R;
import com.example.photoeditor.bussinesLogic.controllers.UserController;

public class RegisterActivity extends AppCompatActivity {
    private EditText name;
    private EditText username;
    private EditText email;
    private EditText password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name=(EditText) findViewById(R.id.nameRegister);
        username=(EditText) findViewById(R.id.usernameRegister);
        email=(EditText) findViewById(R.id.emailRegister);
        password=(EditText) findViewById(R.id.passRegister);
    }

    public void RegisterButton(View view){
        UserController userController= new UserController(this);
        boolean reg= userController.register(name.getText().toString(),username.getText().toString(),
                email.getText().toString(),password.getText().toString());
        if(reg){
            AlertDialog.Builder alerta = new AlertDialog.Builder(this);
            alerta.setMessage("Usuario creado satisfactoriamente")
                    .setNegativeButton("Aceptar",null)
                    .create()
                    .show();
            this.finish();
        }
        else{
            AlertDialog.Builder alerta = new AlertDialog.Builder(this);
            alerta.setMessage("Usuario NO creado")
                    .setNegativeButton("Aceptar",null)
                    .create()
                    .show();
        }
    }
}
