package com.example.photoeditor.presentation.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.sip.SipSession;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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
        if(checkEmail(email.getText().toString()) && checkPassword(password.getText().toString())){
            userController.register(name.getText().toString(),username.getText().toString(),
                    email.getText().toString(),password.getText().toString());
        }else{
            if(!checkEmail(email.getText().toString())){
                Toast.makeText(this,"Debe ingresar un correo valido", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this,"Debe ingresar una contraseña valida", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void createdUser(boolean reg){
        if(reg){

            AlertDialog.Builder alerta = new AlertDialog.Builder(this);
            alerta.setMessage("Usuario creado satisfactoriamente")
                    .setNegativeButton("Aceptar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent back= new Intent(RegisterActivity.this, MainActivity.class);
                            startActivity(back);
                        }
                    })
                    .create()
                    .show();
        }
        else{
            AlertDialog.Builder alerta = new AlertDialog.Builder(this);
            alerta.setMessage("Usuario NO creado")
                    .setNegativeButton("Aceptar",null)
                    .create()
                    .show();
        }
    }

    public final static boolean checkEmail(String email){
        for(int i=0; i<email.length();i++){
            if(email.charAt(i)=='@'){
                return true;
            }
        }
        return false;
    }

    public final static boolean checkPassword(String password){
        if(password.length()>4){
            return true;
        }
        return false;
    }
}
