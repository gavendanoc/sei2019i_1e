package com.example.photoeditor.presentation.activities.Adapters;

import android.content.Context;
import android.preference.TwoStatePreference;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.example.photoeditor.R;
import com.example.photoeditor.bussinesLogic.controllers.PermissionsController;
import com.example.photoeditor.dataAccess.models.pojos.PermissionsJoinModel;

import java.util.ArrayList;

public class PermissionsAdapter extends RecyclerView.Adapter<PermissionsAdapter.ViewHolderGen> {

    ArrayList<PermissionsJoinModel> permissionsList;
    Context context;
    public PermissionsAdapter(ArrayList<PermissionsJoinModel> permissionsList , Context context) {
        this.permissionsList = permissionsList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderGen onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_card_control_permissions, viewGroup, false);
        return new ViewHolderGen(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolderGen viewHolderGen, int i) {
        final PermissionsJoinModel permissionsModel= permissionsList.get(i);
       // viewHolderGen.idPermissions.setText(Integer.toString(permissionsModel.getId()));
        viewHolderGen.typeRole.setText(permissionsModel.getroleType());
        viewHolderGen.parametersName.setText(permissionsModel.getparameterName());
        viewHolderGen.id=permissionsModel.getId();

        if (permissionsModel.getStatus() == 1) {
            viewHolderGen.status.setChecked(true);
        }
        viewHolderGen.status.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
           //     permissionsModel.setId(Integer.parseInt(viewHolderGen.idPermissions.getText().toString()));
                permissionsModel.setId(viewHolderGen.id);
                if (b) {
                    permissionsModel.setStatus(1);
                } else {
                    permissionsModel.setStatus(0);
                }

                permissionsModel.setId(getById(permissionsModel.getId()));



                viewHolderGen.permissionsController.updatePermissions(permissionsModel.getStatus(), permissionsModel.getId());
            }
        });
    }

    private int getById(int id) {
        for (int i=0; i<permissionsList.size();i++){
            if(id==permissionsList.get(i).getId()){
                return permissionsList.get(i).getId();
            }
        }
        return 0;
    }

    @Override
    public int getItemCount() {
        if(this.permissionsList.isEmpty()){
            return 0;
        }
        return this.permissionsList.size();
    }

    public class ViewHolderGen extends RecyclerView.ViewHolder {
        Switch status;
        TextView idPermissions;
        TextView typeRole;
        TextView parametersName;
        int id;



        PermissionsController permissionsController;
        public ViewHolderGen(@NonNull View itemView) {
            super(itemView);
            status =(Switch) itemView.findViewById(R.id.status);
           // idPermissions = (TextView) itemView.findViewById(R.id.permissionsTextF);
            typeRole = (TextView) itemView.findViewById(R.id.typeTextF);
            parametersName = (TextView) itemView.findViewById(R.id.parameterTextF);
            permissionsController = new PermissionsController(context);
            id= 0;

        }
    }
}