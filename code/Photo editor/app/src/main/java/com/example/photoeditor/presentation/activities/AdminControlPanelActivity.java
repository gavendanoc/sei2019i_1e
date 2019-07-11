package com.example.photoeditor.presentation.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.photoeditor.R;

public class AdminControlPanelActivity extends AppCompatActivity {
    private Bundle name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_control_panel);
        name=getIntent().getExtras();
        String nameAdmin= name.getString("name");
        TextView welcome= (TextView) findViewById(R.id.adminName);
        welcome.setText("Bienvenido"+ nameAdmin);
    }
    public void roleDefinition(View view){
        Intent roles= new Intent(this,RolesDisplayActivity.class);
        startActivity(roles);

    }
    public void availableFilters(View view){
        Intent roles= new Intent(this,PermissionsDisplayActivity.class);
        startActivity(roles);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        alerta.setMessage("¿Está seguro de que desea cerrar sesión?")
                .setNegativeButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent back= new Intent(AdminControlPanelActivity.this, MainActivity.class);
                        startActivity(back);
                    }
                })
                .create()
                .show();
    }
}
