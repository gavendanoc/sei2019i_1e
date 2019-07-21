package com.example.photoeditor.presentation.activities.CardControl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Switch;
import android.widget.TextView;

import com.example.photoeditor.R;
import com.example.photoeditor.bussinesLogic.controllers.PermissionsController;
import com.example.photoeditor.dataAccess.models.pojos.PermissionsJoinModel;

public class CardControlPermissions extends AppCompatActivity {
    private Switch statusPaid;
    private Switch statusRegular;
    private TextView parameterT;
    private PermissionsJoinModel permissionsModel;
    private PermissionsController permissionsController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.statusPaid = (Switch) findViewById(R.id.statusPaid);
        this.statusRegular = (Switch) findViewById(R.id.statusRegular);
        this.parameterT= (TextView) findViewById(R.id.parameterTextF);
        permissionsModel= new PermissionsJoinModel();
        permissionsModel.setId(Integer.parseInt(parameterT.getText().toString()));
        permissionsController= new PermissionsController(this);
    }

    public Switch getStatusPaid() {
        return statusPaid;
    }
    public Switch getStatusRegular() {
        return statusRegular;
    }

    public void setStatusPaid(Switch status) {
        this.statusPaid = status;
    }
    public void setStatusRegular(Switch status) {
        this.statusRegular = status;
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

    public TextView getParameterT() {
        return parameterT;
    }

    public void setParameterT(TextView permissionsT) {
        this.parameterT = parameterT;
    }
}
