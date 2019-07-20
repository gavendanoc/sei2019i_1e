package com.example.photoeditor.presentation.activities.CardControl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import com.example.photoeditor.R;
import com.example.photoeditor.bussinesLogic.controllers.PermissionsController;
import com.example.photoeditor.bussinesLogic.controllers.UserController;
import com.example.photoeditor.dataAccess.models.PermissionsModel;
import com.example.photoeditor.dataAccess.models.UserModel;
import com.example.photoeditor.dataAccess.models.pojos.PermissionsJoinModel;

public class CardControlPermissions extends AppCompatActivity {
    private Switch status;
    private TextView permissionsT;
    private PermissionsJoinModel permissionsModel;
    private PermissionsController permissionsController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.status = (Switch) findViewById(R.id.status);
        this.permissionsT= (TextView) findViewById(R.id.permissionsTextF);
        permissionsModel= new PermissionsJoinModel();
        permissionsModel.setId(Integer.parseInt(permissionsT.getText().toString()));
        permissionsController= new PermissionsController(this);
        status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("CLICKED");
                if (status.isEnabled()) {
                    permissionsModel.setStatus(1);
                } else {
                    permissionsModel.setStatus(0);
                }
              //  permissionsController.updatePermissions(TODO);
            }
        });

    }

    public Switch getStatus() {
        return status;
    }

    public void setStatus(Switch status) {
        this.status = status;
    }

    public PermissionsController getPermissionsController() {
        return permissionsController;
    }

    public void setPermissionsController(PermissionsController permissionsController) {
        this.permissionsController = permissionsController;
    }

    public PermissionsJoinModel getPermissionsModel() {
        return permissionsModel;
    }

    public void setPermissionsModel(PermissionsJoinModel permissionsModel) {
        this.permissionsModel = permissionsModel;
    }

    public TextView getPermissionsT() {
        return permissionsT;
    }

    public void setPermissionsT(TextView permissionsT) {
        this.permissionsT = permissionsT;
    }
}
