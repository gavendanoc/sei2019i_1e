package com.example.photoeditor.presentation.activities;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import com.example.photoeditor.R;
import com.example.photoeditor.bussinesLogic.controllers.UserController;
import com.example.photoeditor.dataAccess.models.UserModel;

/*public class CardControlActivity extends AppCompatActivity {
    private Switch payment;
    private TextView usuario;
    private UserModel user;
    private UserController userController;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.payment = (Switch) findViewById(R.id.Payment);
        this.usuario= (TextView) findViewById(R.id.userTextF);
        user= new UserModel();
        user.setUsername(usuario.getText().toString());
        userController= new UserController(this);
    }
    public void OnClickPayment(View view) {
        if (this.payment.isEnabled()) {
            user.setId_role(4);
        } else {
            user.setId_role(3);
        }
        userController.updateUser(user.getId_role(),user.getUsername());
    }

}
*/