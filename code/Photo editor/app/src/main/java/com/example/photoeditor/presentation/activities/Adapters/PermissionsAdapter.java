package com.example.photoeditor.presentation.activities.Adapters;

import android.content.Context;
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
import com.example.photoeditor.dataAccess.models.pojos.PermissionsCardModel;


import java.util.ArrayList;

public class PermissionsAdapter extends RecyclerView.Adapter<PermissionsAdapter.ViewHolderGen> {

    ArrayList<PermissionsCardModel> permissionsList;
    Context context;
    public PermissionsAdapter(ArrayList<PermissionsCardModel> permissionsList , Context context) {
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
        final PermissionsCardModel permissionsModel= permissionsList.get(i);
        viewHolderGen.parametersName.setText(permissionsModel.getNameParameter());

        viewHolderGen.idPaid= permissionsModel.getIdPermissionsPaidUser();
        viewHolderGen.idRegular= permissionsModel.getIdPermissionsRegularUser();

        if (permissionsModel.getStatusPermissionsPaidUser()== 1) {
            viewHolderGen.statusPaid.setChecked(true);
        }
        if (permissionsModel.getStatusPermissionsRegularUser()== 1) {
            viewHolderGen.statusRegular.setChecked(true);
        }




        viewHolderGen.statusRegular.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                permissionsModel.setIdPermissionsRegularUser(viewHolderGen.idRegular);
                if (b) {
                    permissionsModel.setStatusPermissionsRegularUser(1);
                } else {
                    permissionsModel.setStatusPermissionsRegularUser(0);
                }

                permissionsModel.setIdPermissionsRegularUser(getByIdRegular(permissionsModel.getIdPermissionsRegularUser()));



                viewHolderGen.permissionsController.updatePermissions(permissionsModel.getStatusPermissionsRegularUser(), permissionsModel.getIdPermissionsRegularUser());
            }
        });

        viewHolderGen.statusPaid.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                permissionsModel.setIdPermissionsPaidUser(viewHolderGen.idPaid);
                if (b) {
                    permissionsModel.setStatusPermissionsPaidUser(1);
                } else {
                    permissionsModel.setStatusPermissionsPaidUser(0);
                }
                permissionsModel.setIdPermissionsPaidUser(getByIdPaid(permissionsModel.getIdPermissionsPaidUser()));
                viewHolderGen.permissionsController.updatePermissions(permissionsModel.getStatusPermissionsPaidUser(), permissionsModel.getIdPermissionsPaidUser());
            }
        });


    }
    private int getByIdRegular(int id) {
        for (int i=0; i<permissionsList.size();i++){
            if(id==permissionsList.get(i).getIdPermissionsRegularUser()){
                return permissionsList.get(i).getIdPermissionsRegularUser();
            }
        }
        return 0;
    }
    private int getByIdPaid(int id) {
        for (int i=0; i<permissionsList.size();i++){
            if(id==permissionsList.get(i).getIdPermissionsPaidUser()){
                return permissionsList.get(i).getIdPermissionsPaidUser();
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
        Switch statusPaid;
        Switch statusRegular;
        TextView parametersName;
        int idPaid;
        int idRegular;



        PermissionsController permissionsController;
        public ViewHolderGen(@NonNull View itemView) {
            super(itemView);
            statusPaid =(Switch) itemView.findViewById(R.id.statusPaid);
            statusRegular =(Switch) itemView.findViewById(R.id.statusRegular);
            parametersName = (TextView) itemView.findViewById(R.id.parameterTextF);
            permissionsController = new PermissionsController(context);
            idPaid= 0;
            idRegular=0;

        }
    }
}