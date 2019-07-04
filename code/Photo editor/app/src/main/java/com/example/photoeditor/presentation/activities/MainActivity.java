package com.example.photoeditor.presentation.activities;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.photoeditor.R;
import com.example.photoeditor.bussinesLogic.controllers.UserController;

public class MainActivity extends AppCompatActivity {
    private EditText usernameLogin;
    private EditText passwordLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameLogin = (EditText)findViewById(R.id.username);
        passwordLogin = (EditText)findViewById(R.id.password);
    }


    public void Login(View view) {
        int duration = Toast.LENGTH_SHORT;

        final String username = usernameLogin.getText().toString();
        final String password = passwordLogin.getText().toString();



        UserController loginController = new UserController(MainActivity.this);
        loginController.login(username, password);
    }
    public void Register(View view){
        Intent i= new Intent(this, RegisterActivity.class);
        this.startActivity(i);
    }

    public void attemptLogin(String name, boolean ok) {
        if (ok){
            //extrae informacion del JSON
            Toast.makeText(getApplicationContext(),
                    "Welcome" +"    "+ name, Toast.LENGTH_SHORT).show();

            Intent i = new Intent(MainActivity.this, HomeActivity.class);
            i.putExtra("name",name);

            MainActivity.this.startActivity(i);
            //LoginActivity.this.finish();
        }else{
            AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
            alerta.setMessage("FAIL LOGIN: User does not exist or password is wrong")
                    .setNegativeButton("Retry",null)
                    .create()
                    .show();

        }
    }
}
